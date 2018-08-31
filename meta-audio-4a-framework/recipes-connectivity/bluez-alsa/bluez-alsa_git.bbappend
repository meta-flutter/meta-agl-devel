# THIS IS A TEMPORARY WORKAROUND TO IMPLEMENT PERSISTENT PCMS FOR SOFTMIXER

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Added-a-connection-proxy-plugin.patch"

FILES_${PN} += "\
  ${libdir}/alsa-lib/libasound_module_pcm_bluealsa_proxy.so\
  ${datadir}/alsa/alsa.conf.d/20-bluealsa_proxy.conf\
"

