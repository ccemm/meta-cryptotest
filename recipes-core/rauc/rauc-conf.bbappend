FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://system.conf file://ca.cert.pem"
RAUC_KEYRING_FILE = "ca.cert.pem"
