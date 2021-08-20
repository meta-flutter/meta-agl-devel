SUMMARY = "ss-config for AGL software"
DESCRIPTION = "ss-config to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ss-versionlibrary \
    ns-frameworkunified \
    ps-communication \
    os-vehicleparameterlibrary \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/system/config"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.client"

RDEPENDS:${PN} += " \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ns-frameworkunified \
    ps-communication \
    ss-versionlibrary \
    os-vehicleparameterlibrary \
"
