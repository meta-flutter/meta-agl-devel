BBMULTICONFIG = "agl-container-guest"

# The meta-virtualization has a sanity-meta-virt check.
# This checker check 'DISTRO_FEATURES has virtualization', but 
# in case of linux container is not necessary to the 'virtualization'.
# This should be revisited when upgrading past dunfell, as less of 
# the extra configuration may be enabled in the future.
INHERIT:remove = "sanity-meta-virt"
