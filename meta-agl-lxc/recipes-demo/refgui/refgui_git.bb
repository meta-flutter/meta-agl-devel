DESCRIPTION = "AGL Cluster Reference GUI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2e73358b6893b535d5dfc7e89dc9d67"

DEPENDS = " \
    qttools-native \
    qtmultimedia \
"

BRANCH = "main"
SRC_URI = "git://github.com/agl-ic-eg/refgui;protocol=https;branch=${BRANCH} \
           file://cluster.service \
"
SRCREV = "e52dd81073154838e7f417e33debc8f6794fc683"

S = "${WORKDIR}/git"

inherit cmake cmake_qt5 systemd

# NOTE:
# The app currently assumes the mp4 video file is in the same
# directory, so changing this to ${bindir} to better match FHS
# requires code changes.
APP_DIR = "/opt/apps"
EXTRA_OECMAKE = "-DAPPS_INST_DIR=${APP_DIR}"

SYSTEMD_SERVICE_${PN} = "cluster.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/cluster.service ${D}${systemd_unitdir}/system/
}

FILES_${PN} += "${APP_DIR}/"

RDEPENDS_${PN} = " \
    qtbase \
    qtdeclarative \
    qt3d \
    qtgraphicaleffects \
    qtmultimedia \
    qtquickcontrols \
    qtquickcontrols2 \
    qtwayland \
"
