SUMMARY = "AGL Instrument Cluster API library"
DESCRIPTION = "AGL Instrument Cluster API is defined common function API for Instrument Cluster.\
               This library was contributed by four EG member company."
HOMEPAGE = "https://confluence.automotivelinux.org/display/IC"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "libclusteripc"

SRC_URI = "git://git.automotivelinux.org/src/libcluster-api;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "3ef96b9efb7c80f3f7a731379dcbfa9a21e2ceed"

S = "${WORKDIR}/git"

inherit cmake pkgconfig
