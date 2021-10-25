inherit guest-kernel-module

do_install:aglcontainerguest:append() {
    # Install shared header file to ${includedir}
    install -m 644 ${S}/vsp2driver/linux/vsp2.h ${D}/${includedir}/
}

PACKAGES:append:aglcontainerguest = " ${PN}-dev"
FILES_${PN}-dev:aglcontainerguest += "${includedir}"
