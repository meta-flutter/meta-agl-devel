SUMMARY     = "Sound Manager binding"
DESCRIPTION = "Sound Manager is the service binding to communicate \
               with Genivi Audio Manager. Genivi Audio Manager is \
               the policy manager for sound. It controls volume \
               and routing according to various situations. \
              "
HOMEPAGE    = "https://wiki.automotivelinux.org/soundmanager"
SECTION     = "multimedia"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"

DEPENDS = "dbus glib-2.0 af-binder json-c"
RDEPENDS_${PN} = "audiomanager audiomanager-plugins"

inherit cmake aglwgt

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-soundmanager-2017;protocol=https;branch=master"
SRCREV = "71e9700fe906fff4f111bc70d025912ee5dd095a"
S = "${WORKDIR}/git"
