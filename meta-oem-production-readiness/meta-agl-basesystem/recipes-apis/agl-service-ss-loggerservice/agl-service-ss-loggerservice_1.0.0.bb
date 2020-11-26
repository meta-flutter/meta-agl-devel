SUMMARY = "agl-service-ss-loggerservice for AGL software"
DESCRIPTION = "agl-service-ss-loggerservice to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " libtar \
    ss-config \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ss-resourcemanager \
    ns-commonlibrary \
    ns-frameworkunified \
    ns-backupmanager \
    os-vehicleparameterlibrary \
    os-posixbasedos001legacylibrary \
    logrotate \
    ns-memorygpioaccesslibrary \
    vs-clock \
    vs-diagrecord \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/system/logger_service"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.server"

RDEPENDS_${PN} += " \
    ss-config \
    ss-interfaceunified \
    ss-romaccesslibrary \
    ss-resourcemanager \
    ns-commonlibrary \
    ns-frameworkunified \
    ns-backupmanager \
    os-vehicleparameterlibrary \
    os-posixbasedos001legacylibrary \
    ns-memorygpioaccesslibrary \
    vs-clock \
    vs-diagrecord \
"
