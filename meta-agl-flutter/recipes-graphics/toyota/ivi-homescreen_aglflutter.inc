# Potentially pin SRCREV here.  Use upstream's AUTOINC default for
# development for now.
#SRCREV = ""

# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

# AGL specifics
IVI_HOMESCREEN_APP_OVERRIDE = "--a=/usr/share/gallery"

SERVICE_UNIT        = "Requires=weston.service\nAfter=weston.service"
SERVICE_USER_GROUP  = "User=weston\nGroup=weston"
SERVICE_RESTART     = ""
SERVICE_ENVIRONMENT = "Environment=XDG_RUNTIME_DIR=/run/user/200"
