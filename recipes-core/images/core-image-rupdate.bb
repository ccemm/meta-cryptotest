SUMMARY = "Cem OS A/B image with RAUC updates"

require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL += "crypto-test filesoverlay rauc \
                  kernel-module-squashfs kernel-module-dm-mod kernel-module-dm-verity"
KERNEL_MODULE_AUTOLOAD += "squashfs dm-mod dm-verity"

IMAGE_FSTYPES += "ext4 wic wic.bmap"
WKS_FILE = "cryptotest-ab.wks"
IMAGE_BOOT_FILES = "MLO u-boot.img"

do_image_wic[depends] += "virtual/bootloader:do_deploy"
