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
SRCREV = "44a60b863828860f36c0bcb3dff44063fcc1f2bc"

PV = "0.0+git${SRCPV}"
S  = "${WORKDIR}/git"

PACKAGES =+ "${PN}-config"

FILES_${PN} += "\
    ${libdir}/wireplumber-*/* \
"
RPROVIDES_${PN} += "virtual/pipewire-sessionmanager"
RDEPENDS_${PN} += "virtual/wireplumber-config"


FILES_${PN}-config += "\
    ${sysconfdir}/wireplumber/* \
"
CONFFILES_${PN}-config += "\
    ${sysconfdir}/wireplumber/* \
"

RPROVIDES_${PN}-config += "virtual/wireplumber-config"
