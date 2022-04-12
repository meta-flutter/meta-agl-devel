FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
            file://0001-backend-drm-Add-method-to-import-DRM-fd.patch \
            file://0002-Add-DRM-lease-support.patch \
            file://0001-compositor-do-not-request-repaint-in-output_enable.patch \
            "

PACKAGECONFIG[drm-lease] = "-Ddrm-lease=true,-Ddrm-lease=false,drm-lease-manager"
PACKAGECONFIG:append = " drm-lease"

RDEPENDS:${PN}:append = " drm-lease-manager"
