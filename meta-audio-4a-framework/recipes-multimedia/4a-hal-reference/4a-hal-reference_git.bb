SUMMARY     = "4A - Reference HALs"
DESCRIPTION = "HALs used for Reference boards in 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://git.automotivelinux.org/src/4a-hal-reference/"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://gerrit.automotivelinux.org/gerrit/src/4a-hal-reference;protocol=https;branch=${AGL_BRANCH}"

SRCREV = "${AUTOREV}"

PV = "0.1"
S  = "${WORKDIR}/git"

inherit afb-system-cmake

EXTRA_OECMAKE += " -DHAL_USB_DEVICE=1"

#Select Here your HAL
EXTRA_OECMAKE_m3ulcb += " -DHAL_RCAR-M3=1"

FILES_${PN}-dev += "${INSTALL_PREFIX}/afb-aaaa/htdocs"
FILES_${PN} += "${INSTALL_PREFIX}/afb-aaaa"
FILES_${PN} += "${INSTALL_PREFIX}/lib"
