## Jailhouse support layer


Yocto layer that enables the use of the Jailhouse partitioning hypervisor - <https://github.com/siemens/jailhouse>.

### How to Enable and Use

### For QEmu x86_64

> Note: Right now the below setup is only working for Intel Machines.

The AGL feature `agl-jailhouse` has to be enabled. That needs to be done when including aglsetup.sh, for example:

```sh
$ source meta-agl/scripts/aglsetup.sh -m qemux86-64 -b build agl-devel agl-jailhouse
```

That will enable this layer and include the `jailhouse` package in the image.


Then, in the target system, the cell configurations (*.cell) are placed in `/usr/share/jailhouse/cells/` and the demo inmates (bare-metal applications to run in a non-root cell) are located in `/usr/share/jailhouse/inmates`.


After that follow the [AGL-Documentation](https://docs.automotivelinux.org/en/master/#0_Getting_Started/2_Building_AGL_Image/2_Downloading_AGL_Software/) as usual and build the image using `bitbake core-image-minimal`.


After successfully building the image we need to QEmulate the Image using `runqemu`:


```sh

$ runqemu qemux86-64 slirp kvm publicvnc serial bootparams="verbose ipv6.disable=1 intel_iommu=off"

```

After successful emulation of the Image, you will see something similar to this:


```sh

[ 0.021231] [Firmware Bug]: TSC_DEADLINE disabled due to Errata; please update microcode to version: 0xb2 (or later)

[ 0.588075] kvm: already loaded the other module

[ 0.926525] hdaudio hdaudioC0D0: Unable to bind the codec

Automotive Grade Linux 11.91.0 qemux86-64 ttyS0

qemux86-64 login: root

```

### For Running the Linux Cell


In order to spin-up the Root cell and Inmates, you will need Cell Configurations (*.cell) and Inmates, which you will find at `/usr/share/jailhouse/cell` and `/usr/share/jailhouse/inmates`.


But for Linux-Cell some preparation is needed and the things which you will require include:


- `bzImage`

- `rootfs.cpio`


These files you can find easily in the `build/tmp/deploy/images/qemux86-64/`.

After obtaining these files you have to `scp` these to the emulated Image.

Now you should have everything in the target system and you can now spin up the things but before that check, if `jailhouse` is present or not:

```sh

qemux86-64:~# lsmod

Module Size Used by

jailhouse 36864 0

```
As you can see it’s showing present, In case if it’s not present then run `modprobe jailhouse`, it will load the Jailhouse kernel module.

After loading the module now we have to enable the Jailhouse-Root-Cell, enable this by the below command:

```sh

qemux86-64:~# jailhouse enable /usr/share/jailhouse/cells/qemu-agl.cell

```

 And check the console for the logs.

After loading jailhouse Root-cell, now we have to load the Non-root Linux cell, so for that run the below commands:


```sh

qemux86-64:~# jailhouse cell linux /usr/share/jailhouse/cells/agl-linux-x86-demo.cell bzImage -i rootfs.cpio -w out.file -c "console=ttyS2,115200 earlycon earlyprintk"

```


> Note: In the above command, when you add the `-w out.file` option then it will spit out some commands to start the non-root cell, if not then the cell will boot as usual. Those spitted out commands would look something like these below, you have to run it one by one:



```sh

qemux86-64:~# jailhouse cell create /usr/share/jailhouse/cells/agl-linux-x86-demo.cell

qemux86-64:~# jailhouse cell load linux-x86-demo linux-loader.bin -a 0x0 bzImage -a 0xffc600 rootfs.cpio -a 0x3d89000 out.file -a 0x1000

qemux86-64:~# jailhouse cell start linux-x86-demo.cell

```

> Note: As you can see in the spit-out commands there is a `linux-loader.bin` is present, this is a tiny bootloader that is required to boot the Linux-inmate or Linux-non-root cell. It is located in `/usr/libexec/jailhouse/linux-loader.bin` in the Emulated Image.

After running the above commands you will see that Linux is booting in another console.

Some helper scripts are present to automate all this, and it can be found [here](https://gerrit.automotivelinux.org/gerrit/gitweb?p=AGL/meta-agl-devel.git;a=tree;f=meta-agl-jailhouse/recipes-extended/jailhouse/files/helper-scripts).


### For Testing Virtio over IVSHMEM Block

You can test the Virtio-block over IVSHMEM by following the steps below:

**This is for the Root-cell <---> Non-Root-Cell communication.**

First, you have to boot the Image and enable the `qemu-agl.cell` into the target system, as described in the above sections.

After that follow the below steps to get it spinning:

```sh

qemux86-64:~# jailhouse enable /usr/share/jailhouse/cells/qemu-agl.cell
qemux86-64:~# modprobe uio_ivshmem

```

After this check for the PCI device using `lspci -k`, you will see something like this below:

```sh

qemux86-64:~# lspci -k

.

.

.

00:0c.0 Unassigned class [ff80]: Siemens AG Device 4106

Subsystem: Siemens AG Device 4106

.

.

.

```

After confirming, run the below command, this will create a virtio block backend

```sh

qemux86-64:~# echo "110a 4106 110a 4106 ffc002 ffffff" >

/sys/bus/pci/drivers/uio_ivshmem/new_id

```

And after that, start the backend service like this:

```sh

qemux86-64:~# ./virtio-ivshmem-block /dev/uio0 disk.img

Waiting for peer to be ready...

```

After running the backend-service boot or reboot another cell, and backend will show something like this:

```sh

qemux86-64:~ # ./virtio-ivshmem-block /dev/uio0 disk.img

Waiting for peer to be ready...

Starting virtio device

device_status: 0x0

device_status: 0x1

device_status: 0x3

device_features_sel: 1

device_features_sel: 0

.

.

.

```

In the Non-Root-Linux, the disk will show up as /dev/vda and can be accessed normally.


>Note:
>- For the `virtio-ivshmem-block` you can find it in target system at `/usr/bin/`, if not then copy it from here `build/tmp/work-shared/qemux86-64/kernel-source/tools/virtio/virtio-ivshmem-block`.
>
>- For the `disk.img`, It needs to be a raw image. But its size matters as that defines the virtual disk size, but you may even leave it empty and only partition or format it from the front-end guest.
>
> e.g:
> 
> $ dd if=/dev/zero of=disk.img bs=1M count=1024
> 
> $ mkfs.ext4 disk.img


For manually configuring the setup, refer [`meta-agl-jailhouse.md`](meta-agl-jailhouse.md).
