# Checking PREFERRED_RPROVIDER_virtual/voiceagent below is less than ideal, but
# seems required until there is a usable default voiceagent.
RDEPENDS_${PN} += " \
	agl-service-voice-high \
	agl-service-voice-high-capabilities \
	${@oe.utils.conditional("PREFERRED_RPROVIDER_virtual/voiceagent", "", "", "virtual/voiceagent", d)} \
"
