SUMMARY = "An AGL small image just capable of allowing a device to boot."

require recipes-platform/images/agl-image-boot.inc

LICENSE = "MIT"

IMAGE_INSTALL := " \
    packagegroup-core-boot \
    packagegroup-agl-basesystem \
"

# limit images built ...
IMAGE_FSTYPES := "ext4 tar"
