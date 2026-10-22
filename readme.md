#Add These Lines To local.conf file For Rauc Support

DISTRO_FEATURES:append = " rauc"
PACKAGECONFIG:remove:pn-rauc = "service"
IMAGE_INSTALL:append = " crypto-test filesoverlay rauc e2fsprogs-mke2fs libubootenv-bin"

IMAGE_INSTALL:append = " kernel-module-squashfs kernel-module-dm-mod kernel-module-dm-verity"
KERNEL_MODULE_AUTOLOAD += "squashfs dm-mod dm-verity"
