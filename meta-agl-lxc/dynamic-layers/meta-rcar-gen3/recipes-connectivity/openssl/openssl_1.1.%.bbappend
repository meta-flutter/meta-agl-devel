# Add a hook to disable depending on cryptodev-module for containers
CRYPTODEV_RDEPENDS = "cryptodev-module"
CRYPTODEV_RDEPENDS:aglcontainerguest = ""
PACKAGECONFIG[cryptodev-linux] = "enable-devcryptoeng,disable-devcryptoeng,cryptodev-linux,,${CRYPTODEV_RDEPENDS}"
