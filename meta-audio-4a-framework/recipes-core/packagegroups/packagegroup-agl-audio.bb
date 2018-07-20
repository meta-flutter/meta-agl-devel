SUMMARY = "AGL Audio packages"
DESCRIPTION = "The set of packages required by the AGL Audio"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-audio \
    "

RDEPENDS_${PN} += "\
    4a-alsa-core \
    agl-service-audio-4a \
    VIRTUAL-RUNTIME_alsa-state \
    agl-service-unicens \
    4a-hal-unicens \
    bluez-alsa \
    4a-softmixer \
    4a-hal-generic \
    ${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', '4a-tools', '' , d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'pulseaudio', 'pulseaudio-module-4a-client', '' , d)} \
"
