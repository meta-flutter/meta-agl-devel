SUMMARY     = "Window Manager client library for applications"
DESCRIPTION = "Window Manager client library for application built with recipe"
SECTION     = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS = "af-binder json-c"
RDEPENDS_${PN} = "agl-service-windowmanager-2017"

inherit cmake

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/libwindowmanager.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "123846779a13f2c8e9742168c1c9384c6dfa5d05"
S = "${WORKDIR}/git"
