SUMMARY = "Virtio over IVSHMEM"
DESCRIPTION = "The set of modules required to use virtio over IVSHMEM applications in AGL"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
	packagegroup-agl-jailhouse \
"

RDEPENDS:packagegroup-agl-jailhouse = "\
	virtio-ivshmem-block \
	virtio-ivshmem-console \
"