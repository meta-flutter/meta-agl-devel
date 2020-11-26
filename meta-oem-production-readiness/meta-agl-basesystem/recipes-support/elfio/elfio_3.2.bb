SUMMARY = "C++ library for reading and generating ELF files"
DESCRIPTION = "ELFIO is a header-only C++ library intended for reading and generating files in the \
               ELF binary format. It is used as a standalone library - it is not dependent on any \
               other product or project. Adhering to ISO C++, it compiles on a wide variety of \
               architectures and compilers."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=4f932e9ddd12264ae5e569aae5f08ed3"

SRC_URI = "${SOURCEFORGE_MIRROR}/elfio/ELFIO-sources/ELFIO-${PV}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "e1ddfc8d316fa6d03a04d8d1d6827663"

inherit autotools
