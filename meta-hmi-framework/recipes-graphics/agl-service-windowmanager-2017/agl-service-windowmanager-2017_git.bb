SUMMARY     = "Window Manager service binding for applications"
DESCRIPTION = "Window Manager 2017 is the service binding for controlling \
               rendering rights. Applications request to render itself, \
               then Window Manager checks the policy and notifies the \
               layout to the respective applications \
              "
HOMEPAGE    = "https://wiki.automotivelinux.org/windowmanager"
SECTION     = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://LICENSE.MIT;md5=a7514fe5664902e337bd8a4443d8f348"

DEPENDS = "af-binder json-c wayland wayland-ivi-extension wayland-native"

inherit cmake aglwgt

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-windowmanager-2017;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "64dc4d770b61d42761cb5f87ee8ae924eb46cd73"
S = "${WORKDIR}/git"

#If you would like to output log, uncomment out
EXTRA_OECMAKE_append_agl-devel = " -DENABLE_DEBUG_OUTPUT=ON "
