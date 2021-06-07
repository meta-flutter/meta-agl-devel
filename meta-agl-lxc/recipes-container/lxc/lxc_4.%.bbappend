PACKAGECONFIG_remove = "templates"

SYSTEMD_AUTO_ENABLE_${PN} = "enable"

# NOTE:
# This needs to be replaced with a rework of the upstream packaging
# to do a proper split of core from the template support.
RDEPENDS_${PN} = ""



