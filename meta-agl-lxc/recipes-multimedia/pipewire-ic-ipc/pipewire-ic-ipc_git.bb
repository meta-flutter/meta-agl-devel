SUMMARY     = "PipeWire AGL Instrument Cluster IPC"
AUTHOR      = "George Kiagiadakis <george.kiagiadakis@collabora.com>"
SECTION     = "multimedia"
LICENSE     = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;beginline=3;md5=e8ad01a5182f2c1b3a2640e9ea268264"

PV = "0.1+git${SRCPV}"

SRC_URI = "git://gerrit.automotivelinux.org/gerrit/src/pipewire-ic-ipc.git;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "f93f9cda5d8a380bc8846b5de3fc24613466adf3"

S  = "${WORKDIR}/git"

inherit meson pkgconfig systemd

# build the server on the host
PACKAGECONFIG = "\
    server \
    ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
"
# only the example client in the guest
PACKAGECONFIG_aglcontainerguest = "client"

# systemd integration for the server-side component
PACKAGECONFIG[systemd] = "-Dsystemd=enabled,-Dsystemd=disabled,systemd"
# server-side component
PACKAGECONFIG[server] = "-Dserver=true,-Dserver=false,pipewire"
# example client; not needed if you use the icipc library in your IC applciation
PACKAGECONFIG[client] = "-Dclient=true,-Dclient=false,"

# server-side systemd service
SYSTEMD_SERVICE_${PN} = "${@bb.utils.contains('PACKAGECONFIG', 'systemd', 'pipewire-ic-ipc.service', '', d)}"

FILES_${PN} += "\
    ${datadir}/pipewire/* \
    ${libdir}/pipewire-0.3/* \
"
