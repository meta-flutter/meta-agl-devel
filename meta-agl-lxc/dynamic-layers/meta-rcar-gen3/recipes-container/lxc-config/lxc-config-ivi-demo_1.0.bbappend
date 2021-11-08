
# If you want to change display assign in your board, please change this line in your recipe.
DRM_LEASE_DEVICE ?= "${@bb.utils.contains("AGL_FEATURES", "kingfisher", "card0-HDMI-A-1", "card0-HDMI-A-1" ,d)}"

LXC_AUTO_START ?= "${@bb.utils.contains("AGL_FEATURES", "kingfisher", "1", "0" ,d)}"
