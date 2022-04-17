# Include Flutter SDK in SDK
TOOLCHAIN_HOST_TASK:append = " nativesdk-flutter-sdk"

# Include agl-specific defaults
require conf/include/agl-flutter.inc
