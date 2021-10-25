DEPENDS:remove:aglcontainerguest = "${@oe.utils.conditional("PREFERRED_PROVIDER_virtual/kernel", "linux-dummy", "linux-renesas", "", d)}"

do_configure[depends] = "${@oe.utils.conditional("PREFERRED_PROVIDER_virtual/kernel", "linux-dummy", "", "make-mod-scripts:do_compile", d)}"

python __anonymous () {
    # Need to use inline python here as, contrary to the BitBake docs,
    # having noexec set at all disables the task, so using
    # oe.utils.conditional to set it to "0" still ends up with the task
    # disabled.
    if d.getVar("PREFERRED_PROVIDER_virtual/kernel") == "linux-dummy":
        d.setVarFlag("do_compile", "noexec", "1")
}

do_install:aglcontainerguest() {
    # Create destination directory
    install -d ${D}/${includedir}/
}

# Guest doesn't build the module, so go ahead and quiet warnings about
# double '/' in base recipe definition
FILES_${PN}:aglcontainerguest = ""
