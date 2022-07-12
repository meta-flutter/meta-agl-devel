PACKAGECONFIG:remove = "templates"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://lxc.service"

do_install:append () {
    install -D -m 0644 ${WORKDIR}/lxc.service ${D}${systemd_system_unitdir}/lxc.service
    sed -i -e 's,@LIBEXECDIR@,${libexecdir},g' ${D}${systemd_system_unitdir}/lxc.service
}

# NOTE:
# This needs to be replaced with a rework of the upstream packaging
# to do a proper split of core from the template support.
RDEPENDS:${PN} = ""



