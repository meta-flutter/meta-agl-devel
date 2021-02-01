---
description: Feature agl-voiceagent-alexa-wakeword
authors: Scott Murray <scott.murray@konsulko.com>
---

### Feature agl-voiceagent-alexa-wakeword

Enables building the Amazon Alexa voiceagent binding with included wakeword engine support.

Note that this features assumes that the amazonlite wakeword engine ZIP file
(i.e. amazonlite-2.3.zip) is present in the directory pointed at by the
XDG_DOWNLOAD_DIR environment variable if it is set, and $HOME/Downloads
otherwise.  The zip file will be extracted into place in the alexa-auto-sdk
repository (at external/alexa-auto-sdk/extensions/extra/amazonlite), and
patched to work with the version of Yocto used by AGL.
