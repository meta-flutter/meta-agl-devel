LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95bbe2f9180443b5dcef3fb959804a65"

SRC_URI = "git://github.com/cktan/tomlc99;protocol=https;branch=master"

PV = "1.0+git${SRCPV}"
SRCREV = "034b23ed3e4e5ee5345040eabed470f204d7f668"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
        oe_runmake install prefix=${D}/${prefix}

        ln -rs ${D}/${prefix}/lib/libtoml.so.0.0 ${D}${prefix}/lib/libtoml.so

        sed 's:^prefix=.*:prefix=${prefix}:' ${S}/libtoml.pc.sample > libtoml.pc
        install -d ${D}${prefix}/lib/pkgconfig
        install libtoml.pc ${D}${prefix}/lib/pkgconfig/
}
