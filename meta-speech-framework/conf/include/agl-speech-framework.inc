PREFERRED_RPROVIDER_virtual/voice-high-config = "default-voice-high-config"

FEATURE_PACKAGES_agl-speech-framework = "packagegroup-agl-speech-services"

IMAGE_FEATURES += "agl-speech-framework"

# Add local packagegroups to agl-test-wgt and agl-devel-wgt image feature
# package lists
FEATURE_PACKAGES_agl-test-wgt_append = " packagegroup-agl-speech-services-test"
FEATURE_PACKAGES_agl-devel-wgt_append = " packagegroup-agl-speech-services-devel"
