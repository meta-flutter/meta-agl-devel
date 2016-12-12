The OEM needs library for AGL
======================================================

There are some software package that the OEM needs, but not exist in the AGL source.  
This layer is add OEM needs library for AGL.  

The software packages list:
 * boost
 * fixesproto
 * imagemagick
 * iptables
 * Xorg-macros
 * zlib
 * eglibc = glibc
 * libcurl
 * libgif
 * libneon
 * mongoose
 * fuse
 * protocol buffers
 * bsdiff
 * module-init-tools
 * libcroco
 * libtiff
 * librsvg
 * libpcap

Quick start guide
-----------------
To Add these library by add the feature 'agl-oem-extra-libs'

1. Before build you need prepare agl layers:
 * You can read it at meta-agl/README-AGL.md

2. build the agl-demo-platform with 'agl-oem-extra-libs':

```bash
source meta-agl/scripts/aglsetup.sh -m qemux86-64 agl-demo [agl-appfw-smack] [agl-devel] [agl-netboot] agl-oem-extra-libs
```

3. Build agl-demo-platform

```bash
bitbake agl-demo-platform
```

Supported Machines
------------------

Reference hardware:

* QEMU (x86-64) - emulated machine: qemux86-64
* Renesas R-Car Gen2 (R-Car M2) - machine: porter

