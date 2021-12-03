require multi-display.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

LXC_AUTO_START ?= "${@bb.utils.contains("HAS_MULTI_DISPLAY", "1", "1", "0" ,d)}"
