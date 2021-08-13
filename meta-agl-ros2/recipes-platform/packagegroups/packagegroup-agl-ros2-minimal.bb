DESCRIPTION = "The minimal set of packages required to ROS2"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-agl-ros2-minimal \
    "

RDEPENDS:${PN} += " \
      action-msgs \
      ament-cmake \
      ament-index-cpp \
      ament-index-python \
      ament-package \
      builtin-interfaces \
      class-loader \
      composition-interfaces \
      console-bridge-vendor \
      fastrtps \
      foonathan-memory-vendor \
      geometry-msgs \
      launch \
      launch-ros \
      libstatistics-collector \
      libyaml-vendor \
      lifecycle-msgs \
      message-filters \
      osrf-pycommon \
      rcl \
      rcl-action \
      rcl-interfaces \
      rcl-logging-spdlog \
      rcl-yaml-param-parser \
      rclcpp \
      rclcpp-action \
      rclcpp-components \
      rclpy \
      rcpputils \
      rcutils \
      rmw \
      rmw-dds-common \
      rmw-fastrtps-cpp \
      rmw-fastrtps-shared-cpp \
      rmw-implementation \
      rmw-implementation-cmake \
      ros-workspace \
      ros2cli \
      ros2launch \
      ros2pkg \
      ros2topic \
      rosgraph-msgs \
      rosidl-adapter \
      rosidl-cmake \
      rosidl-default-runtime \
      rosidl-generator-c \
      rosidl-generator-py \
      rosidl-parser \
      rosidl-runtime-c \
      rosidl-runtime-cpp \
      rosidl-runtime-py \
      rosidl-typesupport-c \
      rosidl-typesupport-cpp \
      rosidl-typesupport-fastrtps-c \
      rosidl-typesupport-fastrtps-cpp \
      rosidl-typesupport-interface \
      rosidl-typesupport-introspection-c \
      rosidl-typesupport-introspection-cpp \
      rpyutils \
      sensor-msgs \
      spdlog-vendor \
      statistics-msgs \
      std-msgs \
      std-srvs \
      tf2 \
      tf2-msgs \
      tf2-py \
      tf2-ros \
      unique-identifier-msgs \
      visualization-msgs \
      "