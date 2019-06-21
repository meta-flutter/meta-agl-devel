SUMMARY = "WAM"
AUTHOR = "Jani Hautakangas <jani.hautakangas@lge.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit cmake

DEPENDS = "glib-2.0 jsoncpp boost chromium68 wayland-ivi-extension libhomescreen libwindowmanager"

EXTRA_OECMAKE = "\
    -DCMAKE_BUILD_TYPE=Release \
    -DCMAKE_INSTALL_PREFIX=${prefix} \
    -DPLATFORM_NAME=${@'${DISTRO}'.upper().replace('-', '_')} \
    -DCHROMIUM_SRC_DIR=${STAGING_INCDIR}/chromium68"

PR="r0"

PROVIDES += "virtual/webruntime"
RPROVIDES_${PN} += "virtual/webruntime"

SRC_URI = "git://github.com/webosose/${PN}.git;branch=@6.agl.guppy;protocol=https"
S = "${WORKDIR}/git"
SRCREV = "574c65bbd26937ad4552a51ad6ec438238af115e"

do_install_append() {
    install -d ${D}${sysconfdir}/wam
    install -v -m 644 ${S}/files/launch/security_policy.conf ${D}${sysconfdir}/wam/security_policy.conf
    install -d ${D}${systemd_user_unitdir}
    install -v -m 644 ${S}/files/launch/WebAppMgr.service ${D}${systemd_user_unitdir}/WebAppMgr.service
    install -d ${D}${sysconfdir}/default/
    install -v -m 644 ${S}/files/launch/WebAppMgr.env ${D}${sysconfdir}/default/WebAppMgr.env
    ln -snf WebAppMgr ${D}${bindir}/web-runtime
    install -d ${D}${sysconfdir}/systemd/user/default.target.wants
    ln -sf ${systemd_user_unitdir}/WebAppMgr.service ${D}${sysconfdir}/systemd/user/default.target.wants
}

pkg_postinst_${PN}_append() {
    chsmack -a "*" /usr/bin/WebAppMgr
    chsmack -a "*" /usr/lib/libWebAppMgr.so.1.0.0
    chsmack -a "*" /usr/lib/libWebAppMgrCore.so.1.0.0
    chsmack -a "*" /usr/lib/webappmanager/plugins/libwebappmgr-default-plugin.so
}

RDEPENDS_${PN} += "wam-tinyproxy"
FILES_${PN} += "${sysconfdir}/init ${sysconfdir}/wam ${libdir}/webappmanager/plugins/*.so ${systemd_user_unitdir}"

CXXFLAGS_append_agl-devel = " -DAGL_DEVEL"
