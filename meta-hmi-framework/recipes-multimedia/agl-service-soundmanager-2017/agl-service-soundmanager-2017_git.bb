SUMMARY     = "Sound Manager binding and client library for application"
ESCRIPTION = "Sound Manager is the binding library to communicate \
	with Genivi Audio Manager. Genivi Audio Manager is the policy manager \
	about sound. It controls volume and routing according to various situations.\
	This recipe also provides client library to communicate with sound manager. \
	"
HOMEPAGE    = "https://wiki.automotivelinux.org/soundmanager"
S = "${WORKDIR}/git"
SECTION = "multimedia"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae6497158920d9524cf208c09cc4c984"
DEPENDS = "dbus glib-2.0 af-binder json-c"
RDEPENDS_${PN} = "audiomanager audiomanager-plugins"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-soundmanager-2017;protocol=https;branch=master"
SRCREV = "4bf8930f4f56eae60cf4562b9a601c828f2bd501"

inherit cmake aglwgt

do_install_append() {
	install -d ${D}${sysconfdir}/dbus-1/system.d
	install -m 0644 ${S}/conf/soundmanager-dbus.conf ${D}${sysconfdir}/dbus-1/system.d/
	install -d ${D}${libdir}/pkgconfig
	install -m 0644 ${B}/soundmanager.pc ${D}${libdir}/pkgconfig
	install -d ${D}${includedir}
	install -m 0644 ${S}/include/libsoundmanager.hpp ${D}${includedir}

	install -m -0755 ${B}/libsoundmanager/libsoundmanager.so ${D}${libdir}/libsoundmanager.so.0.1
	ln -sf libsoundmanager.so.0.1 ${D}${libdir}/libsoundmanager.so
}

FILES_${PN} += "${sysconfdir}/dbus-1/system.d/soundmanager-dbus.conf"
