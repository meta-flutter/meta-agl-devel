SUMMARY = "The software for the AGL Alexa voiceagent feature"
DESCRIPTION = "The software for the AGL Alexa voiceagent feature"

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
	packagegroup-agl-voiceagent-alexa \
"

RDEPENDS_${PN} += " \
	alexa-voiceagent-service \
	${@bb.utils.contains("DISTRO_FEATURES", "agl-demo-preload", "virtual/alexa-voiceagent-config", "",d)} \
"
