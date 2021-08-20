SUMMARY = "A minimal container guest image"

require recipes-platform/images/agl-image-boot.inc

IMAGE_LINGUAS = " "

IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"
