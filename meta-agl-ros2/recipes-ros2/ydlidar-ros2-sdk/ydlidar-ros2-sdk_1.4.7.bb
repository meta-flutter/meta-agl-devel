SUMMARY = "YDLIDAR-SDK"
DESCRIPTION = "YDLIDAR-SDK as it a dependency for ydlidar_ros2_driver."
AUTHOR = "Shankho Boron Ghosh"
ROS_AUTHOR = "Shankho Boron Ghosh"
HOMEPAGE = "https://github.com/YDLIDAR/YDLIDAR/YDLidar-SDK"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4e320231d59c825e45dbfda066af29c9"

SRC_URI = "git://github.com/YDLIDAR/YDLidar-SDK.git;protocol=https"

SRCREV = "8b287ed831db0892f51793650b438790442fa09c"

S = "${WORKDIR}/git"

inherit cmake

FILES_${PN} += "${datadir} ${prefix}/startup"

do_install:append() {
    sed -i -e 's|${DEBUG_PREFIX_MAP}||g; s|--sysroot=${STAGING_DIR_TARGET}||g' ${D}${libdir}/pkgconfig/*.pc
}

RDEPENDS:${PN} += "bash"