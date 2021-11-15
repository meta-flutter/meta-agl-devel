SUMMARY = "Baseline Flutter Image for Profiling"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    ivi-homescreen-profile \
    flutter-gallery-profile \
    flutter-engine-profile \
    "
