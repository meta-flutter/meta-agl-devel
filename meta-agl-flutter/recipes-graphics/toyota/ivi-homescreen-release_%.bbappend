require ${@bb.utils.contains('AGL_FEATURES', 'agl-flutter', '${BPN}_aglflutter.inc', '', d)}

IVI_HOMESCREEN_APP_OVERRIDE = "--a=/usr/share/gallery"

SERVICE_UNIT        = "Requires=weston.service\nAfter=weston.service"
SERVICE_USER_GROUP  = "User=weston\nGroup=weston"
SERVICE_RESTART     = ""
SERVICE_ENVIRONMENT = "Environment=XDG_RUNTIME_DIR=/run/user/200"
