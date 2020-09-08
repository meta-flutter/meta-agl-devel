# Fix nlohmann dependency to pick up newer nlohmann-json recipe in meta-oe
DEPENDS_remove = "nlohmann"
DEPENDS_append = " nlohmann-json"
