SUMMARY = "Baseline Flutter Image for Profiling"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    ivi-homescreen-profile \
    flutter-engine-profile \
    \
    flutter-gallery-profile \
    flutter-test-secure-storage-profile \
    flutter-test-texture-egl-profile \
    flutter-test-video-player-profile \
    \
    flutter-app-igalia-homescreen-profile \
    flutter-app-pumped-fuel-ped-profile	\
    "
