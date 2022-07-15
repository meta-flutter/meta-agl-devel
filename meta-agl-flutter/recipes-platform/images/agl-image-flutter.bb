SUMMARY = "Baseline Flutter Image for Release"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    ivi-homescreen-release \
    flutter-engine-release \
    \
    flutter-gallery-release \
    flutter-test-secure-storage-release \
    flutter-test-texture-egl-release \
    flutter-test-video-player-release \
    \
    flutter-app-igalia-homescreen-flutterrelease \
    flutter-app-pumped-fuel-ped-flutterrelease \
    "
