require x-load.inc

#FILESPATHPKG_prepend = "x-load-git:x-load-git/${MACHINE}"

PV = "1.44+${PR}+gitr${SRCREV}"
PR ="r17"
PE = "1"

SRCREV_pn-${PN} = "6f3a26101303051e0f91b6213735b68ce804e94e"
SRC_URI = "git://gitorious.org/x-loader/x-loader.git;branch=master;protocol=git \
           file://0001-OMAP4-clocks-Enable-only-required-clks.patch \
           file://0002-OMAP4-Select-DPLL-PER-Clock-as-source-for-SGX-FCLK.patch \
           file://0003-MUX-Configure-SYS_NIRQ2-pin-in-safe-mode.patch \
           file://0004-OMAP4-clocks-Disable-slimbus-and-pad_clks.patch \
           file://0005-omap4-Make-1GHz-as-default-MPU-clock.patch \
          "

S = "${WORKDIR}/git"

XLOAD_MACHINE_beagleboard = "omap3530beagle_config"

PACKAGE_ARCH = "${MACHINE_ARCH}"