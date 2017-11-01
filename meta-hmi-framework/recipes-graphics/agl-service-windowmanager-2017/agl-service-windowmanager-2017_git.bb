SUMMARY     = "Window Manager service binding for applications"
DESCRIPTION = "Window Manager 2017 is the service binding for controlling rendering rights \
    Applications requests to render itself, then Window Manager check policy and notify layout to respective applications \
    "
HOMEPAGE    = "https://wiki.automotivelinux.org/windowmanager"
SECTION = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://LICENSE.MIT;md5=a7514fe5664902e337bd8a4443d8f348"
DEPENDS = "af-binder json-c wayland wayland-ivi-extension wayland-native"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-windowmanager-2017;protocol=https;branch=master"
SRCREV = "3772dc5dc1b89ac101134d02529bde7185e68948"
S = "${WORKDIR}/git"

inherit cmake aglwgt

#If you would like to output log, uncomment out
EXTRA_OECMAKE_append_agl-devel = " -DENABLE_DEBUG_OUTPUT=ON "
