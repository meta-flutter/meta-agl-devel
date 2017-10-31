SUMMARY     = "AGL Home Screen 2017 Application"
DESCRIPTION = "AGL Home Screen 2017 Application"
HOMEPAGE    = "https://gerrit.automotivelinux.org/gerrit/gitweb?p=staging/homescreen-2017.git"
S           = "${WORKDIR}/git/"
SECTION     = "apps"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://homescreen/LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

inherit qmake5 systemd pkgconfig aglwgt
DEPENDS = "\
        qtbase \
        qtdeclarative \
        qtquickcontrols2 \
        pulseaudio \
        agl-service-homescreen-2017 \
        agl-service-windowmanager-2017 \
        libhomescreen \
        libwindowmanager \
"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/homescreen-2017;protocol=https;branch=master"
SRCREV = "4940d001f08bec6fd68293efcbd6673a9ffce65e"

PATH_prepend = "${STAGING_DIR_NATIVE}${OE_QMAKE_PATH_QT_BINS}:"
