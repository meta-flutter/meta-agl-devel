# agl-ros2

# Contains minimal ros2 feature that is neccesary to run YDLIDAR drivers.
IMAGE_INSTALL:append = " packagegroup-agl-ros2-minimal"
IMAGE_INSTALL:append = " packagegroup-agl-ros2-ydlidar"

# Adds Qt support to the built image
IMAGE_INSTALL:append = " packagegroup-agl-ros-native-qt5"