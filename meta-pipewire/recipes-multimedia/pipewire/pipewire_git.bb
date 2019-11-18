require pipewire.inc

SRC_URI = "git://gitlab.freedesktop.org/pipewire/pipewire.git;protocol=https;branch=master \
    file://0001-meson-revert-version-check-to-require-meson-0.47-not.patch \
    file://0002-arm-build-with-mno-unaligned-access.patch \
    file://0003-gst-Implement-new-pwaudio-src-sink-elements-based-on.patch \
    file://0004-gst-pwaudioringbuffer-request-pause-play-on-the-appr.patch \
    file://0005-gst-pwaudioringbuffer-wait-only-for-STREAM_STATE_CON.patch \
    file://0006-gst-pwaudiosink-set-the-default-latency-time-buffer-.patch \
    file://0007-gst-pwaudioringbuffer-set-node.latency-to-get-schedu.patch \
    file://0008-audioconvert-always-assume-that-output-ports-are-NOT.patch \
    file://0009-module-access-add-same-sec-label-mode.patch \
    "

SRCREV = "e18a24493a254c881a1bda384fdcd70cd671fd1c"

PV = "0.2.91+git${SRCPV}+1"
S  = "${WORKDIR}/git"

RDEPENDS_${PN} += "virtual/pipewire-sessionmanager virtual/pipewire-config"
