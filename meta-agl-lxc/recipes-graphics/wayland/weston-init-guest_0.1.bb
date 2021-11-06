SUMMARY = "Startup script and systemd unit file for the Weston Wayland compositor in guest cotainer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"


SRC_URI = "file://weston.env \
           file://weston.ini \
           file://weston.service \
          "

S = "${WORKDIR}"

inherit features_check systemd

do_install() {
    install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
    install -Dm644 ${WORKDIR}/weston.env ${D}${sysconfdir}/default/weston

    # Install Weston systemd service and accompanying udev rule
    install -D -p -m0644 ${WORKDIR}/weston.service ${D}${systemd_system_unitdir}/weston.service
    sed -i -e s:/etc:${sysconfdir}:g \
        -e s:/usr/bin:${bindir}:g \
        -e s:/var:${localstatedir}:g \
        ${D}${systemd_unitdir}/system/weston.service
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

# rdepends on weston which depends on virtual/egl
REQUIRED_DISTRO_FEATURES = "wayland"

FILES_${PN} += " \
    ${sysconfdir}/xdg/weston/weston.ini \
    ${systemd_system_unitdir}/weston.service \
    ${sysconfdir}/default/weston \
    "
CONFFILES_${PN} += " \
    ${sysconfdir}/xdg/weston/weston.ini \
    ${sysconfdir}/default/weston \
    "
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "weston.service"
SYSTEMD_AUTO_ENABLE = "enable"

RDEPENDS_${PN} = "weston"

RCONFLICTS_${PN} = "weston-init"
