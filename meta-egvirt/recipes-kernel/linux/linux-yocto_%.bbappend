FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# virtio SCMI
SRC_URI += " \
    file://virtio-scmi/0001-firmware-arm_scmi-smccc-mailbox-Make-shmem-based-tra.patch \
    file://virtio-scmi/0002-firmware-arm_scmi-Document-that-max_msg-is-a-per-cha.patch \
    file://virtio-scmi/0003-firmware-arm_scmi-Add-op-to-override-max-message.patch \
    file://virtio-scmi/0004-firmware-arm_scmi-Add-per-message-transport-data.patch \
    file://virtio-scmi/0005-firmware-arm_scmi-Add-xfer_init_buffers-transport-op.patch \
    file://virtio-scmi/0006-firmware-arm_scmi-Add-optional-link_supplier-transpo.patch \
    file://virtio-scmi/0007-firmware-arm_scmi-Add-per-device-transport-private-i.patch \
    file://virtio-scmi/0008-firmware-arm_scmi-Add-is_scmi_protocol_device.patch \
    file://virtio-scmi/0009-dt-bindings-arm-Add-virtio-transport-for-SCMI.patch \
    file://virtio-scmi/0010-firmware-arm_scmi-Add-virtio-transport.patch \
    file://virtio_scmi.cfg \
"

# SCMI updates
SRC_URI += " \
    file://scmi/0001-firmware-arm_scmi-rework-scmi_sensors_protocol_init.patch \
    file://scmi/0002-firmware-arm_scmi-add-SCMIv3.0-Sensors-descriptors-e.patch \
    file://scmi/0003-hwmon-scmi-update-hwmon-internal-scale-data-type.patch \
    file://scmi/0004-firmware-arm_scmi-add-SCMIv3.0-Sensors-timestamped-r.patch \
    file://scmi/0005-firmware-arm_scmi-add-SCMIv3.0-Sensor-configuration-.patch \
    file://scmi/0006-firmware-arm_scmi-add-SCMIv3.0-Sensor-notifications.patch \
"

# IIO SCMI
SRC_URI += " \
    file://iio-scmi/0001-iio-scmi-Adding-support-for-IIO-SCMI-Based-Sensors.patch \
    file://iio-scmi/0002-iio-core-Introduce-IIO_VAL_INT_64.patch \
    file://iio-scmi/0003-iio-scmi-Add-reading-raw-attribute.patch \
    file://iio_scmi.cfg \
"

# virtio video
SRC_URI += " \
    file://0001-drivers-media-Add-config-option-for-virtio-video.patch \
    file://virtio_video.cfg \
"
