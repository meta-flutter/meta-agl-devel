# Build updatable image. Only takes effect when sota.bbclass is inherited
DISTRO_FEATURES_append = " sota"

# Root device
ROOT_VM = "root=PARTUUID=${DISK_SIGNATURE}-02"

# Use our own wks file
WKS_FILE = "directdisk.wks.in"

# Simplest possible option
AGL_DEFAULT_IMAGE_FSTYPES = "ext4"

# Need to run QEMU with virtio-gpu device
PACKAGECONFIG_append_pn-qemu-system-native = " virglrenderer glx gtk+"
