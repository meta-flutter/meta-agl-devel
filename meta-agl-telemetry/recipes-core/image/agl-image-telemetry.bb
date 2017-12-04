SUMMARY = "The tiniest AGL image just capable of embedded command line utilities."
require agl-image-telemetry.inc

LICENSE = "MIT"

IMAGE_INSTALL_append = "\
    packagegroup-agl-image-telemetry \
    "
