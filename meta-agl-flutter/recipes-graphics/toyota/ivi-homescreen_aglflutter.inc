# Pinned SRCREV
SRCREV = "87c5567703906cfc2acd9280b71580fb97724abe"

# AGL specifics
IVI_HOMESCREEN_APP_OVERRIDE = "--a=/usr/share/gallery"

SERVICE_UNIT        = "Requires=weston.service\nAfter=weston.service"
SERVICE_USER_GROUP  = "User=weston\nGroup=weston"
SERVICE_RESTART     = ""
SERVICE_ENVIRONMENT = "Environment=XDG_RUNTIME_DIR=/run/user/200"
