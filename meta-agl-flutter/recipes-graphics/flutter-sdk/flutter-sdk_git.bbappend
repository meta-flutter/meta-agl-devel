
# fix for the archiver:
# the function get_flutter_sdk_version does access the network
# when it is expanded later in the archiver, we need to allow the network
do_ar_original[network] = "1"
