SECTION = "kernel"
DESCRIPTION = "Linux kernel for TI devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc
#require recipes-kernel/linux/cmem.inc
require recipes-kernel/linux/ti-uio.inc

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.4:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " amx3-cm3"
RDEPENDS_kernel-base_append_ti43x = " amx3-cm3"

# Add a run-time dependency for the VPE VPDMA firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_dra7xx = " vpdma-fw"

# Install boot-monitor skern file into /boot dir of rootfs
RDEPENDS_kernel-base_append_keystone = " boot-monitor"

# Install ti-sci-fw into /boot dir of rootfs
RDEPENDS_kernel-base_append_k2g-evm = " ti-sci-fw"

# Add run-time dependency for SerDes firmware to the rootfs
RDEPENDS_kernel-base_append_keystone = " serdes-fw"

# Add run-time dependency for NETCP PA firmware to the rootfs
RDEPENDS_kernel-base_append_k2hk-evm = " netcp-pa-fw"
RDEPENDS_kernel-base_append_k2e-evm = " netcp-pa-fw"
RDEPENDS_kernel-base_append_k2l-evm = " netcp-pa-fw"

# Add run-time dependency for PRU Ethernet firmware to the rootfs
RDEPENDS_kernel-base_append_am57xx-evm = " prueth-fw"
RDEPENDS_kernel-base_append_am437x-evm = " prueth-fw"
RDEPENDS_kernel-base_append_am335x-evm = " prueth-fw"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "am335x-nutsboard-almond.dtb"
COMPATIBLE_MACHINE = "ti33x|ti43x|omap-a15|omap3|omap4|keystone"

S = "${WORKDIR}/git"

BRANCH = "nutsboard_ti_4.4.32_1.0.0_ga"

SRCREV = "87d7abcd67723c40058a7e422afdc21f235e224f"
PV = "4.4.32"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

KERNEL_GIT_URI = "git://github.com/nutsboard/linux-am335x.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig"
