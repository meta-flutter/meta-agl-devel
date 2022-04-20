# Potentially pin SRCREV here.  Use upstream's AUTOINC default for
# development for now.
#SRCREV = ""

# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

# AGL specifics
IVI_HOMESCREEN_APP_OVERRIDE = "--a=/usr/share/gallery"

SERVICE_UNIT        = "Requires=agl-compositor.service\nAfter=agl-compositor.service"
SERVICE_INSTALL     = "WantedBy=agl-session.target"
# we have a regular/agl-driver user, so avoid setting one
SERVICE_ENVIRONMENT = ""
SERVICE_USER_GROUP  = ""
SERVICE_RESTART	    = "Restart=on-failure"

# we need to install as user session, not root.
do_install:append() {
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    install -m0644 ${WORKDIR}/homescreen.service ${D}${systemd_user_unitdir}/homescreen.service
    ln -s ../homescreen.service ${D}${systemd_user_unitdir}/agl-session.target.wants/homescreen.service
}

FILES:${PN} += " ${systemd_user_unitdir}"
