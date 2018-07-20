SUMMARY     = "pulseaudio 4A client module"
DESCRIPTION = "pulseaudio module to work with 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://gitlab.collabora.com/gkiagia/pulseaudio-module-4a"
SECTION     = "plugins"

LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "git://gitlab.collabora.com/gkiagia/pulseaudio-module-4a.git;protocol=https"
SRCREV = "897f554324bbb031d6a482584b227f8400d2c624"

PV = "0.1+git${SRCPV}"
S  = "${WORKDIR}/git"

inherit cmake pkgconfig

DEPENDS += "af-binder systemd json-c pulseaudio"
RDEPENDS_${PN} = "pulseaudio-module-alsa-sink"

FILES_${PN} += "/usr/lib/pulse-*/modules/module-4a-client.so"
