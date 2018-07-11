SUMMARY     = "4A - Generic HAL"
DESCRIPTION = "Generic HAL in 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://github.com/iotbzh/4a-hal-generic/"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "gitsm://github.com/iotbzh/4a-hal-generic;protocol=https;branch=${AGL_BRANCH}"
#SRCREV = "${AGL_APP_REVISION}"
SRCREV = "08b6e7144a87f60b86c8988c33a44dbd61026a8f"

DEPENDS += "lua"

PV = "0.1+git${SRCPV}"
S  = "${WORKDIR}/git"

inherit afb-system-cmake

# FIXME:
#FILES_${PN}-dev += "${INSTALL_PREFIX}/4a-hal/htdocs"
#FILES_${PN} += "${INSTALL_PREFIX}/afb-aaaa"
#FILES_${PN} += "${INSTALL_PREFIX}/lib"

# The package is machine-specific due to variable config content
PACKAGE_ARCH = "${MACHINE_ARCH}"

# when no specific HAL is defined, use a generic usb one
4A_HAL_LIST ??= "2ch-generic-usb"

# for specific machines, activate only known HALs
4A_HAL_LIST_m3ulcb          ?= "rcar-m3 rcar-m3kf"
4A_HAL_LIST_h3ulcb          ?= "rcar-m3 rcar-m3kf"
4A_HAL_LIST_intel-corei7-64 ?= "intel-minnow"
4A_HAL_LIST_qemux86-64      ?= "intel-qemu"
### TODO: this list should be completed for more machines

do_install_append () {
    # get pkgdir - note that '4a-hal' comes from project ${project_git_repo}/conf.d/cmake/config.cmake
    PKGDIR=${D}/${INSTALL_PREFIX}/4a-hal

    # move all config files to a 'available' dir
    mv $PKGDIR/etc $PKGDIR/etc.available

    # then install only required hals files in the etc folder
    mkdir -p $PKGDIR/etc
    for x in ${4A_HAL_LIST}; do
        hal=hal-4a-$x.json
        mv -v $PKGDIR/etc.available/${hal} $PKGDIR/etc/
    done
}
