COMPATIBLE_MACHINE = "rcar-gen3"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://0001-drm-enable-dumb-buffer-ops-for-render-nodes.patch \
    file://0002-drm-rcar-du-support-render-node.patch \
"

