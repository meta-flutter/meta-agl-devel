SUMMARY = "VIRTIO video device driver"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://virtio_video.h;endline=17;md5=3a04f9e12610bad07c6ec369a8077ba6"

inherit module

SRC_URI = "file://."

S = "${WORKDIR}"

KERNEL_MODULE_AUTOLOAD = "virtio_video"
