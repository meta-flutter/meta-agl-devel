SUMMARY = "Tiny window manager for wayland-ivi-extension"
DESCRIPTION = "Tiny window manager for wayland-ivi-extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "jsoncpp wayland-ivi-extension"

PV = "0.1.0+rev${SRCPV}"

SRCREV = "e3a33d47195e4656f7117753d27a0f2d6b21aab9"
SRC_URI = " \
    git://github.com/AGLExport/ilm-manager.git;branch=master;protocol=https \
    file://agl.json \
    file://ilm-manager.service \
    "
S = "${WORKDIR}/git"

inherit autotools pkgconfig systemd

do_install:append() {
    #install scripts
    install -d ${D}/etc
    install -m 0644 ${WORKDIR}/agl.json ${D}/etc

    install -d ${D}/lib/systemd/system
    install -m 0644 ${WORKDIR}/ilm-manager.service ${D}/lib/systemd/system
}

FILES:${PN} += " ${systemd_unitdir} /etc/* "
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "ilm-manager.service"
