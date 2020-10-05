FILESEXTRAPATHS_prepend := "${THISDIR}/linux-yocto:"

SRC_URI_append_virtio-aarch64 = " \
    file://virtio-aarch64;type=kmeta;destsuffix=virtio-aarch64 \
"

COMPATIBLE_MACHINE_virtio-aarch64 = "virtio-aarch64"
