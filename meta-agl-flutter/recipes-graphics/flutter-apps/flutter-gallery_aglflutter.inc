FILESEXTRAPATHS:prepend := "${THISDIR}/flutter-gallery:"

SRC_URI += " \
    file://flutter-gallery.service \
    file://gallery_on_bg.json \
"

# To avoid conflicts with the systemd template scheme added via bbappend in
# meta-agl-demo, package the standalone systemd unit separately.  This is not
# needed when meta-agl-flutter is used without meta-agl-demo, but that is not
# going to be the default usecase for most users, so this still allows them to
# build working agl-image-flutter images in the same build tree.
#
# This can be dropped if/when flutter-gallery is no longer packaged as a demo
# in meta-agl-demo.

#SYSTEMD_SERVICE:${PN}-init = "flutter-gallery.service"

do_install:append() {
    install -D -m 0644 ${WORKDIR}/flutter-gallery.service ${D}${systemd_user_unitdir}/flutter-gallery.service
    install -d ${D}${systemd_user_unitdir}/agl-session.target.wants
    ln -s ../flutter-gallery.service ${D}${systemd_user_unitdir}/agl-session.target.wants/flutter-gallery.service

    install -D -m 0644 ${WORKDIR}/gallery_on_bg.json ${D}${datadir}/flutter/default.json
}

PACKAGE_BEFORE_PN += "${PN}-init"

FILES:${PN} += "${datadir}"

FILES:${PN}-init = "${systemd_user_unitdir}"

RDEPENDS:${PN}-init = "${PN}"