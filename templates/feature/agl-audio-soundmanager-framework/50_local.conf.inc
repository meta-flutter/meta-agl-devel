DISTRO_FEATURES_append = " agl-audio-soundmanager-framework pulseaudio"
IMAGE_INSTALL_append += "agl-service-audio-soundmanager pulseaudio-config-soundmanager audiomanager-plugins-config-soundmanager"

PREFERRED_PROVIDER_virtual/audio-framework = "agl-service-audio-soundmanager"
PREFERRED_RPROVIDER_virtual/pulseaudio-config = "pulseaudio-config-soundmanager"
PREFERRED_RPROVIDER_virtual/audiomanager-plugins-config = "audiomanager-plugins-config-soundmanager"
