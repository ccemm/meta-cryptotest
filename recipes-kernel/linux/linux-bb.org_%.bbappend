# Rename this file to <kernel PN>_%.bbappend
# (find PN with: bitbake -e virtual/kernel | grep ^PN=)

do_configure:append() {
    for opt in SPI SPI_OMAP24XX DRM DRM_FBDEV_EMULATION TINYDRM_ILI9341; do
        ${S}/scripts/config --file ${B}/.config --enable $opt
    done
    oe_runmake -C ${S} O=${B} olddefconfig
}
