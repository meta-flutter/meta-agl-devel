# meta-agl-flutter

_This documentation is expecting user to be running Ubuntu 20.04_

## Steps to build `agl-ivi-demo-platform-flutter` image

```
    export AGL_TOP=$HOME/workspace_agl
    mkdir -p $AGL_TOP && cd $AGL_TOP
    repo init -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo -b master
    repo sync -j $(nproc)
    source meta-agl/scripts/aglsetup.sh -m qemux86-64 agl-demo agl-flutter
    bitbake agl-ivi-demo-platform-flutter
```

This builds AGL demo image that includes Flutter runtime=release.


## Steps to build a minimal flutter image

```
    export AGL_TOP=$HOME/workspace_agl
    mkdir -p $AGL_TOP && cd $AGL_TOP
    repo init -u https://gerrit.automotivelinux.org/gerrit/AGL/AGL-repo -b master
    repo sync -j `grep -c ^processor /proc/cpuinfo`
    source meta-agl/scripts/aglsetup.sh -m qemux86-64 agl-devel agl-flutter agl-demo
```

Build one of the minimal Flutter images below using `bitbake`

1. `agl-image-flutter-runtimedebug`
  * includes Flutter Engine SDK
  * includes SSH server
  * live debugging with target via host

2. `agl-image-flutter-runtimeprofile`
  * includes Flutter Engine SDK
  * includes SSH server
  * runs only Flutter Applications built as AOT profile images
  * live profiling with target via host

3. `agl-image-flutter-runtimerelease`
  * includes Flutter Engine SDK
  * runs only Flutter Applications built as AOT release images
  * Does not include SSH server


## Flutter Engine SDK

If recipe `flutter-engine-runtime<variant>-sdk-dev` is included in your AGL image, `engine_sdk.zip` will be present in `/usr/share/flutter/`.

engine_sdk.zip contains
* sdk/flutter_sdk.version - The Flutter SDK version
* sdk/engine.version - The git commit of the Flutter Engine
* sdk/clang_x64/gen_snapshot - used for creating release/profile AOT image

This recipe should be excluded from image in a production release.


## Flutter Workspace Automation

```
    mkdir -p <path to my workspace> && cd <path to my workspace>
    curl --proto '=https' --tlsv1.2 -sSf https://raw.githubusercontent.com/meta-flutter/meta-agl-devel/main/meta-agl-flutter/tools/flutter_workspace_config.json -o flutter_workspace_config.json
    curl --proto '=https' --tlsv1.2 -sSf https://raw.githubusercontent.com/meta-flutter/meta-flutter/kirkstone/tools/setup_flutter_workspace.py | python3
```

Additional documentation available [here](https://github.com/meta-flutter/meta-flutter/tree/kirkstone/tools#flutter-workspace-automation)


## Startup Service

If you include `flutter-gallery-runtime<variant>-init` it will install a systemd user service, which starts the Flutter Gallery on boot.  This is not included in the minimal images.

At runtime you can edit `/usr/share/flutter/default.json` to point to any Flutter bundle.


## `/usr/share/flutter/default.json`

For more JSON key value options see [here](https://github.com/toyota-connected/ivi-homescreen/blob/agl/README.md#json-configuration-keys)


## Steps to Test Flutter Images

### Debug

1. Set up Flutter Workspace per [Flutter Workspace Automation](#flutter-workspace-automation).

2. Run  the following commands on the host's terminal, a QEMU window and a new terminal for AGL will be brought up.

```
    cd $FLUTTER_WORKSPACE
    source ./setup_env.sh
    qemu_run
```

3. If running an updated QEMU image, edit `~/.ssh/known_hosts` and remove previous connection.

4. Wait for QEMU image to boot to idle the run
```
    ssh -p 2222 root@localhost who
```
_Answering with `y` appends QEMU connection to `~/.ssh/known_hosts`_

5.  From the same host terminal open Visual Studio Code Select
   * **Run and Debug**
   * **gallery(AGL-qemu)** from the drop down combo box
   * **run** - this launches the Flutter gallery app in the QEMU window​

6.  Or run from the same terminal as qemu_run was executed via
```
    cd $FLUTTER_WORKSPACE/app/gallery
    flutter run -device-id=AGL-qemu
```


### Release

1.  Change AGL-qemu flutter_runtime value in $AGL_TOP/sources/meta-agl-devel/meta-agl-flutter/tools/flutter_workspace_config.json to `release`.

```
		{
			"id": "AGL-qemu",
			"type": "qemu",
			"arch": "x86_64",
			"flutter_runtime": "release",
			"runtime": {
```

This enables download of QEMU `release` variant.

2. Run the flutter workspace script
   
3. Run  the following commands on the host's terminal, a QEMU window and a new terminal for AGL will be brought up.

```
    cd $FLUTTER_WORKSPACE
    source ./setup_env.sh
    qemu_run
```

4. If running an updated QEMU image, edit `~/.ssh/known_hosts` and remove previous connection.

5. After waiting for QEMU image to boot to idle issue
```
    ssh -p 2222 root@localhost who
```
Answering with `y` appends QEMU connection to `~/.ssh/known_hosts`

6.  Login AGL as `agl-driver`, and run the Flutter Gallery example with the command in AGL's terminal
```
	flutter-auto --b=/usr/share/flutter/gallery –f
```


### Profile

1.  Change AGL-qemu flutter_runtime value in $AGL_TOP/sources/meta-agl-devel/meta-agl-flutter/tools/flutter_workspace_config.json to `profile`.

```
		{
			"id": "AGL-qemu",
			"type": "qemu",
			"arch": "x86_64",
			"flutter_runtime": "profile",
			"runtime": {
```

This enables download of QEMU `profile` variant.

2. Run the flutter workspace script

3. Run  the following commands on the host's terminal, a QEMU window and a new terminal for AGL will be brought up.

``` 
cd $FLUTTER_WORKSPACE
source ./setup_env.sh
qemu_run
```

4. If running an updated QEMU image, edit `~/.ssh/known_hosts` and remove previous connection.

5. After waiting for QEMU image to boot to idle issue
```
ssh -p 2222 root@localhost who
```
Answering with `y` appends QEMU connection to `~/.ssh/known_hosts`

6.  Login AGL as `agl-driver`, and issue the following command
 `flutter-auto --b=/usr/share/flutter/gallery --f --observatory-host=0.0.0.0 --observatory-port=1234`

The last line of the output message should look similar to this:
`flutter: The Dart VM service is listening on http://0.0.0.0:1234/xxxxxxxxxxx=/`

7. Run the following command in the host terminal, using the correct hash suffix.
	`flutter attach --device-id=AGL-qemu --debug-url=	http://127.0.0.1:1234/xxxxxxxxxxx=/` 
​
8.   Then you should see the output as below. It tells us the URL of the Flutter DevTools debugger and profiler on AGL x86_64 QEMU Image.
`An Observatory debugger and profiler on AGL x86_64 QEMU Image is available at: http://127.0.0.1:37383/xxxxxxxxxxx=/`
​
9.  Ctl+Click the second URL presented which will provide access to the Flutter DevTools debugger and profiler.
