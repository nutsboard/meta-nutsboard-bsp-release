require u-boot-ti.inc

# u-boot needs devtree compiler to parse dts files
DEPENDS += "dtc-native"

DESCRIPTION = "u-boot bootloader for NutsBoard Almond"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

PR = "r25"
PV_append = "+git${SRCPV}"

SRC_URI = "git://github.com/nutsboard/u-boot-am335x.git;protocol=git;branch=${BRANCH}"

BRANCH ?= "nutsboard-v2016.05"

SRCREV = "b56d5872bdb3aa13fea38e7b55723ac03ebc9155"

# Support for secure devices - detailed info is in doc/README.ti-secure
TI_SECURE_DEV_PKG ?= ""
export TI_SECURE_DEV_PKG

SPL_BINARY = "MLO"
SPL_UART_BINARY = "u-boot-spl.bin"

# Keystone specifics
UBOOT_SUFFIX_keystone = "bin"
SPL_UART_BINARY_keystone = ""

# SPI NOR Flash binaries
UBOOT_SPI_SPL_BINARY = "u-boot-spl.bin"
UBOOT_SPI_BINARY = "u-boot.img"
UBOOT_SPI_GPH_BINARY = "u-boot-spi.gph"

# SPI NOR Flash deployed images
UBOOT_SPI_SPL_IMAGE = "u-boot-spl-${MACHINE}-${PV}-${PR}.bin"
UBOOT_SPI_SPL_SYMLINK = "u-boot-spl-${MACHINE}.bin"
UBOOT_SPI_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SPI_SYMLINK = "u-boot-${MACHINE}.img"
UBOOT_SPI_GPH_IMAGE = "u-boot-spi-${MACHINE}-${PV}-${PR}.gph"
UBOOT_SPI_GPH_SYMLINK = "u-boot-spi-${MACHINE}.gph"

do_compile_append_am437x-hs-evm () {
	if [ -f ${S}/u-boot-spl_HS_ISSW ]; then
		rm -rf ${S}/MLO
		cp ${S}/u-boot-spl_HS_ISSW ${S}/MLO
	fi
}

do_install_append_keystone () {
	install ${S}/spl/${UBOOT_SPI_SPL_BINARY} ${D}/boot/${UBOOT_SPI_SPL_IMAGE}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${D}/boot/${UBOOT_SPI_SPL_BINARY}

	install ${S}/${UBOOT_SPI_BINARY} ${D}/boot/${UBOOT_SPI_IMAGE}
	ln -sf ${UBOOT_SPI_IMAGE} ${D}/boot/${UBOOT_SPI_BINARY}

	install ${S}/${UBOOT_SPI_GPH_BINARY} ${D}/boot/${UBOOT_SPI_GPH_IMAGE}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${D}/boot/${UBOOT_SPI_GPH_BINARY}
}

do_deploy_append_keystone () {
	install ${S}/spl/${UBOOT_SPI_SPL_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_SPL_IMAGE}
	rm -f ${UBOOT_SPI_SPL_BINARY} ${UBOOT_SPI_SPL_SYMLINK}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${UBOOT_SPI_SPL_SYMLINK}
	ln -sf ${UBOOT_SPI_SPL_IMAGE} ${UBOOT_SPI_SPL_BINARY}

	install ${S}/${UBOOT_SPI_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_IMAGE}
	rm -f ${UBOOT_SPI_BINARY} ${UBOOT_SPI_SYMLINK}
	ln -sf ${UBOOT_SPI_IMAGE} ${UBOOT_SPI_SYMLINK}
	ln -sf ${UBOOT_SPI_IMAGE} ${UBOOT_SPI_BINARY}

	install ${S}/${UBOOT_SPI_GPH_BINARY} ${DEPLOYDIR}/${UBOOT_SPI_GPH_IMAGE}
	rm -f ${UBOOT_SPI_GPH_BINARY} ${UBOOT_SPI_GPH_SYMLINK}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${UBOOT_SPI_GPH_SYMLINK}
	ln -sf ${UBOOT_SPI_GPH_IMAGE} ${UBOOT_SPI_GPH_BINARY}
}
