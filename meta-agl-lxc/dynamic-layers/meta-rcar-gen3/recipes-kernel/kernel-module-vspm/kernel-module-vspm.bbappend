inherit guest-kernel-module

do_install:aglcontainerguest:append() {
    # Install shared header files
    install -m 644 ${S}/${VSPM_DRV_DIR}/include/vspm_cmn.h ${D}/${includedir}/
    install -m 644 ${S}/${VSPM_DRV_DIR}/include/vsp_drv.h ${D}/${includedir}/
    install -m 644 ${S}/${VSPM_DRV_DIR}/include/fdp_drv.h ${D}/${includedir}/
}
