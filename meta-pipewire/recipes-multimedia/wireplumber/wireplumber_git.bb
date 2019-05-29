SUMMARY     = "Session / Policy Manager for PipeWire"
HOMEPAGE    = "https://gitlab.freedesktop.org/gkiagia/wireplumber"
BUGTRACKER  = "https://gitlab.freedesktop.org/gkiagia/wireplumber/issues"
AUTHOR      = "George Kiagiadakis <george.kiagiadakis@collabora.com>"
SECTION     = "multimedia"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;beginline=3;md5=e8ad01a5182f2c1b3a2640e9ea268264"

inherit meson pkgconfig gobject-introspection

DEPENDS = "glib-2.0 glib-2.0-native pipewire"

SRC_URI = "git://gitlab.freedesktop.org/gkiagia/wireplumber;protocol=https;branch=master"
SRCREV = "36bc1795ca2626cde5cbd5ec6afae50e5496bd08"

PV = "0.0+git${SRCPV}"
S  = "${WORKDIR}/git"

FILES_${PN} += "\
    ${libdir}/wireplumber-*/* \
    ${sysconfdir}/wireplumber/* \
"
CONFFILES_${PN} += "\
    ${sysconfdir}/wireplumber/* \
"
