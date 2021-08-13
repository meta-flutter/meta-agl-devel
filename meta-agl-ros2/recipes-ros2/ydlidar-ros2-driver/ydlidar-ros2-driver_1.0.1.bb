inherit ros_distro_foxy
inherit ros_superflore_generated

SUMMARY = "YDLIDAR"
DESCRIPTION = "YDLIDAR driver recipe for ROS2 support."
AUTHOR = "Shankho Boron Ghosh"
ROS_AUTHOR = "Shankho Boron Ghosh"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d41d8cd98f00b204e9800998ecf8427e"

ROS_CN = "ydlidar_ros2_driver"
ROS_BPN = "ydlidar_ros2_driver"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    visualization-msgs \
    geometry-msgs \
    std-srvs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    visualization-msgs \
    geometry-msgs \
    std-srvs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"
#added
DEPENDS += "ydlidar-ros2-sdk"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

#ROS_BRANCH ?= "branch=release/foxy/ydlidar_ros2_driver"
SRC_URI = "git://github.com/YDLIDAR/ydlidar_ros2_driver;branch=master;protocol=https"
SRCREV = "2e095da315aec0a0bc5aaac12082cb9d1f97f8b5"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}