require ${@bb.utils.contains('AGL_FEATURES', 'agl-flutter', 'packagegroup-agl-graphical-weston_aglflutter.inc', '', d)}
