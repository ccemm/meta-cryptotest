SUMMARY = "Cem OS A/B image with RAUC updates"

require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "crypto-test filesoverlay rauc \
                  kernel-module-squashfs kernel-module-dm-mod kernel-module-dm-verity \
                  e2fsprogs-resize2fs libubootenv-bin"
KERNEL_MODULE_AUTOLOAD += "squashfs dm-mod dm-verity"

IMAGE_FSTYPES += "ext4 wic wic.bmap"
WKS_FILE = "cryptotest-ab.wks"
IMAGE_BOOT_FILES = "MLO u-boot.img"

TOOLCHAIN_TARGET_TASK:append = " kernel-devsrc"
TOOLCHAIN_TARGET_TASK:append = " openssl-dev"

do_image_wic[depends] += "virtual/bootloader:do_deploy"
