SUMMARY = "Lightweight http(s) proxy daemon"
HOMEPAGE = "https://tinyproxy.github.io/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://github.com/Igalia/${PN}.git;branch=wam-proxy;protocol=https"
S = "${WORKDIR}/git"
SRCREV = "ab1b5c5a53960afd91d50b1f11e339f653602de8"

EXTRA_OECONF += " \
	--enable-filter \
	--enable-transparent \
	--enable-reverse \
	--enable-upstream \
	--enable-xtinyproxy \
	"

inherit autotools

FILES_${PN} += "${datadir}/tinyproxy/*"
