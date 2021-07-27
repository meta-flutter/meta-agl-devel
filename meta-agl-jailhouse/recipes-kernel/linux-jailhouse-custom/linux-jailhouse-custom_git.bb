# Recipe created by recipetool
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

inherit kernel
require recipes-kernel/linux-jailhouse-custom/linux-jailhouse-5.14.inc

PREFERRED_PROVIDER_virtual/kernel = "linux-jailhouse-custom"

SRC_URI = " git://git.kiszka.org/linux.git;branch=queues/jailhouse \
	    file://defconfig \
	  "

SRCREV = "4f96ea3417cc3eb8b96d70f04ac860d8577107a8"

S = "${WORKDIR}/git"

# Modify these as desired
PV = "5.14-rc2+git${SRCPV}"
KVER = "5.14"

DEPENDS += "ncurses-native bc-native pkgconfig-native"
DEPENDS_append_x86-64 = " elfutils-native"
