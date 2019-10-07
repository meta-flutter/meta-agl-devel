require pipewire.inc

SRC_URI = "gitsm://github.com/PipeWire/pipewire;protocol=https;branch=master \
    file://0001-arm-build-with-mno-unaligned-access.patch \
    file://0002-logger-print-timestamps-on-logged-messages.patch \
    file://0003-gst-Implement-new-pwaudio-src-sink-elements-based-on.patch \
    file://0004-gst-pwaudioringbuffer-request-pause-play-on-the-appr.patch \
    file://0005-gst-pwaudioringbuffer-wait-only-for-STREAM_STATE_CON.patch \
    file://0006-gst-pwaudiosink-set-the-default-latency-time-buffer-.patch \
    file://0007-gst-pwaudioringbuffer-set-node.latency-to-get-schedu.patch \
    file://0008-meson-revert-version-check-to-require-meson-0.47-not.patch \
    file://0009-extensions-implement-new-session-manager-extension.patch \
    file://0010-pipewire-cli-add-support-for-printing-endpoint-info-.patch \
    file://0011-daemon-config-remote-load-module-session-manager-by-.patch \
    file://0012-audioconvert-always-assume-that-output-ports-are-NOT.patch \
    "

SRCREV = "5693d72fcb0a0290faedcce64c57a3820a5cc660"

PV = "0.2.91+git${SRCPV}+1"
S  = "${WORKDIR}/git"

RDEPENDS_${PN} += "virtual/pipewire-sessionmanager virtual/pipewire-config"
