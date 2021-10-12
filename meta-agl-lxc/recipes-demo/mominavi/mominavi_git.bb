SUMMARY     = "Momiyama navigation example based on mapbox."
DESCRIPTION = "The mominavi is a navigation example based on mapbox. It's based on aglqtnavigation. \
               The mominavi is not require agl-appfw."
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

PV = "0.2.0"

inherit qmake5 systemd

DEPENDS = "qtbase qtquickcontrols2 qtlocation qtgraphicaleffects qtsvg qtwebsockets "
RDEPENDS_${PN} = "qtsvg qtwebsockets qtlocation"

SRC_URI = "git://github.com/AGLExport/mominavi.git;protocol=https \
           file://mominavi.service \
           file://mominavi \
          "
SRCREV = "b427b70ecbf474bdd3e0802b7bcf779e77e8d2ef"

S = "${WORKDIR}/git"

MOMIMAP_MAPBOX_ACCESS_TOKEN ??= "YOU_NEED_TO_SET_IT_IN_LOCAL_CONF"

QT_INSTALL_PREFIX = "/usr"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "mominavi.service"

do_configure_prepend() {
	if [ "${MOMIMAP_MAPBOX_ACCESS_TOKEN}" = "YOU_NEED_TO_SET_IT_IN_LOCAL_CONF" ]; then
		bbwarn "WARNING: You should set MapBox development key to MOMIMAP_MAPBOX_ACCESS_TOKEN variable in local.conf."
	fi
}
do_install_append() {
	install -d ${D}/lib/systemd/system
	install -m 0644 ${WORKDIR}/mominavi.service ${D}/lib/systemd/system

	install -m 0755 -d ${D}${sysconfdir}/default/
	install -m 0755 ${WORKDIR}/mominavi ${D}${sysconfdir}/default/
	
	echo 'MOMIMAP_MAPBOX_ACCESS_TOKEN=${MOMIMAP_MAPBOX_ACCESS_TOKEN}' >> ${D}${sysconfdir}/default/mominavi
}

FILES_${PN} += " ${systemd_unitdir} ${sysconfdir}/*/* "


