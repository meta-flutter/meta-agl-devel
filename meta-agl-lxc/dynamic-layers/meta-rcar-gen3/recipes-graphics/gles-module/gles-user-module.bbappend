RDEPENDS:${PN}:remove:aglcontainerguest = "kernel-module-gles"

PACKAGES:prepend = "\
    ${PN}-firmware \
"

FILES:${PN} = " \
    ${libdir}/* \
    ${sysconfdir}/* \
    ${RENESAS_DATADIR}/bin/dlcsrv_REL \
"
SYSTEMD_SERVICE:${PN} = ""

FILES:${PN}-firmware = " \
    ${systemd_system_unitdir}/* \
    ${sysconfdir}/udev/* \
    /lib/firmware/* \
    ${exec_prefix}/bin/pvrinit \
"
SYSTEMD_SERVICE:${PN}-firmware = "rc.pvr.service"
SYSTEMD_PACKAGES = "${PN}-firmware"
SYSTEMD_AUTO_ENABLE = "enable"
