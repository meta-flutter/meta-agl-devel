SUMMARY = "Linux-based partitioning hypervisor"
DESCRIPTION = "Jailhouse is a partitioning Hypervisor based on Linux. It is able to run bare-metal applications or (adapted) \
operating systems besides Linux. For this purpose, it configures CPU and device virtualization features of the hardware \
platform in a way that none of these domains, called 'cells' here, can interfere with each other in an unacceptable way."
HOMEPAGE = "https://github.com/siemens/jailhouse"
SECTION = "jailhouse"
LICENSE = "GPL-2.0-only & BSD-2-Clause"

LIC_FILES_CHKSUM = " \
    file://COPYING;md5=9fa7f895f96bde2d47fd5b7d95b6ba4d \
"

SRCREV = "630001202caec85370fb4f956e581f51109e490c"
PV = "0.12+git${SRCPV}"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://github.com/siemens/jailhouse;branch=master;protocol=https \
           file://qemu-agl.c \
           file://agl-apic-demo.c \
           file://agl-pci-demo.c \
           file://agl-ivshmem-demo.c \
           file://agl-linux-x86-demo.c \
           "

DEPENDS = "virtual/kernel dtc-native python3-mako-native make-native"

require jailhouse-arch.inc
inherit module python3native bash-completion setuptools3

S = "${WORKDIR}/git"
B = "${S}"

JH_DATADIR ?= "${datadir}/jailhouse"
JH_EXEC_DIR ?= "${libexecdir}/jailhouse"
CELL_DIR ?= "${JH_DATADIR}/cells"
INMATES_DIR ?= "${JH_DATADIR}/inmates"
DTS_DIR ?= "${JH_DATADIR}/cells/dts"

JH_CELL_FILES ?= "*.cell"

EXTRA_OEMAKE = "ARCH=${JH_ARCH} CROSS_COMPILE=${TARGET_PREFIX} CC="${CC} -mfpmath=387" KDIR=${STAGING_KERNEL_BUILDDIR}"

do_configure() {
		
	# copy ${WORKDIR}/<cell_config>.c ${S}/configs/x86/ <--- folder where the cells are defined in the source tree to be compiled
	#cp ${WORKDIR}/qemu-agl.c ${S}/configs/${JH_ARCH}
	cp ${WORKDIR}/agl-apic-demo.c ${S}/configs/x86/
	# cp ${WORKDIR}/agl-pci-demo.c ${S}/configs/x86/
	cp ${WORKDIR}/agl-linux-x86-demo.c ${S}/configs/x86/
	cp ${WORKDIR}/agl-ivshmem-demo.c ${S}/configs/x86/
	cp ${WORKDIR}/qemu-agl.c ${S}/configs/x86/

	sed -i '1s|^#!/usr/bin/env python$|#!/usr/bin/env python3|' ${B}/tools/${BPN}-*
}

do_compile() {
	oe_runmake V=1
}

do_install() {
	# Install pyjailhouse python modules needed by the tools
	distutils3_do_install

	# We want to install the python tools, but we do not want to use pip...
	# At least with v0.10, we can work around this with
	# 'PIP=":" PYTHON_PIP_USEABLE=yes'
	oe_runmake PIP=: PYTHON=python3 PYTHON_PIP_USEABLE=yes DESTDIR=${D} install

	install -d ${D}${CELL_DIR}

	
	install -m 0644 ${B}/configs/${JH_ARCH}/${JH_CELL_FILES} ${D}${CELL_DIR}/

	install -d ${D}${INMATES_DIR}
	install -m 0644 ${B}/inmates/demos/${JH_ARCH}/*.bin ${D}${INMATES_DIR}
	if [ ${JH_ARCH}  != "x86" ]; then
		install -d ${D}${DTS_DIR}
		install -m 0644 ${B}/configs/${JH_ARCH}/dts/*.dtb ${D}${DTS_DIR}
	fi
}

PACKAGE_BEFORE_PN = "kernel-module-jailhouse pyjailhouse ${PN}-tools ${PN}-demos"
FILES:${PN} = "${base_libdir}/firmware ${libexecdir} ${sbindir} ${JH_DATADIR}"
FILES:pyjailhouse = "${PYTHON_SITEPACKAGES_DIR}"
FILES:${PN}-tools = "${libexecdir}/${BPN}/${BPN}-* ${JH_DATADIR}/*.tmpl"
FILES:${PN}-demos = "${JH_DATADIR}/ ${sbindir}/ivshmem-demo"

# Default Linker Hash Style Changed to "sysv"
TARGET_CC_ARCH += "${LDFLAGS}"

RDEPENDS:${PN}-tools = "pyjailhouse python3-mmap python3-math python3-datetime python3-curses python3-compression python3-mako"
RDEPENDS:pyjailhouse = "python3-core python3-ctypes python3-fcntl"
RDEPENDS:${PN}-demos = "jailhouse"

RRECOMMENDS:${PN} = "${PN}-tools"

KERNEL_MODULE_AUTOLOAD += "jailhouse"
