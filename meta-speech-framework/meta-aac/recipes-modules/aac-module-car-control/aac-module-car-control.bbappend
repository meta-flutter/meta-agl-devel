# Fix nlohmann dependency to pick up newer nlohmann-json recipe in meta-oe
DEPENDS:remove = "nlohmann"
DEPENDS:append = " nlohmann-json"
