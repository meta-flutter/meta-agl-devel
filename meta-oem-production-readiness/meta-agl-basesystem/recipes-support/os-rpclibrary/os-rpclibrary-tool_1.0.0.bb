SUMMARY = "librpc tools for AGL software"
DESCRIPTION = "install librpc tool"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS += " \
    agl-basefiles-native \
    bison-native \
"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/service/other/rpc_library/tool"

do_compile:prepend () {
    oe_runmake clean
}

do_install () {
    install -D -m 755 ${S}/rpc_apidef ${D}${bindir}/rpc_apidef
}

FILES:${PN} += " \
    ${bindir}/rpc_apidef \
"

BBCLASSEXTEND = "native"
