RDEPENDS_${PN} += " \
	alexa-voiceagent-service \
	${@bb.utils.contains("DISTRO_FEATURES", "agl-demo-preload", "virtual/alexa-voiceagent-config", "",d)} \
"
