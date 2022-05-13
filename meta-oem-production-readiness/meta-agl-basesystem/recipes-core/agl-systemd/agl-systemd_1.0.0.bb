SUMMARY = "Systemd related file for launching sample application"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/agl-systemd"

inherit systemd

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${sysconfdir}/systemd/system/
    install -m 644 ${S}/launch_sm.service ${D}${sysconfdir}/systemd/system/
    install -m 644 ${S}/systemd-udev-trigger.service ${D}${sysconfdir}/systemd/system/
    install -m 644 ${S}/setup_refhw.service ${D}${sysconfdir}/systemd/system/

    install -d ${D}${CONFDIR}/
    install -m 644 ${S}/env.txt ${D}${CONFDIR}/

    install -d ${D}${bindir}
    install -m 755 ${S}/tool_9E_SI/*.sh ${D}${bindir}/

    install -d ${D}${libdir}/udev/rules.d
    install -m 644 ${S}/99-basesystem.rules ${D}/${libdir}/udev/rules.d/
}

RDEPENDS:${PN} += "bash"

SYSTEMD_SERVICE:${PN} = " \
    launch_sm.service \
    systemd-udev-trigger.service \
    setup_refhw.service \
"
