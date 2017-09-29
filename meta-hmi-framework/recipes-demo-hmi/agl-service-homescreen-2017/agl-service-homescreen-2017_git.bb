SUMMARY     = "Homescreen binding and client library for application"
DESCRIPTION = "Homescreen 2017 is the binding library"
HOMEPAGE    = "https://git.automotivelinux.org/apps/agl-service-homescreen-2017"
S = "${WORKDIR}/git"
SECTION = "HMI"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

inherit cmake aglwgt
DEPENDS = "dbus glib-2.0 af-binder json-c"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-homescreen-2017;protocol=https;branch=master"
SRCREV = "e0163d2b8daae98ced81f4bc737998c00858e771"

do_install_append() {
    install -d ${D}/usr/lib/pkgconfig
    install -m 0644 ${B}/homescreen.pc ${D}/usr/lib/pkgconfig

    install -d ${D}/usr/include
    install -m 0644 ${S}/include/libhomescreen.hpp ${D}/usr/include

    install -d ${D}/usr/lib
    install -m 0755 ${B}/libhomescreen/libhomescreen.so ${D}/usr/lib/libhomescreen.so.0.1
    ln -sf libhomescreen.so.0.1 ${D}/usr/lib/libhomescreen.so
}
