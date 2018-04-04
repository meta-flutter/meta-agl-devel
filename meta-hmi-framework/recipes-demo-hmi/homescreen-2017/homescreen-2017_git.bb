SUMMARY     = "AGL Home Screen 2017 Application"
DESCRIPTION = "AGL Home Screen 2017 Application build with recipe method"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/gitweb?p=staging/homescreen-2017.git"
SECTION     = "apps"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://homescreen/LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "\
        qtbase \
        qtdeclarative \
        qtquickcontrols2 \
        pulseaudio \
        agl-service-homescreen-2017 \
        agl-service-windowmanager-2017 \
        agl-service-weather \
        libqtappfw \
        qlibwindowmanager \
        virtual/libhomescreen \
"

inherit qmake5 systemd pkgconfig aglwgt

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/homescreen-2017;protocol=https;branch=${AGL_BRANCH}"
SRCREV  = "${AGL_APP_REVISION}"

PV      = "1.0+git${SRCPV}"
S       = "${WORKDIR}/git/"

PATH_prepend = "${STAGING_DIR_NATIVE}${OE_QMAKE_PATH_QT_BINS}:"
