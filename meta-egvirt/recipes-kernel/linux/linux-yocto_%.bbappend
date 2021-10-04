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

# IIO SCMI
SRC_URI += " \
    file://iio-scmi/0001-iio-scmi-Adding-support-for-IIO-SCMI-Based-Sensors.patch \
    file://iio_scmi.cfg \
"
