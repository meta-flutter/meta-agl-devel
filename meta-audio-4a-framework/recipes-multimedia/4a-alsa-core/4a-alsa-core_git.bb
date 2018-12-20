SUMMARY     = "4A - Low Level Alsa Binding"
DESCRIPTION = "Low Level Alsa Binding for 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://git.automotivelinux.org/src/4a-alsa-core/"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://gerrit.automotivelinux.org/gerrit/src/4a-alsa-core;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "985df9fad73cd9e9c5f18e18f3fe41e030f63b20"

PV = "0.1+git${SRCPV}"
S  = "${WORKDIR}/git"

inherit afb-system-cmake

FILES_${PN}-dev += "${INSTALL_PREFIX}/4a-alsa-core/htdocs"

FILES_${PN} += "${INSTALL_PREFIX}/4a-alsa-core"
FILES_${PN} += "${INSTALL_PREFIX}/lib"
