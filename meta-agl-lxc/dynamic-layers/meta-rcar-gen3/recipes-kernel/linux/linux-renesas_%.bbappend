# Enable LXC support
KERNEL_FEATURES += "lxc.scc"

# Workaround cfg/virtio.scc issue in meta-virtualization for now.
# If it's addition is made not unconditional or the file is made
# available in meta-virtualization as opposed to yocto-kernel-cache,
# this can be revisited.
KERNEL_FEATURES_remove = "cfg/virtio.scc"
