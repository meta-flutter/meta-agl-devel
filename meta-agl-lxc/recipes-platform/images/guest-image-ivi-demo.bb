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
    momiscreen \
    qtquickcontrols \
    qtquickcontrols2 \
    qtwayland \
    systemd-netif-config \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-mathtexgyre \
    ttf-dejavu-common \
    ca-certificates \
"
