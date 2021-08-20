PACKAGECONFIG:remove = "templates"

SYSTEMD_AUTO_ENABLE:${PN} = "enable"

# NOTE:
# This needs to be replaced with a rework of the upstream packaging
# to do a proper split of core from the template support.
RDEPENDS:${PN} = ""



