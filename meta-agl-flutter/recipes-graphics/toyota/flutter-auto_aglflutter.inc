FILESEXTRAPATHS:append := "${THISDIR}/files:"

SRCREV = "${AUTOREV}"

SRC_URI += " \
    file://0001-Add-xdg-shell-app-id-command-line-argument.patch \
    file://default.json \
"

# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

# Enable verbose logging on runtimedebug image
PACKAGECONFIG:append:runtimedebug = "verbose"

cmake_do_install:prepend() {
    install -D -m 0644 ${WORKDIR}/default.json ${D}${datadir}/flutter/default.json
}

FILES:${PN} += " ${datadir}"
