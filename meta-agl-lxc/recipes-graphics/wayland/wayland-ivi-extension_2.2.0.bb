SUMMARY = "Wayland IVI Extension"
DESCRIPTION = "GENIVI Layer Management API based on Wayland IVI Extension"
HOMEPAGE = "https://github.com/COVESA/wayland-ivi-extension"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f1a56bb2dadf5f2be8eb342acf4ed79"

DEPENDS = "weston virtual/libgles2 pixman wayland-native"

PR = "r1"

SRC_URI = " \
    git://github.com/COVESA/${BPN}.git;protocol=https \
    file://01-ivi-input-controller-update-to-weston-7.patch \
    file://02-ivi-id-agent-update-to-weston-7-header.patch \
    file://03-ivi-id-agent-update-dependencies-to-build-on-weston-8.patch \
    file://0001-Fix-NULL-pointer-exception-in-case-of-no-input-devic.patch \
    "
SRCREV = "8d4c227ca0a1f836a769a051732a826abbf5d98a"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE := "-DWITH_ILM_INPUT=1"
EXTRA_OECMAKE += "-DLIB_SUFFIX=${@d.getVar('baselib').replace('lib', '')}"

FILES:${PN} += "${datadir}/wayland-protocols/stable/ivi-application/ivi-application.xml"
FILES:${PN} += "${libdir}/weston/*"
FILES:${PN}-dbg += "${libdir}/weston/.debug/*"

# Need these temporarily to prevent a non-fatal do_package_qa issue
INSANE_SKIP:${PN} += "dev-deps"
INSANE_SKIP:${PN}-dev += "dev-elf dev-so"
