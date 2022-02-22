SUMMARY = "Perl modules for parsing and evaluating XPath statements"
HOMEPAGE = "https://metacpan.org/release/XML-XPath"
SECTION = "libs"
LICENSE = "Artistic-2.0 & (Artistic-1.0 | GPL-1.0-or-later)"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b5714f72ee964281c4a38b1f0db4213e \
                    file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
                    file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SRC_URI = "https://cpan.metacpan.org/authors/id/M/MA/MANWAR/XML-XPath-${PV}.tar.gz \
           file://adjust-load-test-for-ptest.patch"
SRC_URI[sha256sum] = "1cc9110705165dc09dd09974dd7c0b6709c9351d6b6b1cef5a711055f891dd0f"

S = "${WORKDIR}/XML-XPath-${PV}"

inherit cpan ptest-perl

do_install:append:class-native() {
    # Fix xpath script shebang to work inside native environment
    sed -i 's|#!.*/perl|#!/usr/bin/env perl|' ${D}${bindir}/xpath
}

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/examples
    install -m 0644 ${S}/examples/test.xml ${D}${PTEST_PATH}/examples/
}

RDEPENDS:${PN} += " \
    perl-module-carp \
    perl-module-data-dumper \
    perl-module-file-spec \
    perl-module-io-file \
    perl-module-open \
    perl-module-overload \
    perl-module-perlio \
    perl-module-perlio-encoding \
    perl-module-utf8 \
    libxml-parser-perl \
    libscalar-list-utils-perl \
"

RDEPENDS:${PN}-ptest += " \
    libpath-tiny-perl \
"

BBCLASSEXTEND = "native"
