# poky's base.bbclass must be named Makefile, makefile, or GNUmakefile to be processed.
# The names of the basesystem Makefile are Makefile.client and Makefile.server,so you
# need to define a do_compile to process the Makefile.
bsmake_do_compile (){
    oe_runmake -f ${BSMAKE_FILE}
}

# base_do_install under poky's base.bbclass is empty so definition is needed.
bsmake_do_install (){
    oe_runmake  -f ${BSMAKE_FILE} DESTDIR=${D} install
}

EXPORT_FUNCTIONS do_compile do_install
