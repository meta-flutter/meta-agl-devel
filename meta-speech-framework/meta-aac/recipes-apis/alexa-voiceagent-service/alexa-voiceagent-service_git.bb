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
	aac-module-cbl \
	aac-module-contact-uploader \
	aac-module-navigation \
	aac-module-phone-control \
	aac-module-gstreamer \
"

SRC_URI = "git://github.com/alexa/alexa-auto-sdk.git;protocol=https;branch=2.0 \
           file://0001-remove-library-dependency-copying.patch \
           file://0002-update-config.xml.in.patch \
           file://0003-update-audio-device-configuration.patch \
           file://0004-update-config-and-database-paths.patch \
"
SRCREV = "86916d2d8c1702a8be3c88a9012ca56583bcc0c8"

PV = "2.0+git${SRCPV}"
S = "${WORKDIR}/git/platforms/agl/alexa-voiceagent-service"

inherit cmake aglwgt

EXTRA_OECMAKE += "-DAAC_HOME=${RECIPE_SYSROOT}/${AAC_PREFIX}"

# NOTE: curl and opus are from the base SDK libraries, sqlite3 from the
#       core module
RDEPENDS_${PN} += "libcurl libopus libsqlite3"

RPROVIDES_${PN} += "virtual/voiceagent"
