# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

FILESEXTRAPATHS:append := "${THISDIR}/files:"
SRC_URI += "\
    file://homescreen.service \
    file://cfg_gallery_on_bg-debug.json \
    file://cfg_gallery_on_bg-profile.json \
    file://cfg_gallery_on_bg-release.json \
    "

# install as user session.
do_install:append() {

    install -D -m0644 ${WORKDIR}/homescreen.service ${D}${systemd_user_unitdir}/homescreen.service

    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../homescreen.service ${D}${systemd_user_unitdir}/agl-session.target.wants/homescreen.service

    if [ ${PN} = "ivi-homescreen-runtimerelease" ]; then
        install -D -m0644 ${WORKDIR}/cfg_gallery_on_bg-release.json ${D}${datadir}/flutter/config/gallery_on_bg.json
    elif [ ${PN} = "ivi-homescreen-runtimedebug" ]; then
        install -D -m0644 ${WORKDIR}/cfg_gallery_on_bg-debug.json   ${D}${datadir}/flutter/config/gallery_on_bg.json
    elif [ ${PN} = "ivi-homescreen-runtimeprofile" ]; then
        install -D -m0644 ${WORKDIR}/cfg_gallery_on_bg-profile.json ${D}${datadir}/flutter/config/gallery_on_bg.json
    fi
}

FILES:${PN} += "\
    ${systemd_user_unitdir} \
    ${datadir}/flutter/config \
    "
