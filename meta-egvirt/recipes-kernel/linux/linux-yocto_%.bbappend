FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# virtio video
SRC_URI += " \
    file://0001-drivers-media-Add-config-option-for-virtio-video.patch \
    file://virtio_video.cfg \
"
