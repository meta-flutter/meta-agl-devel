COMPATIBLE_MACHINE = "rcar-gen3"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-drm-enable-dumb-buffer-ops-for-render-nodes.patch \
    file://0002-drm-rcar-du-enable-rcar-du-render-node.patch \
"

