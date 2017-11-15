# AGL HMI Framework adaptation of navigation
# This recipe is integrated into navigation_git.bb when the meta-hmi-framework is integrated into meta-agl-demo.

SRCREV = "${AUTOREV}"
SRC_URI="git://github.com/AGLExport/gpsnavi.git;branch=newwm \
         file://download_mapdata_jp.sh \
         file://download_mapdata_uk.sh \
"
DEPENDS_append = " af-binder libwindowmanager virtual/libhomescreen "

