inherit bshalmake

FILES_${PN}-dev_remove = "${FILES_SOLIBSDEV}" 

EXTRA_OEMAKE = "'CXX=${CXX}' 'CC=${CC}' 'RANLIB=${RANLIB}' 'AR=${AR}' 'DESTDIR=${D}' 'SDKTARGETSYSROOT=${STAGING_DIR_HOST}'"

DEPENDS_append = " agl-basefiles"


