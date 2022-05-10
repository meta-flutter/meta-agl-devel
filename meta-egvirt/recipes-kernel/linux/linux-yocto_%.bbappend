FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# virtio SCMI
SRC_URI += " \
    file://virtio_scmi.cfg \
"

# IIO SCMI
SRC_URI += " \
    file://iio-scmi/0002-iio-core-Introduce-IIO_VAL_INT_64.patch \
    file://iio-scmi/0003-iio-scmi-Add-reading-raw-attribute.patch \
    file://iio_scmi.cfg \
"

# virtio video
SRC_URI += " \
    file://0001-drivers-media-Add-config-option-for-virtio-video.patch \
    file://virtio_video.cfg \
"
