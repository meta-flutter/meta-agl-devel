SUMMARY = "Alexa voice agent binding"
DESCRIPTION = "alexa-voiceagent-service is an Alexa Auto SDK based voiceagent binding"
HOMEPAGE = "https://gerrit.automotivelinux.org/gerrit/apps/agl-service-voice-high"
SECTION = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://License.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = " \
	libafb-helpers \
	libappcontroller \
	avs-device-sdk \
	aac-module-core \
	aac-module-alexa \
	aac-module-address-book \
	aac-module-car-control \
	aac-module-cbl \
	aac-module-contact-uploader \
	aac-module-navigation \
	aac-module-phone-control \
	aac-module-system-audio \
	${@bb.utils.contains("ALEXA_WAKEWORD", "true", "aac-module-amazonlite pryon-lite", "", d)} \
"

SRC_URI = "git://github.com/alexa/alexa-auto-sdk.git;protocol=https;branch=2.3 \
           file://alexa.json \
           file://0001-remove-library-dependency-copying.patch \
           file://0007-add-autobuild-scripts.patch \
"
SRCREV = "d46f22b453f528868b483e39bc7a057ca68a5199"

PV = "2.3+git${SRCPV}"
S = "${WORKDIR}/git/platforms/agl/alexa-voiceagent-service"

inherit cmake aglwgt

EXTRA_OECMAKE += "-DAAC_HOME=${RECIPE_SYSROOT}/${AAC_PREFIX}"

ALEXA_WAKEWORD ??= "false"

do_install:append() {
    install -D -m 0644 ${WORKDIR}/alexa.json ${D}${sysconfdir}/xdg/AGL/voiceagents/alexa.json
}

PACKAGES =+ "${PN}-conf"

FILES:${PN}-conf = "${sysconfdir}/xdg/AGL/voiceagents/*"

# NOTE: curl and opus are from the base SDK libraries, sqlite3 from the
#       core module
RDEPENDS:${PN} += " \
	libcurl \
	libopus \
	libsqlite3 \
	${PN}-conf \
	${@bb.utils.contains("ALEXA_WAKEWORD", "true", "pryon-lite", "", d)} \
	gstreamer1.0-plugins-bad-hls \
"
