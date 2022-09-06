SUMMARY = "Baseline Flutter Image for Profiling"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    flutter-auto-runtimeprofile \
    \
    flutter-engine-runtimeprofile-sdk-dev \
    \
    flutter-gallery-runtimeprofile \
    flutter-test-texture-egl-runtimeprofile \
    flutter-test-secure-storage-runtimeprofile \
    flutter-test-localization-runtimeprofile \
    \
    flutter-app-igalia-homescreen-runtimeprofile \
    "

IMAGE_FEATURES:append = "\
    ssh-server-openssh \
    "
