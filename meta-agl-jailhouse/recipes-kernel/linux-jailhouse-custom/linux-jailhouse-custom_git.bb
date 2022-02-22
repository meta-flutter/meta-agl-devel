# Recipe created by recipetool
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux-jailhouse-custom/linux-jailhouse-5.14.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-jailhouse-custom"

SRC_URI = " git://git.kiszka.org/linux.git;branch=queues/jailhouse-5.14 \
	    file://defconfig \
	  "

SRCREV = "3208d0f0bc8afbaa06c4814e37179b7c26fcca35"

S = "${WORKDIR}/git"

# Modify these as desired
PV = "5.14+git${SRCPV}"
KVER = "5.14"

DEPENDS += "ncurses-native bc-native pkgconfig-native"
DEPENDS:append:x86-64 = " elfutils-native"
