#### JAILHOUSE 
IMAGE_INSTALL:append = " jailhouse jailhouse-demos"
PREFERRED_VERSION_linux-raspberrypi = "5.4%"

RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/jailhouse-memory.dtbo"

#Qemu Boot Config
# qemu flags for jailhouse
QB_OPT_APPEND:append = " -device intel-iommu,intremap=on,x-buggy-eim=on -device intel-hda,addr=1b.0 -device hda-duplex -serial none -serial stdio -serial telnet:localhost:4321,server,nowait -serial telnet:localhost:5432,server,nowait"
QB_MEM = "-m 2048"

# use override with higher priority than x86-64
QB_MACHINE:qemux86-64 = "-machine q35,kernel_irqchip=split -smp 4"
QB_CPU:qemux86-64 = "-enable-kvm"
QB_CPU_KVM:qemux86-64 = "-cpu host,-kvm-pv-eoi,-kvm-pv-ipi,-kvm-asyncpf,-kvm-steal-time,-kvmclock,-invpcid,-hypervisor"

QB_KERNEL_CMDLINE_APPEND:append = " intel_iommu=off memmap=82M$0x22000000"

QB_KERNEL_ROOT = "/dev/vda"
QB_SERIAL_OPT = "-serial none -serial stdio -serial telnet:localhost:4321,server,nowait -serial telnet:localhost:5432,server,nowait -vga virtio"


# jailhouse needs ttyS1 in the agl-qemu.cell as debug console.
# restrict the SERIAL_CONSOLES to ttyS0 only
SERIAL_CONSOLES = "115200;ttyS0"
KERNEL_CONSOLE = "ttyS0"

# For Kernel modules
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS += "kernel-modules"

# For a custom jailhouse kernel from git.kiszka.org
PREFERRED_PROVIDER_virtual/kernel = "linux-jailhouse-custom"

# Add virtio-ivshmem-binaries to the QEmulated system
IMAGE_INSTALL:append = " packagegroup-agl-jailhouse"

# prevent most external kernel module from being built
MOST_DRIVERS = ""
LTTNGUST:forcevariable := ""
LTTNGTOOLS:forcevariable := ""
LTTNGMODULES:forcevariable := ""

# Disable perf build
PERF:forcevariable := ""

