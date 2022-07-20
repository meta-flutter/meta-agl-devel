# Upstream is now pinning ivi-homescreen
#SRCREV = ""

# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

FILESEXTRAPATHS:append := "${THISDIR}/files:"
SRC_URI += "file://config.json"

# AGL specifics
IVI_HOMESCREEN_APP_OVERRIDE = "--b=/usr/share/flutter/gallery --j=/usr/share/flutter/config.json"

SERVICE_UNIT        = "Requires=agl-compositor.service\nAfter=agl-compositor.service"
SERVICE_INSTALL     = "WantedBy=agl-session.target"
# we have a regular/agl-driver user, so avoid setting one
SERVICE_ENVIRONMENT = ""
SERVICE_USER_GROUP  = ""
SERVICE_RESTART	    = "Restart=on-failure"

# we need to install as user session, not root.
do_install:append() {
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    install -D -m 0644 ${WORKDIR}/config.json ${D}${datadir}/flutter/config.json
    install -m0644 ${WORKDIR}/homescreen.service ${D}${systemd_user_unitdir}/homescreen.service
    ln -s ../homescreen.service ${D}${systemd_user_unitdir}/agl-session.target.wants/homescreen.service
}

FILES:${PN} += " ${systemd_user_unitdir} ${datadir}/flutter/config.json"
