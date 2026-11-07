SUMMARY = "Qt Widgets test app for the ILI9341 framebuffer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://main.cpp \
           file://CMakeLists.txt \
           file://qt-display-test.sh"

S = "${WORKDIR}"

DEPENDS = "qtbase"

inherit qt6-cmake

do_install:append() {
    install -m 0755 ${WORKDIR}/qt-display-test.sh ${D}${bindir}/qt-display-test.sh
}

RDEPENDS:${PN} += "qtbase-plugins ttf-dejavu-sans"
