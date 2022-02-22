SUMMARY     = "Momiyama navigation example based on mapbox."
DESCRIPTION = "The mominavi is a navigation example based on mapbox. It's based on aglqtnavigation. \
               The mominavi is not require agl-appfw."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = " \
    qtbase \
    qtquickcontrols2 \
    qtlocation \
    qtgraphicaleffects \
    qtsvg \
    qtwebsockets \
    "

PV = "0.2.0"

SRC_URI = "git://github.com/AGLExport/mominavi.git;protocol=https;branch=master \
           file://mominavi.service \
           file://mominavi \
          "
SRCREV = "553776e75da02b27224748756da55d38b6c7241f"

S = "${WORKDIR}/git"

inherit qmake5 systemd

MOMIMAP_MAPBOX_ACCESS_TOKEN ??= "YOU_NEED_TO_SET_IT_IN_LOCAL_CONF"
QT_INSTALL_PREFIX = "/usr"

do_configure:prepend() {
	if [ "${MOMIMAP_MAPBOX_ACCESS_TOKEN}" = "YOU_NEED_TO_SET_IT_IN_LOCAL_CONF" ]; then
		bbwarn "WARNING: You should set MapBox development key to MOMIMAP_MAPBOX_ACCESS_TOKEN variable in local.conf."
	fi
}
do_install:append() {
    install -d ${D}/lib/systemd/system
    install -m 0644 ${WORKDIR}/mominavi.service ${D}/lib/systemd/system

    install -m 0755 -d ${D}${sysconfdir}/default/
    install -m 0755 ${WORKDIR}/mominavi ${D}${sysconfdir}/default/

    echo 'MOMIMAP_MAPBOX_ACCESS_TOKEN=${MOMIMAP_MAPBOX_ACCESS_TOKEN}' >> ${D}${sysconfdir}/default/mominavi
}

FILES:${PN} += " \
    ${systemd_unitdir} \
    ${sysconfdir}/*/* \
    "
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "mominavi.service"

RDEPENDS:${PN} = " \
    qtsvg \
    qtwebsockets \
    qtlocation \
    "
