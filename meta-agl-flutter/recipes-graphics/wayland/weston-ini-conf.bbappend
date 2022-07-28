# This is a settings-only package, we do not need a development package
# (and its fixed dependency to ${PN} being installed)
PACKAGES:remove = "${PN}-dev ${PN}-staticdev"
