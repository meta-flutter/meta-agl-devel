SUMMARY = "Baseline Flutter Image for Release"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    ivi-homescreen-release \
    flutter-gallery-release \
    flutter-engine-release \
    "
