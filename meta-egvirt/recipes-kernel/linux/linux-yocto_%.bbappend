FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# virtio video
SRC_URI += " \
    file://0001-drivers-media-Add-config-option-for-virtio-video.patch \
    file://virtio_video.cfg \
"

# virtio BT
SRC_URI += " \
    file://virtio_bt.cfg \
    file://0002-Bluetooth-virtio_bt-fix-device-removal.patch \
"
