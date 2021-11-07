SUMMARY = "LXC ivi demo guest image"
LICENSE = "MIT"

require guest-image-minimal.bb

IMAGE_INSTALL += " \
    weston \
    weston-init-guest \
    wayland-ivi-extension \
    ilm-manager \
    mominavi \
    momiplay \
    qtquickcontrols \
    qtquickcontrols2 \
    qtwayland \
"
