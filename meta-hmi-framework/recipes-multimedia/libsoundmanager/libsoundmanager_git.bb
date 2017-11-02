SUMMARY     = "Sound Manager client library for applications"
DESCRIPTION = "Sound Manager client library for applications built with recipe"
HOMEPAGE    = "https://wiki.automotivelinux.org/soundmanager"
SECTION     = "multimedia"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "af-binder json-c"
RDEPENDS_${PN} = "agl-service-soundmanager-2017"

inherit cmake

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/libsoundmanager.git;protocol=https;branch=master"
SRCREV = "cda4a958e85d397bae142fbe6068a3e17d4aa935"
S = "${WORKDIR}/git"
