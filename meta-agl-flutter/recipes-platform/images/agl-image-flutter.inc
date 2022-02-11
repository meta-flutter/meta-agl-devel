require recipes-platform/images/agl-image-weston.inc

IMAGE_INSTALL:append = "\
    agl-compositor \
    agl-compositor-init \
    packagegroup-agl-profile-graphical \
    "

CLANGSDK = "1"
