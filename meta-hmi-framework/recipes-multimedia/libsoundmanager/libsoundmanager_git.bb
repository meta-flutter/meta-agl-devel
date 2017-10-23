SUMMARY     = "Sound Manager client library for applications"
HOMEPAGE    = "https://wiki.automotivelinux.org/soundmanager"
SECTION = "multimedia"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"
DEPENDS = "af-binder json-c"
RDEPENDS_${PN} = "agl-service-soundmanager-2017"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/libsoundmanager.git;protocol=https;branch=master"
SRCREV = "5e5eb5cdf5684ab47d9d4e91833ed27e29215479"
S = "${WORKDIR}/git"

inherit cmake
