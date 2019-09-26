require pipewire.inc

SRC_URI = "gitsm://github.com/PipeWire/pipewire;protocol=https;branch=work \
    file://0001-arm-build-with-mno-unaligned-access.patch \
    file://0002-logger-print-timestamps-on-logged-messages.patch \
    file://0003-alsa-make-corrections-on-the-timeout-based-on-how-fa.patch \
    file://0004-gst-Implement-new-pwaudio-src-sink-elements-based-on.patch \
    file://0005-gst-pwaudioringbuffer-request-pause-play-on-the-appr.patch \
    file://0006-gst-pwaudioringbuffer-wait-only-for-STREAM_STATE_CON.patch \
    file://0007-gst-pwaudiosink-set-the-default-latency-time-buffer-.patch \
    file://0008-gst-pwaudioringbuffer-set-node.latency-to-get-schedu.patch \
    file://0009-alsa-do-not-expose-non-interleaved-formats-since-the.patch \
    file://0010-bluez-monitor-fix-usage-of-pw_properties_setf-withou.patch \
    file://0011-meson-revert-version-check-to-require-meson-0.47-not.patch \
    file://0012-extensions-implement-new-session-manager-extension.patch \
    file://0013-pipewire-cli-add-support-for-printing-endpoint-info-.patch \
    file://0014-daemon-config-remote-load-module-session-manager-by-.patch \
    "

SRCREV = "d3c7acb137134bddff3bc8a8964600252d3fb674"

PV = "0.2.90+git${SRCPV}+2"
S  = "${WORKDIR}/git"

RDEPENDS_${PN} += "virtual/pipewire-sessionmanager virtual/pipewire-config"
