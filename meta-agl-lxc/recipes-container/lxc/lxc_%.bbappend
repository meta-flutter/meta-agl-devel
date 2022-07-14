PACKAGECONFIG:remove = "templates"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://lxc.service \
    file://lxc-net.service \
    "

do_install:append () {
    for service in lxc.service lxc-net.service; do
        install -D -m 0644 ${WORKDIR}/$service ${D}${systemd_system_unitdir}/$service
        sed -i -e 's,@LIBEXECDIR@,${libexecdir},g' ${D}${systemd_system_unitdir}/$service
    done
}

# NOTE:
# This needs to be replaced with a rework of the upstream packaging
# to do a proper split of core from the template support.
RDEPENDS:${PN} = ""



