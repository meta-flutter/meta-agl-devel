inherit guest-kernel-module

do_install:aglcontainerguest:append() {
    # Install shared header file
    install -m 644 ${S}/${VSPMIF_DRV_DIR}/include/vspm_if.h ${D}/${includedir}/
}
