SUMMARY     = "AGL configuration file for wireplumber"
HOMEPAGE    = "https://gitlab.freedesktop.org/gkiagia/wireplumber"
BUGTRACKER  = "https://jira.automotivelinux.org"
AUTHOR      = "George Kiagiadakis <george.kiagiadakis@collabora.com>"
SECTION     = "multimedia"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://wireplumber.conf.in"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

#
# For device names, any unique substring of the "endpoint" name is valid.
# To list all endpoints:
#  export XDG_RUNTIME_DIR=/run/user/1001
#  pipewire-cli
#  > connect pipewire-0
#  > list-objects
# ... and look for objects of type "PipeWire:Interface:Endpoint/0"
#
# For instance:
#   id 269, parent 40, type PipeWire:Interface:Endpoint/0
#           media.name = "USB Audio on WD15 Dock (hw:1,0 / node 5)"
#           media.class = "Audio/Sink"
#   id 270, parent 40, type PipeWire:Interface:Endpoint/0
#           media.name = "USB Audio on WD15 Dock (hw:1,0 / node 7)"
#           media.class = "Audio/Source"
#
# Audio/Sink endpoints are valid for playback
# Audio/Source endpoints are valid for capture
#
# Wireplumber will first filter endpoints based on the media.class, depending
# on whether the client is doing playback or capture and then it will look
# for a sub-string match in the media.name
#
DEV_PLAYBACK = "hw:0,0"
DEV_CAPTURE = "hw:0,0"

DEV_PLAYBACK_dra7xx-evm = "DRA7xx-EVM"
DEV_CAPTURE_dra7xx-evm = "DRA7xx-EVM"

DEV_PLAYBACK_m3ulcb = "ak4613"
DEV_CAPTURE_m3ulcb = "ak4613"

DEV_PLAYBACK_h3ulcb = "ak4613"
DEV_CAPTURE_h3ulcb = "ak4613"

DEV_PLAYBACK_raspberrypi3 = "bcm2835 ALSA on bcm2835 ALSA"
DEV_CAPTURE_raspberrypi3 = "hw:0,0"

do_install_append() {
    sed -e "s/PLAYBACK/${DEV_PLAYBACK}/" -e "s/CAPTURE/${DEV_CAPTURE}/" ${WORKDIR}/wireplumber.conf.in > ${WORKDIR}/wireplumber.conf
    install -d ${D}/${sysconfdir}/wireplumber/
    install -m 644 ${WORKDIR}/wireplumber.conf ${D}/${sysconfdir}/wireplumber/wireplumber.conf
}

FILES_${PN} += "\
    ${sysconfdir}/wireplumber/* \
"
CONFFILES_${PN} += "\
    ${sysconfdir}/wireplumber/* \
"

RPROVIDES_${PN} += "virtual/wireplumber-config"
