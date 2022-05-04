SUMMARY = "Perl scalar list modules"
DESCRIPTION = ""List::Util" contains a selection of subroutines that people have expressed \
would be nice to have in the perl core, but the usage would not really be \
high enough to warrant the use of a keyword, and the size so small such \
that being individual extensions would be wasteful."
HOMEPAGE = "https://metacpan.org/release/Scalar-List-Utils"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0-or-later"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
                    file://${COMMON_LICENSE_DIR}/GPL-1.0-or-later;md5=30c0b8a5048cc2f4be5ff15ef0d8cf61"

SRC_URI = "https://cpan.metacpan.org/authors/id/P/PE/PEVANS/Scalar-List-Utils-${PV}.tar.gz"
SRC_URI[md5sum] = "7988f5111e33ba47e175cf3e86b0d93f"
SRC_URI[sha256sum] = "4d2bdc1c72a7bc4d69d6a5cc85bc7566497c3b183c6175b832784329d58feb4b"

S = "${WORKDIR}/Scalar-List-Utils-${PV}"

inherit cpan ptest-perl

do_install:prepend() {
    # requires "-T" (taint) command line option
    rm -rf ${B}/t/tainted.t
}

BBCLASSEXTEND = "native"
