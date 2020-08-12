#### JAILHOUSE 
IMAGE_INSTALL_append = " jailhouse jailhouse-demos"
PREFERRED_VERSION_linux-raspberrypi = "5.4%"

RPI_KERNEL_DEVICETREE_OVERLAYS_append = " overlays/jailhouse-memory.dtbo"
