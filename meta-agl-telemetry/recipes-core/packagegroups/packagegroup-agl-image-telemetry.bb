DESCRIPTION = "The tiniest set of packages required by AGL"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-image-telemetry \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    packagegroup-core-boot-agl \
    "

RDEPENDS_${PN} += "\
    packagegroup-agl-core-connectivity \
    packagegroup-agl-core-kernel \
    packagegroup-agl-core-os-commonlibs \
    packagegroup-agl-core-security \
    "
