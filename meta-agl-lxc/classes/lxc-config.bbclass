# Helper class for installing LXC guest configuration.
# Assumes that:
# - Recipe name is 'lxc-config-' + <guest name>
# - Corresponding files {config,system.conf}.<guest name>.in are in
#   the file search path
# - That references to the DRM lease device name are parameterized
#   with @DRM_LEASE_DEVICE@ in the .in files
# As well:
# - The .in files can optionally use the @LXC_AUTO_START@ parameter
#   to pick up the value of the LXC_AUTO_START variable for use in
#   defining lxc.start.auto.  The default value is "0", so recipes
#   need to assign the variable to "1" to have the associated
#   container start automatically.

python __anonymous() {
    bpn = d.getVar('BPN')
    if not bpn.startswith('lxc-config-'):
        bb.error('Recipe name does not start with \'lxc-config-\'')
    config = bpn[11:]
    d.setVar('LXC_CONFIG_NAME', config)
    src_uri = 'file://config.' + config + \
              '.in file://system.conf.' + config + '.in'
    d.setVar('SRC_URI', src_uri)
}

S = "${WORKDIR}"

inherit allarch

DRM_LEASE_DEVICE ??= "card0-HDMI-A-1"

DRM_LEASE_DEVICE_qemuall ?= "card0-Virtual-1"

LXC_AUTO_START ??= "0"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -m 0755 -d ${D}/var/lib/lxc/${LXC_CONFIG_NAME}
    for f in config.${LXC_CONFIG_NAME}.in system.conf.${LXC_CONFIG_NAME}.in; do
        sed -e 's|@DRM_LEASE_DEVICE@|${DRM_LEASE_DEVICE}|g' \
            -e 's|@LXC_AUTO_START@|${LXC_AUTO_START}|g' \
            ${WORKDIR}/$f > ${D}${localstatedir}/lib/lxc/${LXC_CONFIG_NAME}/${f%.${LXC_CONFIG_NAME}.in}
    done
}

FILES_${PN} = "${localstatedir}/lib/lxc/"
