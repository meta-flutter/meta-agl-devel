SUMMARY = "virtio-ivshmem-block built out of the kernel tree"
DESCRIPTION = "virtio-ivshmem-block built out of the kernel tree."
HOMEPAGE = "https://kernel.org"

LICENSE = "GPLv2"

PR = "r1"

DEPENDS = " \
    virtual/${MLPREFIX}libc \
    ${MLPREFIX}elfutils \
    ${MLPREFIX}binutils \
    bison-native flex-native xz \
"

do_configure[depends] += "virtual/kernel:do_shared_workdir"

PROVIDES = "virtual/virtio-ivshmem-block"

inherit linux-kernel-base kernel-arch

#kernel 3.1+ supports WERROR to disable warnings as errors
export WERROR = "0"

do_populate_lic[depends] += "virtual/kernel:do_shared_workdir"

inherit kernelsrc


#PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

RDEPENDS:${PN}-dev = ""

EXTRA_OEMAKE = " CC="${CC} ${CFLAGS} ${LDFLAGS}" CPP="${CPP}""

do_configure() {
    echo "configure"
}

do_compile() {

	oe_runmake CC="${CC} -I${STAGING_DIR_TARGET}/usr/include/ " LD="${LD}" AR="${AR}" \
		-C ${STAGING_KERNEL_DIR}/tools/virtio/ O=${S} virtio-ivshmem-block

}

do_install(){

    install -d ${D}${bindir}/
    install -m 0755  ${STAGING_KERNEL_DIR}/tools/virtio/virtio-ivshmem-block ${D}${bindir}

}