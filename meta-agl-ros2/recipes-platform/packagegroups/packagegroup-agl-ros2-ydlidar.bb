DESCRIPTION = "Support of ydlidar with ROS2"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-ros2-ydlidar \
    "

ALLOW_EMPTY:${PN} = "1"

RDEPENDS:${PN} += " \
      ydlidar-ros2-driver \
      "