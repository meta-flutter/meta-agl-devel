SUMMARY = "Baseline Flutter Image for Release"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    flutter-auto-runtimerelease \
    \
    flutter-engine-runtimerelease-sdk-dev \
    \
    flutter-gallery-runtimerelease \
    flutter-test-animated-background-runtimerelease \
    flutter-test-texture-egl-runtimerelease \
    flutter-test-secure-storage-runtimerelease \
    flutter-test-localization-runtimerelease \
    \
    flutter-app-igalia-homescreen-runtimerelease \
    flutter-app-pumped-fuel-ped-runtimerelease \
    "
