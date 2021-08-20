# DRM lease support layer

This yocto layer adds support for using DRM leases to partition display
controller output resources between multiple processes.

This layer adds a drm-lease-manager deamon (with systemd configuration)
and a client library for receiving DRM leases from the daemon. For more details
the DRM lease manager and client see the repository at
(https://gerrit.automotivelinux.org/gerrit/gitweb?p=src/drm-lease-manager.git)

## Setup

Enable the  `agl-drm-lease` AGL feature when setting up your build environment
with aglsetup.sh.

This will add the `drm-lease-manager` package to the image, and will add DRM
lease support to the following packages:
 * weston
 * kmscube

`kmscube` is not included in the image by default. To add the package to the
image, add the following to your local.conf

```
IMAGE_INSTALL:append = " kmscube"
```

## Starting the DRM lease manager

The drm-lease-manager must be the only process to directly open the DRM device.
Shut down any running window systems (eg. weston or agl-compositor) and run:

```
  # systemctl start drm-lease-manager
```

This will create 1 lease for each output connection on the platform.
The name of each lease will be in the form of `card0-<output name>`
(eg. `card0-LVDS-1` or `card0-HDMI-A-1`)

## Running weston

weston can be started on any available DRM lease by running with the
`--drm-lease=<lease name>` option. Eg:
```
  # weston --drm-lease=card0-HDMI-A-1
```

## Running kmscube sample

With the `drm-lease-manager` running `kmscube` can display on any available
lease by running with the `-L -D<lease name>` options. Eg:

```
  # kmscube -L -Dcard0-HDMI-A-1
```

Multiple kmscube instances (one per DRM lease) can be started at the same time.

## Tested targets

This layer has been tested on the Renesas R-Car Gen3 platform.  Other platforms
supporting the Linux DRM API may work as well.
