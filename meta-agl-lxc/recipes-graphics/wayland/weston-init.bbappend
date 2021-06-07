FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

AGL_DEFAULT_WESTONSTART ??= "/usr/bin/weston --config ${sysconfdir}/xdg/weston/weston.ini"
WESTONARGS ?= "--idle-time=0 --drm-lease=\${DRM_LEASE_DEVICE}"

WESTONSTART ??= "${AGL_DEFAULT_WESTONSTART} ${WESTONARGS}"
WESTONSTART_append = " ${@bb.utils.contains("DISTRO_FEATURES", "agl-devel", " --debug", "",d)}"

WIFILES = " \
    file://drm-lease.conf.in \
"

SRC_URI_append = " ${WIFILES}"

do_install_append() {
    # Process ".in" files
    files=$(echo ${WIFILES} | sed s,file://,,g)
    for f in ${files}; do
        g=${f%.in}
        if [ "${f}" != "${g}" ]; then
            sed -e "s,@WESTONUSER@,${WESTONUSER},g" \
                -e "s,@WESTONGROUP@,${WESTONGROUP},g" \
                -e "s,@XDG_RUNTIME_DIR@,${DISPLAY_XDG_RUNTIME_DIR},g" \
                -e "s,@WESTONSTART@,${WESTONSTART},g" \
                -e "s,@WESTON_DRM_DEVICE@,${WESTON_DRM_DEVICE},g" \
                    ${WORKDIR}/${f} > ${WORKDIR}/${g}
        fi
    done

    # Install weston drop-in
    install -d ${D}${systemd_system_unitdir}/weston@.service.d
    install -m644 ${WORKDIR}/drm-lease.conf ${D}/${systemd_system_unitdir}/weston@.service.d/

    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants
    ln -s ../weston@.service ${D}${systemd_system_unitdir}/multi-user.target.wants/weston@root.service
}

FILES_${PN} += " \
    ${systemd_system_unitdir}/ \
"
