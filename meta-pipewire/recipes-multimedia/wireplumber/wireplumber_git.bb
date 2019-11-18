SUMMARY     = "Session / Policy Manager for PipeWire"
HOMEPAGE    = "https://gitlab.freedesktop.org/pipewire/wireplumber"
BUGTRACKER  = "https://gitlab.freedesktop.org/pipewire/wireplumber/issues"
AUTHOR      = "George Kiagiadakis <george.kiagiadakis@collabora.com>"
SECTION     = "multimedia"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;beginline=3;md5=e8ad01a5182f2c1b3a2640e9ea268264"

inherit meson pkgconfig gobject-introspection

DEPENDS = "glib-2.0 glib-2.0-native pipewire"

SRC_URI = "git://gitlab.freedesktop.org/pipewire/wireplumber.git;protocol=https;branch=master"
SRCREV = "59ab08ff0c9ff8b80dba93b8928db99f1a222ac4"

PV = "0.1.90+git${SRCPV}"
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
