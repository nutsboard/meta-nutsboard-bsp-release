SUMMARY = "u-boot uEnv.txt"
DESCRIPTION = "u-boot uEnv.txt"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://README;md5=c69c1ff4cab1e3fa6865d2a456bdae50"

SRC_URI += " \
file://uEnv.txt \
file://README \
"
S = "${WORKDIR}"

inherit deploy

do_deploy() {
  install -d ${DEPLOYDIR}
  install ${S}/uEnv.txt ${DEPLOYDIR}/uEnv.txt
}

addtask deploy after do_install before do_build
