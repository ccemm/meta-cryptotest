SUMMARY = "BeagleBone Black device tree with ILI9341 SPI display on SPI0"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit devicetree

COMPATIBLE_MACHINE = "beaglebone"

SRC_URI = "file://am335x-boneblack-ili9341.dts"

# am335x-bone-common.dtsi includes "../../tps65217.dtsi" relative to ti/omap,
# so that folder must be on the include path too.
KERNEL_INCLUDE:append = " ${STAGING_KERNEL_DIR}/arch/${ARCH}/boot/dts/ti/omap"

# Built against the headers and .dtsi files of the kernel this image uses.
# Installed as /boot/devicetree/am335x-boneblack-ili9341.dtb
