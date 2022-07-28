# For now disable gstreamer to avoid needing to enable "commercial"
# licenses for the stated ffmpeg dependency.
PACKAGECONFIG:remove = "gstreamer"

# Enable verbose logging on runtimedebug image
PACKAGECONFIG:append:runtimedebug = "verbose"


USER_SERVICE = "flutter-auto.service"

FILESEXTRAPATHS:append := "${THISDIR}/files:"
SRC_URI += "\
    file://${USER_SERVICE} \
    file://gallery_on_bg-debug.json \
    file://gallery_on_bg-profile.json \
    file://gallery_on_bg-release.json \
    "


cmake_do_install:append() {

    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    install -D -m0644 ${WORKDIR}/${USER_SERVICE} ${D}${systemd_user_unitdir}/${USER_SERVICE}

    install -D -m0644 ${WORKDIR}/gallery_on_bg-release.json ${D}${datadir}/flutter/default.json
}

cmake_do_install:append:runtimedebug() {

    # the dev host controls starting/stopping the flutter-auto process when runtime=debug
    install -D -m0644 ${WORKDIR}/gallery_on_bg-debug.json ${D}${datadir}/flutter/default.json
}

cmake_do_install:append:runtimeprofile() {

    # the dev host controls starting/stopping the flutter-auto process when runtime=profile
    install -D -m0644 ${WORKDIR}/gallery_on_bg-profile.json ${D}${datadir}/flutter/default.json
}


FILES:${PN} += "\
    ${systemd_user_unitdir} \
    ${datadir} \
    "
