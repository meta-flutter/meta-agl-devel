require pipewire.inc

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI = "gitsm://github.com/PipeWire/pipewire;protocol=https;branch=work \
    file://0001-spa-include-install-missing-headers.patch \
    file://0001-extensions-implement-Endpoint-ClientEndpoint-interfa.patch \
    file://0002-pipewire-cli-add-support-for-printing-endpoint-info-.patch \
    file://pipewire.conf \
    "
SRCREV = "4be788962e60891237f1f018627bf709ae3981e6"

PV = "0.2.90+git${SRCPV}-1"
S  = "${WORKDIR}/git"

RDEPENDS_${PN} += "wireplumber"
