# Set Flutter Channel
FLUTTER_CHANNEL = "dev"

# Build engine with runtime=release
PACKAGECONFIG:pn-flutter-engine = "embedder-for-target disable-desktop-embeddings fontconfig mode-release"

# Include Flutter SDK in SDK
TOOLCHAIN_HOST_TASK:append = " nativesdk-flutter-sdk"
