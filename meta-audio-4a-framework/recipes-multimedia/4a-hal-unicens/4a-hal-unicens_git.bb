SUMMARY     = "4A - Unicens (MOST) Binding"
DESCRIPTION = "Unicens binding (MOST audio network support) for 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://github.com/tjahnk/4a-hal-unicens"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab9a7a261563ca5dafa097c91369074"

DEPENDS += "lua"

SRC_URI = "gitsm://github.com/tjahnk/4a-hal-unicens;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "8be9b941f6364ba8f251ef6acb95350a8e289ce3"


PV = "0.1+git${SRCPV}"
S  = "${WORKDIR}/git"

inherit afb-system-cmake

do_install_append () {
    # installation folder for this plugin is '4a-hal'
    # get pkgdir - note that '4a-hal' comes from project ${project_git_repo}/conf.d/cmake/config.cmake
    PKGDIR=${D}/${INSTALL_PREFIX}/4a-hal

    # move all config files to a 'available' dir
    mv $PKGDIR/etc $PKGDIR/etc.available
}


