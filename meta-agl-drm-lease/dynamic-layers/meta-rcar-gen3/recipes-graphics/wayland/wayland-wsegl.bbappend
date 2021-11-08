FILESEXTRAPATHS:prepend:rcar-gen3 := "${THISDIR}/${PN}:"

SRC_URI:append:rcar-gen3 = " \
    file://0001-waylandws_client-Ensure-that-supported-DMAbuf-format.patch \
    file://0002-waylandws_client-Rename-DRM-device-setup-function.patch \
"
