# Needed for the required gstreamer-app-1.0 pkgconfig bits
DEPENDS += "gstreamer1.0-plugins-base"

# Pull static library into appropriate package to avoid a QA error
FILES_${PN}-staticdev += "${AAC_PREFIX}/lib/libaal.a"
