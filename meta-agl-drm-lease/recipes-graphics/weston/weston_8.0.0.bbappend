FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
            file://0001-backend-drm-Add-method-to-import-DRM-fd.patch \
            file://0002-Add-DRM-lease-support.patch \
            file://0003-launcher-do-not-touch-VT-tty-while-using-non-default.patch \
            file://0004-launcher-direct-handle-seat0-without-VTs.patch \
            file://0001-compositor-do-not-request-repaint-in-output_enable.patch \
            "

PACKAGECONFIG[drm-lease] = "-Ddrm-lease=true,-Ddrm-lease=false,drm-lease-manager"
PACKAGECONFIG_append = " drm-lease"
