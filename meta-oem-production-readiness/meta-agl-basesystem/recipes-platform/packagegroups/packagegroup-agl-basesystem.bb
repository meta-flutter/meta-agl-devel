DESCRIPTION = "BaseSystem Package Groups"
LICENSE = "Apache-2.0"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-basesystem \
"

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += "\
    packagegroup-agl-image-minimal \
"

RDEPENDS:${PN}  += "\
    packagegroup-agl-basesystem-core \
    packagegroup-agl-basesystem-apis \
    packagegroup-agl-basesystem-service \
    packagegroup-bshalmake \
"
