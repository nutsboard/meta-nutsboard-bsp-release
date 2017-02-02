SUMMARY = "TI Wilink 8 Wi-fi & bluetooth firmware"
DESCRIPTION = "TI Wilink8 Wi-fi & bluetooth firmware"
SECTION = "base"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = " \
    file://TIInit_11.8.32.bts \
    file://wl127x-nvs.bin \
    file://WL1835MOD_INI_C2PC.ini \
    file://wl18xx-conf.bin \
    file://wl18xx-fw-2.bin \
    file://wl18xx-fw-3.bin \
    file://wl18xx-fw-4.bin \
    file://wl18xx-fw.bin \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/lib/firmware/ti-connectivity

    #Install BCM4330 wifi and bluetooth firmware
    install -m 0755 TIInit_11.8.32.bts ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl127x-nvs.bin ${D}/lib/firmware/ti-connectivity
    install -m 0755 WL1835MOD_INI_C2PC.ini ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl18xx-conf.bin ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl18xx-fw-2.bin ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl18xx-fw-3.bin ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl18xx-fw-4.bin ${D}/lib/firmware/ti-connectivity
    install -m 0755 wl18xx-fw.bin ${D}/lib/firmware/ti-connectivity
}

FILES_${PN}-dbg += "/lib/firmware/.debug"
FILES_${PN} += "/lib/firmware/"

COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap3|omap4|keystone"
