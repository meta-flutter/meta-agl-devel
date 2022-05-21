SUMMARY     = "Momiyama mediaplayer example based on AGL sample app. at CC"
DESCRIPTION = "The momiplay is a mediaplayer example based on AGL sample app. \
               The momiplay is not require agl-appfw."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=f4ad6901289f57f62d15bfefb5cc3633"

DEPENDS = " \
    qtbase \
    qtquickcontrols2 \
    qtgraphicaleffects \
    qtsvg \
    qtmultimedia \
    "

PV = "0.2.0"

SRC_URI = "git://github.com/AGLExport/momiplayer.git;protocol=https;branch=master \
           file://momiplay.service \
           file://momiplay \
          "
SRCREV = "b4715bf924ea295feaaf8fbdb4a9c3da75f57591"

S = "${WORKDIR}/git"

inherit qmake5 systemd

QT_INSTALL_PREFIX = "/usr"

do_install:append() {
	install -d ${D}/${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/momiplay.service ${D}/${systemd_unitdir}/system

	install -m 0755 -d ${D}${sysconfdir}/default/
	install -m 0755 ${WORKDIR}/momiplay ${D}${sysconfdir}/default/
}

FILES:${PN} += " \
    ${systemd_unitdir} \
    ${sysconfdir}/*/* \
    "
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "momiplay.service"
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

RDEPENDS:${PN} = " \
    qtsvg \
    qtmultimedia \
    "
