SUMMARY = "Custom Crypto Test Application"
DESCRIPTION = "A test application built from a Git repository using a Makefile"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Replace with your actual Git repository URL and branch
SRC_URI = "git://github.com/ccemm/CryptoTest.git;protocol=https;branch=main"

# Use AUTOREV for development or lock it to a specific commit hash/tag
SRCREV = "${AUTOREV}"

# Working directory where Git repo is checked out
S = "${WORKDIR}/git"

# Declare the dependency on OpenSSL (provides libssl and libcrypto)
DEPENDS = "openssl"

# Tell BitBake how to install the compiled binary into the rootfs package
do_install() {
    install -d ${D}${bindir}
    install -m 0755 server ${D}${bindir}/
    install -m 0755 client ${D}${bindir}/
}
