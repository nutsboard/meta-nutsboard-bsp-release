DESCRIPTION = "Utility to configure and test WG7833 Bluetooth function"
SECTION = "base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://uim.c \
           file://uim.h \
"

S = "${WORKDIR}"

do_compile() {
	${CC} uim.c -o uim
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 uim ${D}${bindir}
}

