SUMMARY = "agl-service-ss-systemmanager for AGL software"
DESCRIPTION = "agl-service-ss-systemmanager to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    agl-service-ss-resourcemanager \
    agl-service-ss-loggerservice \
    agl-service-ps-communication \
    ss-config  \
    ss-interfaceunified  \
    ns-commonlibrary  \
    ns-frameworkunified  \
    os-vehicleparameterlibrary  \
    os-posixbasedos001legacylibrary  \
    os-rpclibrary  \
    os-eventlibrary \
    libpower-hal \
    vs-clock \
    vs-diagcode \
    libxml2-native \
    agl-basefiles-native \
    libxml-xpath-perl-native \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/system/system_manager"

inherit agl-basesystem-common perlnative

BSMAKE_FILE = "Makefile.server"

FILES_${PN} += "/usr/share/*"

RDEPENDS_${PN} += " \
    agl-service-ss-resourcemanager \
    agl-service-ss-loggerservice \
    agl-service-ps-communication \
    ss-config  \
    ss-interfaceunified  \
    ns-commonlibrary  \
    ns-frameworkunified  \
    os-vehicleparameterlibrary  \
    os-posixbasedos001legacylibrary  \
    os-rpclibrary  \
    os-eventlibrary \
    libpower-hal \
    vs-clock \
    vs-diagcode \
"
