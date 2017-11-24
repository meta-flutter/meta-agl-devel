FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://90-4a-modules.pa"

# Add .include directive to default.pa so optional configuration can be added
do_install_append () {
    if [ ! -e ${D}${sysconfdir}/pulse/default.d/ ]; then
        echo ".include ${sysconfdir}/pulse/default.d" >> ${D}${sysconfdir}/pulse/default.pa
        install -d ${D}${sysconfdir}/pulse/default.d
    fi
    install -m 0644 ${WORKDIR}/90-4a-modules.pa ${D}${sysconfdir}/pulse/default.d/

    for m in module-udev-detect module-suspend-on-idle;do
        sed -i -e "s|^load-module ${m}|#load-module ${m}|" ${D}${sysconfdir}/pulse/default.pa
    done
}
