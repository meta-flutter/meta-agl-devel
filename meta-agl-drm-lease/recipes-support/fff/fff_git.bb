LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae0c5f671972941881237cb85e1c74b2"

SRC_URI = "git://github.com/meekrosoft/fff.git"

PV = "git${SRCPV}"
SRCREV = "cbe9b8b7fba14a042d2b4e008dedf0b998c35ae8"

S = "${WORKDIR}/git"

DEPENDS = "libdrm libcheck"

do_install() {
    install -d ${D}/${includedir}
    install ${S}/fff.h ${D}/${includedir}/
}
