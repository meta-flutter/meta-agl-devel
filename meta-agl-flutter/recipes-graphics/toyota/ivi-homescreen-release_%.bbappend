require ${@bb.utils.contains('AGL_FEATURES', 'agl-flutter', 'ivi-homescreen_aglflutter.inc', '', d)}
# not used atm
#require ${@bb.utils.contains('AGL_FEATURES', 'agl-flutter', '${BPN}_aglflutter.inc', '', d)}
