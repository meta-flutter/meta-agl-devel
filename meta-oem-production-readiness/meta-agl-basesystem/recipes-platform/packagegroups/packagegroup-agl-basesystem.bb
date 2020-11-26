DESCRIPTION = "BaseSystem Package Groups"
LICENSE = "Apache-2.0"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-basesystem \
"

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    packagegroup-agl-image-minimal \
"

RDEPENDS_${PN}  += "\
    packagegroup-agl-basesystem-core \
    packagegroup-agl-basesystem-apis \
    packagegroup-agl-basesystem-service \
    packagegroup-agl-basesystem-hal \
"
