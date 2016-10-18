do_configure_append_porter() {
    # Enable CONFIG_NETFILTER
    # kernel_configure_variable NETFILTER y
    # kernel_configure_variable NETFILTER_ADVANCED y
    #
    # Core Netfilter Configuration
    #
    # kernel_configure_variable NF_CONNTRACK y
    kernel_configure_variable NF_CONNTRACK_PROCFS y
    kernel_configure_variable NF_CT_PROTO_UDPLITE y
    kernel_configure_variable NF_CONNTRACK_BROADCAST y
    kernel_configure_variable NF_CONNTRACK_SNMP y
    kernel_configure_variable NF_NAT y
    kernel_configure_variable NF_NAT_NEEDED y
    kernel_configure_variable NF_NAT_PROTO_UDPLITE y
    # kernel_configure_variable NETFILTER_XTABLES y
    #
    # Xtables combined modules
    #
    kernel_configure_variable NETFILTER_XT_MARK y
    #
    # Xtables targets
    #
    kernel_configure_variable NETFILTER_XT_TARGET_CT y
    kernel_configure_variable NETFILTER_XT_TARGET_DSCP y
    kernel_configure_variable NETFILTER_XT_TARGET_LOG y
    kernel_configure_variable NETFILTER_XT_TARGET_MARK y
    kernel_configure_variable NETFILTER_XT_TARGET_NETMAP y
    kernel_configure_variable NETFILTER_XT_TARGET_NOTRACK y
    kernel_configure_variable NETFILTER_XT_TARGET_REDIRECT y
    kernel_configure_variable NETFILTER_XT_TARGET_TCPMSS y
    kernel_configure_variable NETFILTER_XT_TARGET_TCPOPTSTRIP y
    #
    # Xtables matches
    #
    kernel_configure_variable NETFILTER_XT_MATCH_HASHLIMIT y
    kernel_configure_variable NETFILTER_XT_MATCH_LENGTH y
    kernel_configure_variable NETFILTER_XT_MATCH_LIMIT y
    kernel_configure_variable NETFILTER_XT_MATCH_POLICY y
    kernel_configure_variable NETFILTER_XT_MATCH_STATE y
    kernel_configure_variable NETFILTER_XT_MATCH_TCPMSS y
    kernel_configure_variable NETFILTER_XT_MATCH_TIME y
    #
    # IP: Netfilter Configuration
    #
    # kernel_configure_variable NF_DEFRAG_IPV4 y
    # kernel_configure_variable NF_CONNTRACK_IPV4 y
    kernel_configure_variable NF_CONNTRACK_PROC_COMPAT y
    # kernel_configure_variable IP_NF_IPTABLES y
    kernel_configure_variable IP_NF_FILTER y
    kernel_configure_variable IP_NF_TARGET_REJECT y
    kernel_configure_variable IP_NF_TARGET_ULOG y
    # kernel_configure_variable NF_NAT_IPV4 y
    # kernel_configure_variable IP_NF_TARGET_MASQUERADE y
    kernel_configure_variable IP_NF_TARGET_NETMAP y
    kernel_configure_variable IP_NF_TARGET_REDIRECT y
    kernel_configure_variable NF_NAT_SNMP_BASIC y
    kernel_configure_variable IP_NF_MANGLE y
    kernel_configure_variable IP_NF_TARGET_ECN y
    kernel_configure_variable IP_NF_RAW y
    #
    # IPv6: Netfilter Configuration
    #
    # kernel_configure_variable NF_DEFRAG_IPV6 y
    kernel_configure_variable NF_CONNTRACK_IPV6 y
    # kernel_configure_variable IP6_NF_IPTABLES y
    kernel_configure_variable IP6_NF_FILTER y
    kernel_configure_variable IP6_NF_TARGET_REJECT y
    kernel_configure_variable IP6_NF_MANGLE y
    kernel_configure_variable IP6_NF_RAW y
    kernel_configure_variable NF_NAT_IPV6 y
    kernel_configure_variable IP6_NF_TARGET_MASQUERADE y
    kernel_configure_variable IP6_NF_TARGET_NPT y
}

