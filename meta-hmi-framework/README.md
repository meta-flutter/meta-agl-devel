This README file contains information on the contents of the
hmi-framework layer.

Please see the corresponding sections below for details.


HMI Framework
================
meta-hmi-framework is the layer providing HMI framework. 
HMI framework provides HMI resource(right) management. Resource contains sound, window, input to control.
This is based on the document in https://wiki.automotivelinux.org/hmiframework

Maintainers:
 Takeshi Hoshina<takeshi_hoshina@mail.toyota.co.jp>
 Hiroshi Kojima<Hiroshi_Kojima@mentor.com>
 Kazumasa Mitsunari<knimitz@witz-inc.co.jp>


How to enable the framework
=================
In order to enable the HMI Framework features, the following line has to be enabled in local.conf

IMAGE_INSTALL_append += ""

Reference
=================
https://wiki.automotivelinux.org/hmiframework


I. Adding the hmi-framework layer to your build
=================================================

--- replace with specific instructions for the hmi-framework layer ---

In order to use this layer, you need to make the build system aware of
it.

Assuming the hmi-framework layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the hmi-framework layer to bblayers.conf, along with any
other layers needed. e.g.:

  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-poky \
    /path/to/yocto/meta-yocto-bsp \
    /path/to/yocto/meta-hmi-framework \
    "


II. Misc
========

--- replace with specific information about the hmi-framework layer ---
