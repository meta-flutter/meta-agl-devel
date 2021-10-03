SUMMARY = "AGL Instrument Cluster Core Packages"
DESCRIPTION = "This pacage group including AGL Instrument Cluster function core packages such as \
               common library,framework."
HOMEPAGE = "https://confluence.automotivelinux.org/display/IC"

LICENSE = "Apache-2.0"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-ic-core \
"
RDEPENDS:${PN} += "\
    libclusteripc \
    libclusterapi \
"
