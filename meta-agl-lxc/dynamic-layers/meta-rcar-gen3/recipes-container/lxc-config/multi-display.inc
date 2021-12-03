HAS_MULTI_DISPLAY ?= ""
HAS_MULTI_DISPLAY += "${@bb.utils.contains("AGL_FEATURES", "kingfisher", "1", "" ,d)}"
HAS_MULTI_DISPLAY += "${@bb.utils.contains("AGL_FEATURES", "agl-refhw-h3", "1", "" ,d)}"
