FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-backend-drm-Add-method-to-import-DRM-fd.patch \
            file://0002-Add-DRM-lease-support.patch \
            "

PACKAGECONFIG[drm-lease] = "-Ddrm-lease=true,-Ddrm-lease=false,drm-lease-manager"
PACKAGECONFIG_append = " drm-lease"
