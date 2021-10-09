SUMMARY = "A minimal container host image"

require recipes-platform/images/agl-image-boot.inc

IMAGE_INSTALL += " \
    lxc \
    ${LXC_CONTAINER_CONFIGS} \
"

CONTAINER_IMAGES ??= ""

LXC_CONTAINER_CONFIGS ?= ""

IMAGE_LINGUAS = " "

NO_RECOMMENDATIONS = "1"

# Handle modification of IMAGE_LINK_NAME done by ULCB builds with Kingfisher support
MACHINE_SUFFIX = "${@bb.utils.contains('AGL_FEATURES', 'kingfisher', '-kf', '', d)}"

python __anonymous() {
    for c in (d.getVar('CONTAINER_IMAGES') or "").split():
        (mc, image) = c.split(':')
        dependency = 'mc::' + mc + ':' + image + ':do_image_complete'
        d.appendVarFlag('do_rootfs', 'mcdepends', ' ' + dependency)

        # Assume there is a X-lxc-config package for guest-image-X
        config = image
        if config.startswith('guest-image-'):
            config = config[len('guest-image-'):]
        d.appendVar('LXC_CONTAINER_CONFIGS', ' ' + 'lxc-config-' + config)
}

install_container_images() {
    for c in ${CONTAINER_IMAGES}; do
        config=${c%:*}
        image=${c#*:}
        name=${image#guest-image-}
        rm -rf  ${IMAGE_ROOTFS}/var/lib/machines/${name}
        install -m 0755 -d ${IMAGE_ROOTFS}/var/lib/machines/${name}
        src="${TOPDIR}/tmp-${config}/deploy/images/${MACHINE}/${image}-${MACHINE}${MACHINE_SUFFIX}.tar.bz2"
        bbnote "Installing ${src}"
        tar -C ${IMAGE_ROOTFS}/var/lib/machines/${name} -xf ${src}
    done
}

#
# Force rebuild of rootfs on every build to work around mcdepends issue
#
# NOTE:
# This is currently required as bitbake fails to trigger do_rootfs
# sometimes even when the guest image has in fact rebuilt.  This is
# being investigated with upstream.
#
do_rootfs[nostamp] = "1"

ROOTFS_POSTPROCESS_COMMAND += "install_container_images; "

IMAGE_ROOTFS_EXTRA_SPACE:append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

