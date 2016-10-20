SUMMARY = "mongoose"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.md;beginline=302;endline=321;md5=dbdda6492d8f693c50356f55d30cbb5e \
                    "

PV = "4.6.1+git${SRCPV}"
SRCREV = "4913935d321efbf2b6dccc4b4ba1679a73d5bd08"
SRC_URI = "git://github.com/Automattic/mongoose.git;protocol=git;branch=master \
           "
RDEPENDS_${PN} += "mongodb \
		   nodejs \
		   "

S = "${WORKDIR}/git"

FILES_${PN} = " \
                ${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/* \
                "

do_configure() {
}

do_compile() {
}

install_file_directory() {
    for obj in $1/*; do 
        fname=`basename $obj`
        if ! [ -e $2 ]; then
            install -d 0644 $2
        fi
        if [ -f $1/$fname ]; then
            install -m 0644 $1/$fname $2
        elif [ -d $1/$fname ]; then
            if ! [ -e $2/$fname ]; then
                install -d 0644 $2/$fname
            fi
            install_file_directory $1/$fname $2/$fname
        fi
    done
}

do_install() {
    install -d ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/

    install -m 0644 ${S}/CONTRIBUTING.md ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/History.md ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/index.js ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/README.md ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/package.json ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/release-items.md ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/static.js ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/
    install -m 0644 ${S}/website.js ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/

    install_file_directory ${S}/examples ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/examples/
    install_file_directory ${S}/lib ${D}${exec_prefix}/lib/node_modules/npm/node_modules/mongoose/lib/

#    sed -i '/devDependencies/a\ \ \ \ \"mongoose\"\:\ \"\~4\.6\.2\"\,' ${D}${exec_prefix}/lib/node_modules/npm/package.json
}

