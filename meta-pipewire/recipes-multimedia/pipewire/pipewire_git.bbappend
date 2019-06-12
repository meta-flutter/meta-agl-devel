do_install_append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        # Execute these manually on behalf of systemctl script (from systemd-systemctl-native.bb)
        # because it does not support systemd's user mode.
        mkdir -p ${D}${sysconfdir}/systemd/user/sockets.target.wants/
        ln -sf ${systemd_user_unitdir}/pipewire.socket ${D}${sysconfdir}/systemd/user/sockets.target.wants/pipewire.socket
    fi
}

FILES_${PN} += "${sysconfdir}/systemd/user/"

