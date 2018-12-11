# This brings some mandatory patches for the softmixer. This is not an actual hack,
# because all the 3 patches below have been discussed with the maintainer of bluez-alsa,
# and will be mainlined in the future

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-build-and-link-with-a-shared-library.patch"
SRC_URI += "file://0002-log-add-calling-function-name.patch"
SRC_URI += "file://0003-increased-the-number-of-connexions-to-16.patch"


