SUMMARY = "AGL Instrument Cluster API library"
DESCRIPTION = "AGL Instrument Cluster API is defined common function API for Instrument Cluster.\
               This library was contributed by four EG member company."
HOMEPAGE = "https://confluence.automotivelinux.org/display/IC"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "libclusteripc"

SRC_URI = "git://git.automotivelinux.org/src/libcluster-api;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "fa8ad7927ede4f2a825021d13a8024742b8cb225"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE:append = " \
        -DCMAKE_SYSROOT=${RECIPE_SYSROOT} \
"
