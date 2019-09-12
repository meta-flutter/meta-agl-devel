BBLAYERS =+ " \
	${METADIR}/external/alexa-auto-sdk/builder/meta-aac \
"

# Per the SDK documentation, the module recipes need to be manually
# added, as they sit outside of the layer.
BBFILES += "${METADIR}/external/alexa-auto-sdk/modules/*/*.bb"

# Include the recipe for the required gstreamer module as well
BBFILES += "${METADIR}/external/alexa-auto-sdk/extensions/experimental/gstreamer/modules/*/*.bb"
