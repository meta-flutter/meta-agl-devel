FILESEXTRAPATHS:append := "${THISDIR}/files:"

SRCREV = "${AUTOREV}"

SRC_URI += " \
    file://0001-Add-xdg-shell-app-id-command-line-argument.patch \
"

# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

# Enable verbose logging on runtimedebug image
PACKAGECONFIG:append:runtimedebug = "verbose"
