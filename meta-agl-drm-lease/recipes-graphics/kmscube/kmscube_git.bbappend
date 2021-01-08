FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"


SRC_URI += "file://0001-texturator-Use-correct-GL-extension-header.patch \
            file://0002-Add-DRM-lease-support.patch"

PACKAGECONFIG += "drm-lease"
PACKAGECONFIG[drm-lease] = "-Ddrm_lease=enabled,-Ddrm_lease=disabled,drm-lease-manager"
