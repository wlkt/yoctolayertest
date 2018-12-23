DESCRIPTION = "my init scripts"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://startup-script \
           file://run-script     \
           file://support-script \
          "

S = "${WORKDIR}"

do_install() {

        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/rcS.d
        install -d ${D}${sysconfdir}/rc1.d
        install -d ${D}${sysconfdir}/rc2.d
        install -d ${D}${sysconfdir}/rc3.d
        install -d ${D}${sysconfdir}/rc4.d
        install -d ${D}${sysconfdir}/rc5.d
        install -d ${D}${sbindir}

        install -m 0755 ${WORKDIR}/startup-script  ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/run-script      ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/support-script  ${D}${sbindir}/

        ln -sf ../init.d/startup-script  ${D}${sysconfdir}/rcS.d/S90startup-script
        ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc1.d/K90run-script
        ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc2.d/K90run-script
        ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc3.d/K90run-script
        ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc4.d/K90run-script
        ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc5.d/S90run-script
}
