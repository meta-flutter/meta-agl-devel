DESCRIPTION = "The set of packages for AGL Speech Subsystem"
LICENSE = "MIT"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-speech-services \
    packagegroup-agl-speech-services-test \
    packagegroup-agl-speech-services-devel \
    "

ALLOW_EMPTY_${PN} = "1"

RDEPENDS_${PN} += "\
    agl-service-voice-high \
    agl-service-voice-high-capabilities \
    ${PREFERRED_RPROVIDER_virtual/voice-high-config} \
"

RDEPENDS_${PN}-test = "\
    agl-service-voice-high-test \
    agl-service-voice-high-capabilities-test \
"

# Empty until service autobuild script rework
RDEPENDS_${PN}-devel = ""
