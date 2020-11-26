SUMMARY = "ns-memorygpioaccesslibrary for AGL software"
DESCRIPTION = "ns-memorygpioaccesslibrary to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/stub/memory_gpio_access_library"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile"
