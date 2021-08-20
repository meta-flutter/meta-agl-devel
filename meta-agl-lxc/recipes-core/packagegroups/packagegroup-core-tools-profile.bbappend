# Disable LTTng dependencies when building for container guest to avoid
# lttng-modules being pulled in as a dependency.
LTTNGUST:aglcontainerguest = ""
LTTNGTOOLS:aglcontainerguest = ""
LTTNGMODULES:aglcontainerguest = ""

# Similarly, disable perf since it builds out of the kernel source tree.
PERF:aglcontainerguest = ""
