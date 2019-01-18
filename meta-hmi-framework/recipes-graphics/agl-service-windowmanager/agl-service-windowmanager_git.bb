SUMMARY     = "Window Manager service binding for applications"
DESCRIPTION = "Window Manager is the service binding for controlling \
               rendering rights. Applications request to render itself, \
               then Window Manager checks the policy and notifies the \
               layout to the respective applications \
              "
HOMEPAGE    = "https://wiki.automotivelinux.org/windowmanager"
SECTION     = "graphics"
LICENSE     = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

DEPENDS = "af-binder json-c wayland wayland-ivi-extension wayland-native"

inherit cmake aglwgt

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/apps/agl-service-windowmanager;protocol=https;branch=${AGL_BRANCH} \
           file://weston-ready.conf \
"
SRCREV = "fb861c2f05e5f49f4009d0d7c91101259f904f1d"
PV = "1.0+git${SRCPV}"
S = "${WORKDIR}/git"

#If you would like to output log, uncomment out
EXTRA_OECMAKE_append_agl-devel = " -DENABLE_DEBUG_OUTPUT=ON "

do_install_append() {
    # Install systemd over-ride that adds a dependency on weston-ready
    # to ensure that the windowmanager and its dependencies start after
    # weston is actually initialized.
    install -d ${D}${sysconfdir}/systemd/system/afm-api-windowmanager@.service.d
    install -m 0644 ${WORKDIR}/weston-ready.conf ${D}${sysconfdir}/systemd/system/afm-api-windowmanager@.service.d
}

FILES_${PN} += "${systemd_system_unitdir}"

REDEPENDS_${PN} += "weston-ready"
