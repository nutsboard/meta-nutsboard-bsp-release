LICENSE = "BSD-3-Clause & TI-TFL"
COMPATIBLE_MACHINE = "keystone"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/ti/drv/sa/COPYING.txt;md5=cd04fb087063a2a82c4ce61983836871"

SA_LLD_GIT_URI = "git://git.ti.com/keystone-rtos/sa-lld.git"
SA_LLD_GIT_PROTOCOL = "git"
SA_LLD_GIT_BRANCH = "master"
SA_LLD_GIT_DESTSUFFIX = "git/ti/drv/sa"

# Below commit ID corresponds to "DEV.SA_LLD.03.00.00.14"
SA_LLD_SRCREV = "e0448f5172f9a4d945f9ad1b2a583574c378b5c7"

BRANCH = "${SA_LLD_GIT_BRANCH}"
SRC_URI = "${SA_LLD_GIT_URI};destsuffix=${SA_LLD_GIT_DESTSUFFIX};protocol=${SA_LLD_GIT_PROTOCOL};branch=${BRANCH}"
SRCREV = "${SA_LLD_SRCREV}"

PV = "03.00.00.14"
INC_PR = "r2"

S = "${WORKDIR}/${SA_LLD_GIT_DESTSUFFIX}"
