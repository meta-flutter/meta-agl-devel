# Jailhouse Manual Configuration

#### For Kernel and jailhouse cell configuration

After setting up QEmu and the AGL with jailhouse, If you need to configure the file for the current setup and according to your needs, then there are some steps which you can follow to acheive the same:

1) If you want to customize the kernel and want to use your modified version, follow these steps below:
    - Take reference from the current present `.bb` and `.inc` files in `meta-agl-jailhouse/recipes-kernel/linux-jailhouse-custom /linux-jailhouse-custom_git.bb`.
    - Modify `SRC_URI` with the link to your desired kernel repository and also add the `defconfig` according to your needs.
    - Do not forget to modify the `SRCREV` upto the commit you want, and change the `PV` and `KVER` according to the version present in the kernel source's `Makefile`.
2) For customizing the cell and inmate configurations for IVSHMEM.
    - For initial configurations you can look at [Jailhouse Guide](https://github.com/siemens/jailhouse/blob/master/Documentation/inter-cell-communication.md).
    - For creating the configuration file and automatically generating the root cell files just run the below command:
        ```sh
           $ jailhouse config create -c ttyS1 qemu-agl.c
        ```
        This will create a root cell configuration file which you can modify by following the Notes below.
    - Notes for above information on Jailhouse Guide:
        - These are the serial redirections:
            
            | Command | Description |
            | --- | --- |
            | `ttyS0-3f8` | runqemu serial |
            | `ttyS1-2f8` | jailhouse debug |
            | `ttyS2-3e8` | available as first cell console and used this for the moment in initial setup |
            | `ttyS3-2e8` | available as 2nd cell console and right now this one is not wired up in the runqemu/qemuboot arguments |
            
        - Change `.phys_start` and `.virt_start` according to `/proc/iomem` and look for the available memory range and calculate and distribute the regions according to `.size`.
        - DO NOT overlap the memory with `.hypervisor_memory`.
        - Right now only support for `virito-block` is added, but if you want to experiment and try the custom virtio, then just enable `#define USE_VIRTIO_DEMO` in the `qemu-agl.c`. Full support for `VIRTIO_NET`, `VIRTIO_CON` will be added soon.
        - Common shared memory is necessary for the communication.
        - Add same PCI configuration to root cell and inmate, you can see example in `qemu-agl.c`.

