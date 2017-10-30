SUMMARY     = "Window Manager client library for applications"
SECTION = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
DEPENDS = "af-binder json-c"
RDEPENDS_${PN} = "agl-service-windowmanager-2017"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/libwindowmanager.git;protocol=https;branch=master"
SRCREV = "922255ac97240980059979ab7975118f46c950a0"
S = "${WORKDIR}/git"

inherit cmake
