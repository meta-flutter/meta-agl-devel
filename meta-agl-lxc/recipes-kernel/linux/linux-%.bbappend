include ${@'linux_lxc.inc' if bb.data.inherits_class('kernel', d) else ''}
