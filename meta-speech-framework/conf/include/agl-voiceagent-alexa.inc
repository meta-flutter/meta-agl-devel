# A bbappend has been added to meta-agl to enable nghttp2, mask out the one
# from meta-aac to avoid triggering rebuilds of all curl dependencies when
# agl-voiceagent-alexa is configured.
BBMASK += "meta-aac/recipes-support/curl/curl_%.bbappend"

PREFERRED_RPROVIDER_virtual/voiceagent = "alexa-voiceagent-service"