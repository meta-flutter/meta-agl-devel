# gstreamer1.0-plugins-bad contains:
# * videoparsersbad plugin which contains h264parse element needed to demonstrate H.264 hardware decoding
# * waylandsink plugin
MACHINE_EXTRA_RDEPENDS:append = " \
    kernel-module-virtio-video \
    gstreamer1.0-plugins-bad \
"
