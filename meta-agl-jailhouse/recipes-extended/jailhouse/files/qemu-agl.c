/*
 * Jailhouse, a Linux-based partitioning hypervisor
 *
 * Copyright (c) Siemens AG, 2014-2017
 *
 * This work is licensed under the terms of the GNU GPL, version 2.  See
 * the COPYING file in the top-level directory.
 *
 * Alternatively, you can use or redistribute this file under the following
 * BSD license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Configuration for QEMU Standard PC (Q35 + ICH9, 2009)
 * created with '/usr/libexec/jailhouse/jailhouse config create -c ttyS1 qemu-agl.c'
 *
 * NOTE: This config expects the following to be appended to your kernel cmdline
 *       "memmap=0x5200000$0x22000000"
 */

/* For extending virtio-blk over IVSHMEM. */
#define USE_VIRTIO_BLK

/*
 * Placeholder for extending virtio-device
 *
 * #define USE_VIRTIO_NET
 * #define USE_VIRTIO_CON
 * #define USE_VIRTIO_DEMO
 *
 */

#ifdef USE_VIRTIO_BLK
# define BLK_MEM 4
# define BLK_PCI 1
#else
# define BLK_MEM 0
# define BLK_PCI 0
#endif

#ifdef USE_IVSHMEM_DEMO
# define DEMO_MEM 5
# define DEMO_PCI 1
#else
# define DEMO_MEM 0
# define DEMO_PCI 0
#endif

#ifdef USE_IVSHMEM_NET
# define NET_MEM 4
# define NET_PCI 1
#else
# define NET_MEM 0
# define NET_PCI 0
#endif

#ifdef USE_VIRTIO_CON
# define CON_MEM 4
# define CON_PCI 1
#else
# define CON_MEM 0
# define CON_PCI 0
#endif


#define COMM_MEM_REGIONS (BLK_MEM + DEMO_MEM + NET_MEM + CON_MEM)
#define COMM_PCI_REGIONS (BLK_PCI + DEMO_PCI + NET_PCI + CON_PCI)


#include <jailhouse/types.h>
#include <jailhouse/cell-config.h>

struct {
	struct jailhouse_system header;
	__u64 cpus[1];
	struct jailhouse_memory mem_regions[17 + COMM_MEM_REGIONS];
	struct jailhouse_irqchip irqchips[1];
	struct jailhouse_pio pio_regions[15];
	struct jailhouse_pci_device pci_devices[13 + COMM_PCI_REGIONS];
	struct jailhouse_pci_capability pci_caps[14];
} __attribute__((packed)) config = {
	.header = {
		.signature = JAILHOUSE_SYSTEM_SIGNATURE,
		.revision = JAILHOUSE_CONFIG_REVISION,
		.flags = JAILHOUSE_SYS_VIRTUAL_DEBUG_CONSOLE,
		.hypervisor_memory = {
			.phys_start = 0x22000000,
			.size = 0x600000,
		},
		.debug_console = {
			.address = 0x2f8,
			.type = JAILHOUSE_CON_TYPE_8250,
			.flags = JAILHOUSE_CON_ACCESS_PIO |
				 JAILHOUSE_CON_REGDIST_1,
		},
		.platform_info = {
			.pci_mmconfig_base = 0xb0000000,
			.pci_mmconfig_end_bus = 0xff,
			.iommu_units = {
				{
					.type = JAILHOUSE_IOMMU_INTEL,
					.base = 0xfed90000,
					.size = 0x1000,
				},
			},
			.x86 = {
				.pm_timer_address = 0x608,
				.vtd_interrupt_limit = 256,
			},
		},
		.root_cell = {
			.name = "AGL-Jailhouse-RootCell",
			.cpu_set_size = sizeof(config.cpus),
			.num_memory_regions = ARRAY_SIZE(config.mem_regions),
			.num_irqchips = ARRAY_SIZE(config.irqchips),
			.num_pio_regions = ARRAY_SIZE(config.pio_regions),
			.num_pci_devices = ARRAY_SIZE(config.pci_devices),
			.num_pci_caps = ARRAY_SIZE(config.pci_caps),
		},
	},

	.cpus = {
		0x000000000000000f,
	},

	.mem_regions = {

#if defined USE_VIRTIO_BLK
                /* IVSHMEM shared memory region (virtio-blk back-end) */
                {
                        .phys_start = 0x26e00000,
                        .virt_start = 0x26e00000,
                        .size = 0x1000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_ROOTSHARED,
                },
                {
                        .phys_start = 0x26e01000,
                        .virt_start = 0x26e01000,
                        .size = 0xdf000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
                },
                { 0 },
                { 0 },
#endif
#if defined(USE_VIRTIO_CON)
		/* IVSHMEM shared memory region (virtio-con back-end) */
		{
			.phys_start = 0x220e0000,
			.virt_start = 0x220e0000,
			.size = 0x1000,
			.flags = JAILHOUSE_MEM_READ,
		},
		{
			.phys_start = 0x220e1000,
			.virt_start = 0x220e1000,
			.size = 0xf000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		{ 0 },
		{ 0 },
#endif
#if defined USE_IVSHMEM_DMEO
                /* IVSHMEM shared memory regions (demo) */
                {
                        .phys_start = 0x220f0000,
                        .virt_start = 0x220f0000,
                        .size = 0x1000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_ROOTSHARED,
                },
                {
                        .phys_start = 0x220f1000,
                        .virt_start = 0x220f1000,
                        .size = 0x9000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE |
                                JAILHOUSE_MEM_ROOTSHARED,
                },
                {
                        .phys_start = 0x220fa000,
                        .virt_start = 0x220fa000,
                        .size = 0x2000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_ROOTSHARED,
                },
                {
                        .phys_start = 0x220fc000,
                        .virt_start = 0x220fc000,
                        .size = 0x2000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_ROOTSHARED,
                },
                {
                        .phys_start = 0x220fe000,
                        .virt_start = 0x220fe000,
                        .size = 0x2000,
                        .flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE |
                                JAILHOUSE_MEM_ROOTSHARED,
                },
#endif
#if defined(USE_IVSHMEM_NET)
		/* IVSHMEM shared memory regions (networking) */
		JAILHOUSE_SHMEM_NET_REGIONS(0x22100000, 0),
#endif

		/* MemRegion: 00000000-0009fbff : System RAM */
		{
			.phys_start = 0x0,
			.virt_start = 0x0,
			.size = 0xa0000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE |
				JAILHOUSE_MEM_EXECUTE | JAILHOUSE_MEM_DMA,
		},
		/* MemRegion: 000a0000-000bffff : PCI Bus 0000:00 */
		{
			.phys_start = 0xa0000,
			.virt_start = 0xa0000,
			.size = 0x20000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: 000f0000-000fffff : System ROM */
		{
			.phys_start = 0xf0000,
			.virt_start = 0xf0000,
			.size = 0x10000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: 00100000-21ffffff : System RAM */
		{
			.phys_start = 0x100000,
			.virt_start = 0x100000,
			.size = 0x21f00000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE |
				JAILHOUSE_MEM_EXECUTE | JAILHOUSE_MEM_DMA,
		},
		/* MemRegion: 27200000-3ffd7fff : System RAM */
		{
			.phys_start = 0x27200000,
			.virt_start = 0x27200000,
			.size = 0x18dd8000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE |
				JAILHOUSE_MEM_EXECUTE | JAILHOUSE_MEM_DMA,
		},
		/* MemRegion: fe000000-fe7fffff : 0000:00:01.0 */
		{
			.phys_start = 0xfe000000,
			.virt_start = 0xfe000000,
			.size = 0x800000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: fe800000-fe803fff : virtio-pci-modern */
		{
			.phys_start = 0xfe800000,
			.virt_start = 0xfe800000,
			.size = 0x4000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: fe804000-fe807fff : virtio-pci-modern */
		{
			.phys_start = 0xfe804000,
			.virt_start = 0xfe804000,
			.size = 0x4000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: fe808000-fe80bfff : virtio-pci-modern */
		{
			.phys_start = 0xfe808000,
			.virt_start = 0xfe808000,
			.size = 0x4000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: fe80c000-fe80ffff : virtio-pci-modern */
		{
			.phys_start = 0xfe80c000,
			.virt_start = 0xfe80c000,
			.size = 0x4000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: feb80000-febbffff : 0000:00:02.0 */
		{
			.phys_start = 0xfeb80000,
			.virt_start = 0xfeb80000,
			.size = 0x40000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: febd0000-febd3fff : 0000:00:1b.0 */
		{
			.phys_start = 0xfebd0000,
			.virt_start = 0xfebd0000,
			.size = 0x4000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: febd7000-febd7fff : ehci_hcd */
		{
			.phys_start = 0xfebd7000,
			.virt_start = 0xfebd7000,
			.size = 0x1000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: febd8000-febd8fff : ahci */
		{
			.phys_start = 0xfebd8000,
			.virt_start = 0xfebd8000,
			.size = 0x1000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: fed00000-fed003ff : PNP0103:00 */
		{
			.phys_start = 0xfed00000,
			.virt_start = 0xfed00000,
			.size = 0x1000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: 000c0000-000dffff : ROMs */
		{
			.phys_start = 0xc0000,
			.virt_start = 0xc0000,
			.size = 0x20000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
		/* MemRegion: 22600000-271fffff : JAILHOUSE Inmate Memory */
		{
			.phys_start = 0x22600000,
			.virt_start = 0x22600000,
			.size = 0x4c00000,
			.flags = JAILHOUSE_MEM_READ | JAILHOUSE_MEM_WRITE,
		},
	},

	.irqchips = {
		/* IOAPIC 0, GSI base 0 */
		{
			.address = 0xfec00000,
			.id = 0xff00,
			.pin_bitmap = {
				0xffffffff, 0xffffffff, 0xffffffff, 0xffffffff
			},
		},
	},

	.pio_regions = {
		/* Port I/O: 0000-001f : dma1 */
		/* PIO_RANGE(0x0, 0x20), */
		/* Port I/O: 0020-0021 : pic1 */
		/* PIO_RANGE(0x20, 0x2), */
		/* Port I/O: 0040-0043 : timer0 */
		PIO_RANGE(0x40, 0x4),
		/* Port I/O: 0050-0053 : timer1 */
		/* PIO_RANGE(0x50, 0x4), */
		/* Port I/O: 0060-0060 : keyboard */
		PIO_RANGE(0x60, 0x1),
		/* Port I/O: 0064-0064 : keyboard */
		PIO_RANGE(0x64, 0x1),
		/* Port I/O: 0070-0071 : rtc0 */
		PIO_RANGE(0x70, 0x2),
		/* Port I/O: 0080-008f : dma page reg */
		/* PIO_RANGE(0x80, 0x10), */
		/* Port I/O: 00a0-00a1 : pic2 */
		/* PIO_RANGE(0xa0, 0x2), */
		/* Port I/O: 00c0-00df : dma2 */
		/* PIO_RANGE(0xc0, 0x20), */
		/* Port I/O: 00f0-00ff : fpu */
		/* PIO_RANGE(0xf0, 0x10), */
		/* Port I/O: 02f8-02ff : serial */
		PIO_RANGE(0x2f8, 0x8),
		/* Port I/O: 03c0-03df : vga+ */
		PIO_RANGE(0x3c0, 0x20),
		/* Port I/O: 03f8-03ff : serial */
		PIO_RANGE(0x3f8, 0x8),
		PIO_RANGE(0x3e8, 0x8),
		/* Port I/O: 0510-051b : QEMU0002:00 */
		/* PIO_RANGE(0x510, 0xc), */
		/* Port I/O: 0600-0603 : ACPI PM1a_EVT_BLK */
		/* PIO_RANGE(0x600, 0x4), */
		/* Port I/O: 0604-0605 : ACPI PM1a_CNT_BLK */
		/* PIO_RANGE(0x604, 0x2), */
		/* Port I/O: 0608-060b : ACPI PM_TMR */
		/* PIO_RANGE(0x608, 0x4), */
		/* Port I/O: 0620-062f : ACPI GPE0_BLK */
		/* PIO_RANGE(0x620, 0x10), */
		/* Port I/O: 0700-073f : i801_smbus */
		/* PIO_RANGE(0x700, 0x40), */
		/* Port I/O: c000-c07f : 0000:00:04.0 */
		PIO_RANGE(0xc000, 0x80),
		/* Port I/O: c0c0-c0df : 0000:00:02.0 */
		PIO_RANGE(0xc0c0, 0x20),
		/* Port I/O: c0e0-c0ff : 0000:00:03.0 */
		PIO_RANGE(0xc0e0, 0x20),
		/* Port I/O: c100-c11f : 0000:00:1d.0 */
		PIO_RANGE(0xc100, 0x20),
		/* Port I/O: c120-c13f : 0000:00:1d.1 */
		PIO_RANGE(0xc120, 0x20),
		/* Port I/O: c140-c15f : 0000:00:1d.2 */
		PIO_RANGE(0xc140, 0x20),
		/* Port I/O: c160-c17f : 0000:00:1f.2 */
		PIO_RANGE(0xc160, 0x20),
	},

	.pci_devices = {
		/* PCIDevice: 00:00.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0x0,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0x00000000, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:01.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0x8,
			.bar_mask = {
				0xff800000, 0x00000000, 0xffffc000,
				0xffffffff, 0xfffff000, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 6,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 3,
			.msix_region_size = 0x1000,
			.msix_address = 0xfebd4000,
		},
		/* PCIDevice: 00:02.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0x10,
			.bar_mask = {
				0xffffffe0, 0xfffff000, 0x00000000,
				0x00000000, 0xffffc000, 0xffffffff,
			},
			.caps_start = 0,
			.num_caps = 6,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 3,
			.msix_region_size = 0x1000,
			.msix_address = 0xfebd5000,
		},
		/* PCIDevice: 00:03.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0x18,
			.bar_mask = {
				0xffffffe0, 0x00000000, 0x00000000,
				0x00000000, 0xffffc000, 0xffffffff,
			},
			.caps_start = 6,
			.num_caps = 5,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:04.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0x20,
			.bar_mask = {
				0xffffff80, 0xfffff000, 0x00000000,
				0x00000000, 0xffffc000, 0xffffffff,
			},
			.caps_start = 0,
			.num_caps = 6,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 2,
			.msix_region_size = 0x1000,
			.msix_address = 0xfebd6000,
		},
		/* PCIDevice: 00:1b.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xd8,
			.bar_mask = {
				0xffffc000, 0x00000000, 0x00000000,
				0x00000000, 0x00000000, 0x00000000,
			},
			.caps_start = 11,
			.num_caps = 1,
			.num_msi_vectors = 1,
			.msi_64bits = 1,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1d.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xe8,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0xffffffe0, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1d.1 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xe9,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0xffffffe0, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1d.2 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xea,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0xffffffe0, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1d.7 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xef,
			.bar_mask = {
				0xfffff000, 0x00000000, 0x00000000,
				0x00000000, 0x00000000, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1f.0 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xf8,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0x00000000, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1f.2 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xfa,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0xffffffe0, 0xfffff000,
			},
			.caps_start = 12,
			.num_caps = 2,
			.num_msi_vectors = 1,
			.msi_64bits = 1,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
		/* PCIDevice: 00:1f.3 */
		{
			.type = JAILHOUSE_PCI_TYPE_DEVICE,
			.iommu = 0,
			.domain = 0x0,
			.bdf = 0xfb,
			.bar_mask = {
				0x00000000, 0x00000000, 0x00000000,
				0x00000000, 0xffffffc0, 0x00000000,
			},
			.caps_start = 0,
			.num_caps = 0,
			.num_msi_vectors = 0,
			.msi_64bits = 0,
			.msi_maskable = 0,
			.num_msix_vectors = 0,
			.msix_region_size = 0x0,
			.msix_address = 0x0,
		},
#if defined USE_VIRTIO_BLK
                { /* IVSHMEM (virtio-blk back-end) */
                        .type = JAILHOUSE_PCI_TYPE_IVSHMEM,
                        .iommu = 1,
                        .domain = 0x0,
                        .bdf = 0x0c << 3,
                        .bar_mask = JAILHOUSE_IVSHMEM_BAR_MASK_MSIX,
                        .num_msix_vectors = 2,
                        .shmem_regions_start = 0,
                        .shmem_dev_id = 0,
                        .shmem_peers = 2,
                        .shmem_protocol = JAILHOUSE_SHMEM_PROTO_VIRTIO_BACK +
                                VIRTIO_DEV_BLOCK,
                },
#endif
#if defined USE_VIRTIO_CON
                { /* IVSHMEM (virtio-con back-end) */
                        .type = JAILHOUSE_PCI_TYPE_IVSHMEM,
                        .iommu = 1,
                        .domain = 0x0,
                        .bdf = 0x0d << 3,
                        .bar_mask = JAILHOUSE_IVSHMEM_BAR_MASK_MSIX,
                        .num_msix_vectors = 3,
                        .shmem_regions_start = BLK_MEM, /* 0 + BLK_MEM */
                        .shmem_dev_id = 0,
                        .shmem_peers = 2,
                        .shmem_protocol = JAILHOUSE_SHMEM_PROTO_VIRTIO_BACK +
                                VIRTIO_DEV_CONSOLE,
                },
#endif
#if defined USE_IVSHMEM_DEMO
                { /* IVSHMEM (demo) */
                        .type = JAILHOUSE_PCI_TYPE_IVSHMEM,
			.iommu = 1,
                        .domain = 0x0,
                        .bdf = 0x0e << 3,
                        .bar_mask = JAILHOUSE_IVSHMEM_BAR_MASK_MSIX,
                        .num_msix_vectors = 16,
                        .shmem_regions_start = BLK_MEM + CON_MEM,
                        .shmem_dev_id = 0,
                        .shmem_peers = 3,
                        .shmem_protocol = JAILHOUSE_SHMEM_PROTO_UNDEFINED,
                },
#endif
#if defined USE_VIRTIO_NET
                { /* IVSHMEM (Networking) */
                        .type = JAILHOUSE_PCI_TYPE_IVSHMEM,
                        .iommu = 1,
                        .domain = 0x0,
                        .bdf = 0x0f << 3,
                        .bar_mask = JAILHOUSE_IVSHMEM_BAR_MASK_MSIX,
                        .num_msix_vectors = 2,
                        .shmem_regions_start = BLK_MEM + CON_MEM + DEMO_MEM,
                        .shmem_dev_id = 0,
                        .shmem_peers = 2,
                        .shmem_protocol = JAILHOUSE_SHMEM_PROTO_VETH,
                },
#endif
	},

	.pci_caps = {
		/* PCIDevice: 00:01.0 */
		/* PCIDevice: 00:02.0 */
		/* PCIDevice: 00:04.0 */
		{
			.id = PCI_CAP_ID_MSIX,
			.start = 0x98,
			.len = 0xc,
			.flags = JAILHOUSE_PCICAPS_WRITE,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x84,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x70,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x60,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x50,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x40,
			.len = 0x2,
			.flags = 0,
		},
		/* PCIDevice: 00:03.0 */
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x84,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x70,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x60,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x50,
			.len = 0x2,
			.flags = 0,
		},
		{
			.id = PCI_CAP_ID_VNDR,
			.start = 0x40,
			.len = 0x2,
			.flags = 0,
		},
		/* PCIDevice: 00:1b.0 */
		{
			.id = PCI_CAP_ID_MSI,
			.start = 0x60,
			.len = 0xe,
			.flags = JAILHOUSE_PCICAPS_WRITE,
		},
		/* PCIDevice: 00:1f.2 */
		{
			.id = PCI_CAP_ID_MSI,
			.start = 0x80,
			.len = 0xe,
			.flags = JAILHOUSE_PCICAPS_WRITE,
		},
		{
			.id = PCI_CAP_ID_SATA,
			.start = 0xa8,
			.len = 0x2,
			.flags = 0,
		},
	},
};