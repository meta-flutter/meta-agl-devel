DESCRIPTION = "AGL cluster demo container LXC config"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause;md5=3775480a712fc46a69647678acb234cb"

inherit lxc-config

LXC_AUTO_START ??= "1"
