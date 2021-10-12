FILESEXTRAPATHS:prepend := "${THISDIR}/qtlocation:"

SRC_URI += "\
    file://0001-mapbox-update-API-url-to-match-new-schema.patch \
    "

PACKAGECONFIG:append:aglcontainerivi = " geoservices_mapbox geoservices_mapboxgl"
