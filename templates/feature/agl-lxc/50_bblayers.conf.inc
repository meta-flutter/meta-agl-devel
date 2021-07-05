AGL_META_PYTHON = "${METADIR}/external/meta-openembedded/meta-python"
AGL_META_NETWORKING = "${METADIR}/external/meta-openembedded/meta-networking"
AGL_META_FILESYSTEMS = "${METADIR}/external/meta-openembedded/meta-filesystems"
AGL_META_VIRTUALIZATION = "${METADIR}/external/meta-virtualization"

BBLAYERS =+ " \
  ${METADIR}/external/meta-qt5 \
  ${METADIR}/meta-agl-devel/meta-agl-lxc \
"
