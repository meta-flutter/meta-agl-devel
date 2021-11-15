SUMMARY = "Baseline Flutter Image for Development"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    ivi-homescreen-debug \
    flutter-gallery-debug \
    flutter-engine-debug \
    "
