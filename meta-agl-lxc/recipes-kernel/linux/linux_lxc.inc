FILESEXTRAPATHS:prepend := "${THISDIR}/linux:"

# Disable all other AGL provided kernel configuration (barring
# base BSP provided configuration), and just enable a locally
# provided fragment with minimal LXC required configuration.
AGL_KCONFIG_FRAGMENTS += "lxc.cfg "
AGL_KCONFIG_FRAGMENTS += "lxc-net.cfg "



