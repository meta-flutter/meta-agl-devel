SUMMARY     = "AGL configuration file for wireplumber"
HOMEPAGE    = "https://gitlab.freedesktop.org/gkiagia/wireplumber"
BUGTRACKER  = "https://jira.automotivelinux.org"
AUTHOR      = "George Kiagiadakis <george.kiagiadakis@collabora.com>"
SECTION     = "multimedia"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    file://wireplumber.conf \
    file://default.streams \
    file://default-output-audio.endpoint-link.in \
    file://default-input-audio.endpoint-link.in \
    file://bluealsa-output-audio.endpoint-link.in \
    file://bluealsa-input-audio.endpoint-link.in \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

#
# Device preferences are configured by listing a subset of the properties
# that the device node has on pipewire.
#
# Every property match needs to have a property name and an expected value.
# The values support shell-like pattern matching using the * and ? characters.
# The syntax adheres to the rules of TOML v0.5 table array.
#
# To list all device node properties, you can run (on the target):
#  export XDG_RUNTIME_DIR=/run/user/1001
#  wireplumber-cli
#
# Another way to figure out some of these properties is by parsing the
# aplay/arecord output. For example, this line is interpreted as follows:
#
#  card 0: PCH [HDA Intel PCH], device 2: ALC3246 [ALC3246 Analog]
#
# api.alsa.path = "hw:0,2"
# api.alsa.card = "0"
# api.alsa.card.id = "PCH"
# api.alsa.card.name = "HDA Intel PCH"
# api.alsa.pcm.device = "2"
# api.alsa.pcm.id = "ALC3246"
# api.alsa.pcm.name = "ALC3246 Analog"
#
DEV_PLAYBACK = '{ name = \"api.alsa.path\", value = \"hw:0,0\" }'
DEV_CAPTURE = '{ name = \"api.alsa.path\", value = \"hw:0,0\" }'

DEV_PLAYBACK_dra7xx-evm = '{ name = \"api.alsa.card.name\", value = \"DRA7xx-EVM\" }'
DEV_CAPTURE_dra7xx-evm = '{ name = \"api.alsa.card.name\", value = \"DRA7xx-EVM\" }'

DEV_PLAYBACK_m3ulcb = '{ name = \"api.alsa.card.name\", value = \"ak4613\" }'
DEV_CAPTURE_m3ulcb = '{ name = \"api.alsa.card.name\", value = \"ak4613\" }'

DEV_PLAYBACK_h3ulcb = '{ name = \"api.alsa.card.name\", value = \"ak4613\" }'
DEV_CAPTURE_h3ulcb = '{ name = \"api.alsa.card.name\", value = \"ak4613\" }'

DEV_PLAYBACK_raspberrypi3 = '{ name = \"api.alsa.pcm.name\", value = \"bcm2835 ALSA\" }, { name = \"api.alsa.card.name\", value = \"bcm2835 ALSA\" }'
DEV_CAPTURE_raspberrypi3 = '{ name = \"api.alsa.path\", value = \"hw:0,0\" }'

do_install_append() {
    sed -e "s/PLAYBACK_DEV_PROPERTIES/${DEV_PLAYBACK}/" -e "s/CAPTURE_DEV_PROPERTIES/${DEV_CAPTURE}/" ${WORKDIR}/default-output-audio.endpoint-link.in > ${WORKDIR}/default-output-audio.endpoint-link
    sed -e "s/PLAYBACK_DEV_PROPERTIES/${DEV_PLAYBACK}/" -e "s/CAPTURE_DEV_PROPERTIES/${DEV_CAPTURE}/" ${WORKDIR}/default-input-audio.endpoint-link.in > ${WORKDIR}/default-input-audio.endpoint-link
    sed -e "s/PLAYBACK_DEV_PROPERTIES/${DEV_PLAYBACK}/" -e "s/CAPTURE_DEV_PROPERTIES/${DEV_CAPTURE}/" ${WORKDIR}/bluealsa-output-audio.endpoint-link.in > ${WORKDIR}/bluealsa-output-audio.endpoint-link
    sed -e "s/PLAYBACK_DEV_PROPERTIES/${DEV_PLAYBACK}/" -e "s/CAPTURE_DEV_PROPERTIES/${DEV_CAPTURE}/" ${WORKDIR}/bluealsa-input-audio.endpoint-link.in > ${WORKDIR}/bluealsa-input-audio.endpoint-link
    install -d ${D}/${sysconfdir}/wireplumber/
    install -m 644 ${WORKDIR}/wireplumber.conf ${D}/${sysconfdir}/wireplumber/wireplumber.conf
    install -m 644 ${WORKDIR}/default.streams ${D}/${sysconfdir}/wireplumber/default.streams
    install -m 644 ${WORKDIR}/*.endpoint-link ${D}/${sysconfdir}/wireplumber/
}

FILES_${PN} += "\
    ${sysconfdir}/wireplumber/* \
"
CONFFILES_${PN} += "\
    ${sysconfdir}/wireplumber/* \
"

RPROVIDES_${PN} += "virtual/wireplumber-config"
