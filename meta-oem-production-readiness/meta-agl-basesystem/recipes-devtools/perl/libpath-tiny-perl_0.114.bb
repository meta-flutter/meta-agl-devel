SUMMARY = "Path::Tiny - File path utility"
DESCRIPTION = "This module provides a small, fast utility for working with \
file paths. It is friendlier to use than File::Spec and provides easy access \
to functions from several other core file handling modules"
HOMEPAGE = "https://github.com/dagolden/Path-Tiny"
SECTION = "libs"
LICENSE = "Apache-2.0"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "https://cpan.metacpan.org/authors/id/D/DA/DAGOLDEN/Path-Tiny-${PV}.tar.gz"
SRC_URI[sha256sum] = "cd0f88f37a58fc3667ec065767fe01e73ee6efa18a112bfd3508cf6579ca00e1"

S = "${WORKDIR}/Path-Tiny-${PV}"

inherit cpan ptest-perl

RDEPENDS:${PN} += " \
    perl-module-file-spec \
    perl-module-file-temp \
    perl-module-test-more \
"

BBCLASSEXTEND = "native"
