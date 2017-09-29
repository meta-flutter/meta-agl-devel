SUMMARY     = "Window Manager binding and client library for application"
DESCRIPTION = "Window Manager 2017 is the binding library  \
	"
HOMEPAGE    = ""
S = "${WORKDIR}/git"
SECTION = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
DEPENDS = "af-binder json-c wayland wayland-ivi-extension"
RDEPENDS_${PN} = " \
	"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-windowmanager-2017;protocol=https;branch=master"
SRCREV = "797eac5c26337df9d444e0a5e396be93454249dd"

inherit cmake aglwgt

#If you would like to output log, uncomment out
#EXTRA_OECMAKE = " -DENABLE_DEBUG_OUTPUT=ON "

do_install_append() {
    install -d ${D}${sysconfdir}/windowmanager
    install -m 0644 ${S}/layers.json ${D}${sysconfdir}/windowmanager/
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${B}/windowmanager.pc ${D}${libdir}/pkgconfig
    install -d ${D}${includedir}
    install -m 0644 ${S}/libwindowmanager/libwindowmanager.h ${D}${includedir}

    install -m -0755 ${B}/libwindowmanager/libwindowmanager.so ${D}${libdir}/libwindowmanager.so.0.1
    ln -sf libwindowmanager.so.0.1 ${D}${libdir}/libwindowmanager.so
}
FILES_${PN} += "${sysconfdir}/windowmanager/layers.json"
