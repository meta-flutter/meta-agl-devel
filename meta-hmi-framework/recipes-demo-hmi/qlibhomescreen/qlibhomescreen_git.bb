SUMMARY     = "A wrapper library of libhomescreen for Qt Application in AGL"
SECTION     = "libs"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS = "qtbase libhomescreen"
RDEPENDS_${PN} = "libhomescreen"

inherit qmake5

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/libqthomescreen.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "0d7f000588954006d4687c97c19b424769189f9f"
S = "${WORKDIR}/git"
