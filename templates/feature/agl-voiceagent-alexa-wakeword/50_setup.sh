# Install and patch Amazon Alexa Auto SDK "amazonlite" wakeword engine

pushd $METADIR >/dev/null 2>&1

WAKEWORD_FEATURE_DIR="$METADIR/meta-agl-devel/templates/feature/agl-voiceagent-alexa-wakeword"
AMAZONLITE_VER="2.3"
AMAZONLITE_PATCH="${WAKEWORD_FEATURE_DIR}/amazonlite-${AMAZONLITE_VER}.patch"
AUTOSDK_EXTRAS_DIR="$METADIR/external/alexa-auto-sdk/extensions/extras"
AMAZONLITE_DIR="${AUTOSDK_EXTRAS_DIR}/amazonlite"

if [ -f "${AMAZONLITE_DIR}/README.md" ]; then
    ver=`grep '^Unzip the' "${AMAZONLITE_DIR}/README.md" | sed 's/.*amazonlite-\([0-9]\+\.[0-9]\+\)\.zip.*/\1/'`
    if [ "$ver" != ${AMAZONLITE_VER} ]; then
        echo "ERROR: ${AMAZONLITE_DIR} does not contain version ${AMAZONLITE_VER}!" >&2
        exit 1
    fi
fi

test -f ${XDG_CONFIG_HOME:-~/.config}/user-dirs.dirs && source ${XDG_CONFIG_HOME:-~/.config}/user-dirs.dirs
DOWNLOAD_DIR=${XDG_DOWNLOAD_DIR:-$HOME/Downloads}

if [ ! -f "${DOWNLOAD_DIR}/amazonlite-${AMAZONLITE_VER}.zip" ]; then
    echo "ERROR: amazonlite-${AMAZONLITE_VER}.zip not found in ${DOWNLOAD_DIR}!" >&2
    exit 1
elif [ ! -d "${AUTOSDK_EXTRAS_DIR}" ]; then
    echo "ERROR: Directory ${AUTOSDK_EXTRAS_DIR} not present!" >&2
    exit 1
fi
cd "${AUTOSDK_EXTRAS_DIR}"
if [ ! -d amazonlite ]; then
    echo "Extracting ${DOWNLOAD_DIR}/amazonlite-${AMAZONLITE_VER}.zip"
    unzip -q "${DOWNLOAD_DIR}/amazonlite-${AMAZONLITE_VER}.zip" || exit 1
    cd amazonlite
    echo "Patching ${AMAZONLITE_DIR}"
    patch -p0 < "${AMAZONLITE_PATCH}"
else
    cat <<-EOF
The amazonlite ${AMAZONLITE_VER} wakeword engine is already installed.
To force reinstallation, manually remove the directory:
           ${AMAZONLITE_DIR}

EOF
fi

popd >/dev/null 2>&1
