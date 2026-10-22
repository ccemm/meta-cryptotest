inherit bundle

RAUC_BUNDLE_COMPATIBLE = "cryptotest-bbb"
RAUC_BUNDLE_VERSION = "1.0.0"
RAUC_BUNDLE_DESCRIPTION = "Cryptotest BBB rootfs update"
RAUC_BUNDLE_FORMAT = "verity"

RAUC_BUNDLE_SLOTS = "rootfs"
RAUC_SLOT_rootfs = "core-image-minimal"
RAUC_SLOT_rootfs[fstype] = "ext4"

RAUC_KEY_FILE  = "${THISDIR}/files/dev.key.pem"
RAUC_CERT_FILE = "${THISDIR}/files/dev.cert.pem"
