inherit guest-kernel-module

do_install:aglcontainerguest:append() {
    # Install shared header files to ${includedir}
    install -m 644 ${S}/${MMNGRBUF_DRV_DIR}/include/mmngr_buf_private_cmn.h ${D}/${includedir}/
}
