# agl-ros2

# Layer dependencies for meta-ros2
# Add meta-ros layers : https://growupboron.github.io/blog/gsoc-weekly-update-week-2/
# Add ydlidar-drivers : https://growupboron.github.io/blog/gsoc-weekly-update-week-4/

AGL_META_PYTHON = "${METADIR}/external/meta-openembedded/meta-python"

BBLAYERS =+ " \
            ${METADIR}/external/meta-ros/meta-ros-common \
            ${METADIR}/external/meta-ros/meta-ros-backports-gatesgarth \
            ${METADIR}/external/meta-ros/meta-ros-backports-hardknott \
            ${METADIR}/external/meta-ros/meta-ros2 \
            ${METADIR}/external/meta-ros/meta-ros2-foxy \
            ${METADIR}/external/meta-qt5 \
            ${METADIR}/meta-agl-devel/meta-agl-ros2 \
            "