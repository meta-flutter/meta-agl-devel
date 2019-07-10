require pipewire.inc

SRC_URI = "gitsm://github.com/PipeWire/pipewire;protocol=https;branch=work \
    file://0001-spa-include-install-missing-headers.patch \
    file://0002-extensions-implement-Endpoint-ClientEndpoint-interfa.patch \
    file://0003-pipewire-cli-add-support-for-printing-endpoint-info-.patch \
    file://0004-pipewire-cli-add-command-to-modify-endpoint-control-.patch \
    file://0005-arm-build-with-mno-unaligned-access.patch \
    file://0006-logger-print-timestamps-on-logged-messages.patch \
    file://0007-alsa-make-corrections-on-the-timeout-based-on-how-fa.patch \
    file://0008-audio-dsp-allow-mode-to-be-set-with-a-property.patch \
    file://0009-audioconvert-do-setup-internal-links-and-buffers-als.patch \
    "

SRCREV = "4be788962e60891237f1f018627bf709ae3981e6"

PV = "0.2.90+git${SRCPV}-1"
S  = "${WORKDIR}/git"

RDEPENDS_${PN} += "virtual/pipewire-sessionmanager virtual/pipewire-config"
