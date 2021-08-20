SUMMARY = "Alexa service binding default configuration to connect to Alexa"
DESCRIPTION = "Alexa alexa-voiceagent-service binding configuration files"
HOMEPAGE = "https://github.com/alexa/alexa-auto-sdk/tree/master/platforms/agl/alexa-voiceagent-service"
SECTION = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "file://AlexaAutoCoreEngineConfig.json.in"

inherit allarch

ALEXA_WAKEWORD ??= "false"
ALEXA_LOCALE ??= "en-US"
ALEXA_TIMEZONE ??= "America/Vancouver"

do_compile[noexec] = "1"

do_install () {
    if [ -z "${ALEXA_CLIENTID}" ]; then
	bbfatal "ALEXA_CLIENTID not defined in your environment e.g. conf/local.conf"
    fi
    if [ -z "${ALEXA_SERIALNUMBER}" ]; then
	bbfatal "ALEXA_SERIALNUMBER not defined in your environment e.g. conf/local.conf"
    fi
    if [ -z "${ALEXA_PRODUCTID}" ]; then
	bbfatal "ALEXA_PRODUCTID not defined in your environment e.g. conf/local.conf"
    fi
    if [ -z "${ALEXA_MFG_NAME}" ]; then
	bbfatal "ALEXA_MFG_NAME not defined in your environment e.g. conf/local.conf"
    fi
    if [ -z "${ALEXA_DESCRIPTION}" ]; then
	bbfatal "ALEXA_DESCRIPTION not defined in your environment e.g. conf/local.conf"
    fi

    #replace
    sed -e "s|@@ALEXA_CLIENTID@@|${ALEXA_CLIENTID}|" \
        -e "s|@@ALEXA_SERIALNUMBER@@|${ALEXA_SERIALNUMBER}|" \
        -e "s|@@ALEXA_PRODUCTID@@|${ALEXA_PRODUCTID}|" \
        -e "s|@@ALEXA_MFG_NAME@@|${ALEXA_MFG_NAME}|" \
        -e "s|@@ALEXA_DESCRIPTION@@|${ALEXA_DESCRIPTION}|" \
        -e "s|@@ALEXA_WAKEWORD@@|${ALEXA_WAKEWORD}|" \
        -e "s|@@ALEXA_LOCALE@@|${ALEXA_LOCALE}|" \
        -e "s|@@ALEXA_TIMEZONE@@|${ALEXA_TIMEZONE}|" \
        ${WORKDIR}/AlexaAutoCoreEngineConfig.json.in > ${WORKDIR}/AlexaAutoCoreEngineConfig.json

    # install
    install -D -m 644 ${WORKDIR}/AlexaAutoCoreEngineConfig.json ${D}${sysconfdir}/xdg/AGL/AlexaAutoCoreEngineConfig.json
}

RPROVIDES:${PN} += "virtual/alexa-voiceagent-config"
