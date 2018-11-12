DESCRIPTION = "Build SND_AVIRT driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PV = "0.1"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/avirt;protocol=https;branch=${AGL_BRANCH}"

S = "${WORKDIR}/git"
SRCREV = "0b7527a463a9f494e15e067ff7bbc604f24fac3a"

KERNEL_MODULE_AUTOLOAD += "snd-avirt-core snd-avirt-ap-loopback"
