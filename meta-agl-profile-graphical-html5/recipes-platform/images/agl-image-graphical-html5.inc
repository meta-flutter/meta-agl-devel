require recipes-platform/images/agl-image-minimal.inc

IMAGE_FEATURES += "splash"

IMAGE_FEATURES += "${@bb.utils.contains('DISTRO_FEATURES', 'agl-devel', 'ssh-server-dropbear' , '', d)}"

inherit distro_features_check

REQUIRED_DISTRO_FEATURES = "wayland"
