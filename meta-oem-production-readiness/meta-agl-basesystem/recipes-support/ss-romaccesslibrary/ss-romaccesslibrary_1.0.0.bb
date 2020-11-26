SUMMARY = "ss-romaccesslibrary for AGL software"
DESCRIPTION = "ss-romaccesslibrary to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-memorygpioaccesslibrary \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/system/rom_access_library"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.client"

FILES_${PN} += "${libdir}/*"

RDEPENDS_${PN} += " \
    ns-frameworkunified \
    ns-commonlibrary \
    ns-memorygpioaccesslibrary \
"
