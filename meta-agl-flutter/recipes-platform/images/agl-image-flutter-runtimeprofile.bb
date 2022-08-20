SUMMARY = "Baseline Flutter Image for Profiling"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    openssh \
    weston-ini-conf-landscape \
    \
    flutter-auto-runtimeprofile \
    \
    flutter-gallery-runtimeprofile \
    flutter-test-texture-egl-runtimeprofile \
    flutter-test-secure-storage-runtimeprofile \
    flutter-test-localization-runtimeprofile \
    \
    flutter-app-igalia-homescreen-runtimeprofile \
    flutter-app-pumped-fuel-ped-runtimeprofile	\
    "
