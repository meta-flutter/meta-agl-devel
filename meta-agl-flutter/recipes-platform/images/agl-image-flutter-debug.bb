SUMMARY = "Baseline Flutter Image for Development"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    ivi-homescreen-debug \
    flutter-engine-debug \
    \
    flutter-gallery-debug \
    flutter-test-secure-storage-debug \
    flutter-test-texture-egl-debug \
    flutter-test-video-player-debug \
    \
    flutter-app-igalia-homescreen-debug \
    flutter-app-pumped-fuel-ped-debug \
    "
