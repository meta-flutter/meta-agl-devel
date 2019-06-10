SUMMARY     = "Audio Mixer Service Binding"
DESCRIPTION = "AGL Audio Mixer Service Binding"
SECTION     = "apps"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;beginline=3;md5=e8ad01a5182f2c1b3a2640e9ea268264"

PV = "0.0+git${SRCPV}"

SRC_URI = "git://gitlab.freedesktop.org/gkiagia/agl-service-audiomixer.git;protocol=https;branch=master"
SRCREV = "${AUTOREV}"

S  = "${WORKDIR}/git"

inherit cmake aglwgt pkgconfig

DEPENDS += "pipewire"
