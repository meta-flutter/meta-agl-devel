SUMMARY     = "A wrapper library of libwindowmanager for Qt Application in AGL"
SECTION     = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS = "qtbase libwindowmanager"
RDEPENDS_${PN} = "libwindowmanager"

inherit qmake5

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/libqtwindowmanager.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "744df8b7c6ccb4e2254e452eec82f5d0703417cf"
S = "${WORKDIR}/git"
PV = "1.0+git${SRCPV}"
