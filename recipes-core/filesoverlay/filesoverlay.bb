SUMMARY = "My files for /etc and /home/root"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://fw_env.config"

S = "${WORKDIR}"

do_install() {
    # ---- /etc ----
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/fw_env.config ${D}${sysconfdir}/fw_env.config
    
    # ---- /boot ----
    install -d ${D}/boot
    install -m 0644 ${DEPLOY_DIR_IMAGE}/am335x-boneblack.dtb ${D}/boot/am335x-boneblack.dtb
}

# /etc is packaged by default; /home/root is not, so add it
FILES:${PN} += "/boot/am335x-boneblack.dtb"

# update_yocto.sh needs these on the board
RDEPENDS:${PN} += "e2fsprogs-mke2fs libubootenv-bin"

