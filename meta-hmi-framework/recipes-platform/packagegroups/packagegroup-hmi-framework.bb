SUMMARY = "The software for the AGL hmi framework 2017"
DESCRIPTION = "A set of packages belong to the hmi framework 2017"

LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
  packagegroup-hmi-framework \
  packagegroup-hmi-framework-dev \
"

RDEPENDS_${PN} += " \
  agl-service-windowmanager-2017 \
  agl-service-soundmanager-2017 \
  agl-service-homescreen-2017 \
  homescreen-2017 \
"

#
# THESE SHOULD NOT BE NEEDED and have to be converted to being shipped as platform libraries instead !
#
RDEPENDS_${PN}-dev += " \
   agl-service-windowmanager-2017-dev \
   agl-service-soundmanager-2017-dev \
   agl-service-homescreen-2017-dev \
"
