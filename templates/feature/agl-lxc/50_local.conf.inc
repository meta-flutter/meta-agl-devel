BBMULTICONFIG = "agl-container-guest"

# Disable the meta-virtualization configuration support enabled by
# agl-virt.  This should be revisited when upgrading past dunfell,
# as less of the extra configuration may be enabled in the future.
DISTRO_FEATURES_remove = "virtualization"
INHERIT_remove = "sanity-meta-virt"
