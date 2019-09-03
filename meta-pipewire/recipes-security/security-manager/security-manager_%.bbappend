FILESEXTRAPATHS_prepend := "${THISDIR}/security-manager:"
SRC_URI += "\
    file://0001-Adapt-smack-rules-to-allow-connections-to-pipewire.patch \
    file://0002-Grant-dbus-privilege-to-pipewire.patch \
    "
