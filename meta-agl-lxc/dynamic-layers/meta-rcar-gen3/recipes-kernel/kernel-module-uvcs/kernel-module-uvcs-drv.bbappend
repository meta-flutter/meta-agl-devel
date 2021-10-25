inherit guest-kernel-module

do_install:aglcontainerguest:append() {
    # Install shared header file
    install -m 644 ${S}/include/uvcs_ioctl.h ${D}/${includedir}/
}
