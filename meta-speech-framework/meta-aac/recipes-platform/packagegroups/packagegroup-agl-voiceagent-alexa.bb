SUMMARY = "The software for the AGL Alexa voiceagent feature"
DESCRIPTION = "The software for the AGL Alexa voiceagent feature"

LICENSE = "MIT"

inherit packagegroup

ALLOW_EMPTY_${PN} = "1"

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-agl-voiceagent-alexa \
    packagegroup-agl-voiceagent-alexa-test \
    packagegroup-agl-voiceagent-alexa-devel \
    "

RDEPENDS_${PN} = " \
    alexa-voiceagent-service \
    "

# Empty for now, no test/dbg/coverage widgets
RDEPENDS_${PN}-test = ""
RDEPENDS_${PN}-devel = ""
