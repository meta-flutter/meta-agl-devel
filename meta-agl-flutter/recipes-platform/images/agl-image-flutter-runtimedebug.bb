SUMMARY = "Baseline Flutter Image for Development"

LICENSE = "MIT"

require agl-image-flutter.inc

IMAGE_INSTALL:append = "\
    weston-ini-conf-landscape \
    \
    flutter-auto-runtimedebug \
    \
    flutter-engine-runtimedebug-sdk-dev \
    "

IMAGE_FEATURES:append = "\
    ssh-server-openssh \
    "
