SUMMARY = "ns-frameworkunified library for AGL software"
DESCRIPTION = "ns-frameworkunified library to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ns-loglibrary \
    libxml2 \
    ns-frameworkunified \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/native/framework_unified"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.library"

RDEPENDS_${PN} += " \
    os-posixbasedos001legacylibrary \
    ns-loglibrary \
    ns-commonlibrary \
"
