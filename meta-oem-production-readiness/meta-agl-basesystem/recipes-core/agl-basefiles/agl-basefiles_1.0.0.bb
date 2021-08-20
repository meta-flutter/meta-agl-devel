SUMMARY = "base-files for AGL software"
DESCRIPTION = "install base-files to build AGL software"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

PV = "1.0.0+gitr${SRCPV}"
SRC_URI = "git://gerrit.automotivelinux.org/gerrit/staging/basesystem.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV := "${BASESYSTEM_REVISION}"

S = "${WORKDIR}/git/agl-basefiles"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}${includedir}/basesystem
    install -m 644 -D ${S}/include/* ${D}${includedir}/basesystem/
}

do_install:class-native() {
    install -d ${D}${bindir}
    install -m 755 -D ${S}/bin/launch_xml2cfg.sh ${D}${bindir}/
}

RDEPENDS:${PN} += "bash"

BBCLASSEXTEND = "native"
