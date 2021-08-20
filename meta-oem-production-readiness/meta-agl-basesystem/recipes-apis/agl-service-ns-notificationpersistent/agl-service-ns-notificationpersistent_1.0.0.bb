SUMMARY = "agl-service-ns-notificationpersistent for AGL software"
DESCRIPTION = "agl-service-ns-notificationpersistent to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    libtar \
    ns-frameworkunified \
    os-posixbasedos001legacylibrary \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/native/notification_persistent_service"

inherit agl-basesystem-common

BSMAKE_FILE = "Makefile.server"

RDEPENDS:${PN} += " \
    ns-frameworkunified \
    os-posixbasedos001legacylibrary \
"
