SUMMARY     = "Homescreen binding and client library for application"
DESCRIPTION = "Homescreen 2017 is the binding library"
HOMEPAGE    = "https://git.automotivelinux.org/apps/agl-service-homescreen-2017"
SECTION = "HMI"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

inherit cmake aglwgt
DEPENDS = "dbus glib-2.0 af-binder json-c"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-homescreen-2017;protocol=https;branch=master"
SRCREV = "087ddd64698d8634cd748e0341a6c17e0a6ca134"
S = "${WORKDIR}/git"
