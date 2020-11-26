# base_do_install under poky's base.bbclass is empty so definition is needed.
bshalmake_do_install (){
    oe_runmake install

    install -d ${D}${includedir}/basesystem
    install -D -m 644 ${S}/hal_api/*.h ${D}${includedir}/basesystem
}

EXPORT_FUNCTIONS do_install

FILES_${PN}-dev_remove = "${FILES_SOLIBSDEV}"

