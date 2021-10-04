SUMMARY     = "Momiyama mediaplayer example based on AGL sample app. at CC"
DESCRIPTION = "The momiplay is a mediaplayer example based on AGL sample app. \
               The momiplay is not require agl-appfw."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://main.cpp;beginline=1;endline=17;md5=f4ad6901289f57f62d15bfefb5cc3633"

PV = "0.2.0"

inherit qmake5 systemd

DEPENDS = "qtbase qtquickcontrols2 qtgraphicaleffects qtsvg qtmultimedia "
RDEPENDS_${PN} = "qtsvg qtmultimedia "

SRC_URI = "git://github.com/AGLExport/momiplayer.git;protocol=https \
           file://momiplay.service \
           file://momiplay \
          "
SRCREV = "b4715bf924ea295feaaf8fbdb4a9c3da75f57591"

S = "${WORKDIR}/git"

QT_INSTALL_PREFIX = "/usr"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "momiplay.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

do_install_append() {
	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/momiplay.service ${D}/lib/systemd/system

	install -m 0755 -d ${D}${sysconfdir}/default/
	install -m 0755 ${WORKDIR}/momiplay ${D}${sysconfdir}/default/
}

FILES_${PN} += " ${systemd_unitdir} ${sysconfdir}/*/* "
