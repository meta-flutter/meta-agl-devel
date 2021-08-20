# Needed for the required gstreamer-app-1.0 pkgconfig bits
DEPENDS += "gstreamer1.0-plugins-base"

# Need to enable PipeWire support
EXTRA_OECMAKE += "-DUSE_PIPEWIRE=1"

# Pull static library into appropriate package to avoid a QA error
FILES:${PN}-staticdev += "${AAC_PREFIX}/lib/libaal.a"
