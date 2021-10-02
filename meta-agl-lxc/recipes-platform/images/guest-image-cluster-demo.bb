SUMMARY = "LXC cluster demo guest image"
LICENSE = "MIT"

require guest-image-minimal.bb

IMAGE_INSTALL += " \
    weston \
    weston-init \
    weston-ini-conf-landscape \
    cluster-refgui \
    pipewire-ic-ipc \
"
