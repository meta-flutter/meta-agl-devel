DESCRIPTION = "hal Package Groups"
LICENSE = "Apache-2.0"

inherit packagegroup

PACKAGES = "\
    packagegroup-bshalmake \
"
RDEPENDS:${PN} += " \
    libboot-hal \
    libcan-hal \
    libclock-hal \
    libdeck-hal \
    libinput-hal \
    libpower-hal \
    libsecurity-hal \
    libsoctemperature-hal \
    libusb-hal \
    libvehicle-hal \
    libvideo-in-hal \
    libnv-hal \
    libpositioning-hal \
"
