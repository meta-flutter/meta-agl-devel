FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS_append = " gstreamer1.0-plugins-base"

PACKAGECONFIG_append = " remoting"

PACKAGECONFIG[remoting] = " --enable-remoting"

SRC_URI_append = " \
    file://0001-remoting-Fix-remoting-gbm-dependency.patch \
    file://0002-main-change-remoting-initialization-timing.patch \
"
