FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# If you want to change display assign in your board, please change this line in your recipe.
DRM_LEASE_DEVICE ?= "${@bb.utils.contains("AGL_FEATURES", "kingfisher", "card0-HDMI-A-2", "card0-HDMI-A-1" ,d)}"

LXC_AUTO_START ?= "1"
