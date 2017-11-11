SUMMARY     = "4A - High Level Audio API Service"
DESCRIPTION = "High Level Audio API service used in 4A (AGL Advanced Audio Agent)"
HOMEPAGE    = "https://git.automotivelinux.org/apps/agl-service-audio-4a/"
SECTION     = "apps"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "gitsm://gerrit.automotivelinux.org/gerrit/apps/agl-service-audio-4a;protocol=https;branch=${AGL_BRANCH}"
SRCREV = "${AUTOREV}"

PV = "0.1"
S  = "${WORKDIR}/git"

inherit cmake aglwgt pkgconfig

DEPENDS += "alsa-lib json-c systemd af-binder glib-2.0"

do_aglwgt_deploy_append() {
	cat <<'EOF' >${D}/${sysconfdir}/agl-postinsts/99_4A_service_patch.sh
svcfile=/usr/local/lib/systemd/user/afm-service-agl-service-audio-4a@1.0.service
set -x
echo "-- TMP 4A INSTALL FIX from meta-agl/meta-app-framework/recipes-multimedia/agl-service-audio-4a/agl-service-audio-4a_git.bb - MUST BE REMOVED !!!"
while [ ! -f $svcfile ]; do
	echo .
	sleep 0.2
done
sed -i -e 's|--verbose |--verbose --ldpath=/usr/libexec/agl/afb-aaaa/lib/:/usr/libexec/agl/4a-alsa-core/lib/ |' $svcfile
echo "-- TMP 4A INSTALL FIX END"

EOF
	chmod a+x ${D}/${sysconfdir}/agl-postinsts/99_4A_service_patch.sh
}
