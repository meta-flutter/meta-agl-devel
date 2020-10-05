PREFERRED_PROVIDER_virtual/egl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgl ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles1 ?= "mesa"
PREFERRED_PROVIDER_virtual/libgles2 ?= "mesa"

MACHINE_FEATURES = "alsa usbgadget screen vfat"

MACHINEOVERRIDES =. "virtio-all:"

IMAGE_FSTYPES += "tar.bz2 ext4"

# Don't include kernels in standard images
RDEPENDS_${KERNEL_PACKAGE_NAME}-base = ""

# Use a common kernel recipe for all VirtIO machines
PREFERRED_PROVIDER_virtual/kernel ??= "linux-yocto"

EXTRA_IMAGEDEPENDS += "qemu-native qemu-helper-native"

IMAGE_CLASSES += "qemuboot"

# most driver fails to compile
MOST_DRIVERS ?= ""
