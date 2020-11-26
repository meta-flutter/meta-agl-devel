# base_do_install under poky's base.bbclass is empty so definition is needed.
bshalmake_do_install (){
    oe_runmake DESTDIR=${D} install

    install -d ${D}${includedir}/basesystem
    install -D -m 644 ${S}/hal_api/*.h ${D}${includedir}/basesystem
}

#BaseSystem's .so does not have multiple versions. Therefore, overwrite these variables.
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

EXPORT_FUNCTIONS do_install
