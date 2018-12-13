DESCRIPTION = "Build SND_AVIRT driver"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PV = "0.1"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/avirt;protocol=https;branch=${AGL_BRANCH}"

S = "${WORKDIR}/git"
SRCREV = "42000f29ef6775f092dab2c80f8b3a6a319b5658"

KERNEL_MODULE_AUTOLOAD += "snd-avirt-core snd-avirt-ap-loopback"
