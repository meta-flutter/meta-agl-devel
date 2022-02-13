FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

DEPENDS:append = " drm-lease-manager"
DEPENDS:remove:class-native = " drm-lease-manager"
DEPENDS:remove:class-nativesdk = " drm-lease-manager"

SRC_URI:append = " file://0001-Add-drm-lease-client-support-to-eglfs-kms-backend.patch"
