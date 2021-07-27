#!/bin/sh

echo "Running QEMU..."
runqemu qemux86-64 slirp kvm publicvnc serial bootparams="verbose ipv6.disable=1 intel_iommu=off"
echo "Powering Off..."

# Note: If you want to run `$ jailhouse hardware check` then make `intel_iommu=on`, and `intel_iommu=off` for otherwise.
