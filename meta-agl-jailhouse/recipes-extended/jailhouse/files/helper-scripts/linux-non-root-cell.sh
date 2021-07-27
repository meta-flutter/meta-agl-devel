#!/bin/sh

# For Networking
dhclient enp0s2

# For Enabling the Root-Cell
jailhouse enable /usr/share/jailhouse/cells/qemu-agl.cell

# For loading the Non-Root cell
jailhouse cell linux /usr/share/jailhouse/cells/agl-linux-x86-demo.cell bzImage -i rootfs.cpio -w out.file -c "console=ttyS2,115200 earlycon earlyprintk"

<<DEMO

qemux86-64:~# ./linux-non-root-cell.sh
Boot parameters written. Start Linux with the following commands (adjusting paths as needed):

jailhouse cell create /usr/share/jailhouse/cells/agl-linux-x86-demo.cell
jailhouse cell load linux-x86-demo linux-loader.bin -a 0x0 bzImage -a 0xffc600 rootfs.cpio -a 0x3d89000 out.file -a 0x1000
jailhouse cell start linux-x86-demo

DEMO
