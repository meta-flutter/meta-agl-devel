# A bbappend has been added to meta-agl to enable nghttp2, mask out the one
# from meta-aac to avoid triggering rebuilds of all curl dependencies when
# agl-voiceagent-alexa is configured.
BBMASK += "meta-aac/recipes-support/curl/curl_%.bbappend"
# Mask out the nghttp2 recipe in meta-aac as well, as a newer version
# is available in meta-networking, and due to meta-aac having a higher
# layer priority, rebuilds will be triggered when the voiceagent feature
# is configured and the layer is added.
BBMASK += "meta-aac/recipes-connectivity/nghttp2"
# Mask out the duplicate libopus recipe in meta-aac for the same reason
BBMASK += "meta-aac/recipes-multimedia/libopus"

PREFERRED_RPROVIDER_virtual/voice-high-config = "alexa-voice-high-config"

FEATURE_PACKAGES:agl-voiceagent-alexa = "packagegroup-agl-voiceagent-alexa"

AGL_FEATURES += "agl-voiceagent-alexa"
