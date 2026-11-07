#!/bin/sh
# Start the Qt app on the ILI9341 framebuffer (no GPU, no X11/Wayland)

FB=$(grep -l -i "ili9341\|yx240" /sys/class/graphics/fb*/name 2>/dev/null | head -1 | cut -d/ -f5)
FB=${FB:-fb0}

export QT_QPA_PLATFORM="linuxfb:fb=/dev/${FB}"
export QT_QPA_FB_HIDECURSOR=1
export XDG_RUNTIME_DIR=/tmp/runtime-root
mkdir -p "$XDG_RUNTIME_DIR" && chmod 0700 "$XDG_RUNTIME_DIR"

# Touch (once a touch driver provides /dev/input/eventX):
# export QT_QPA_EVDEV_TOUCHSCREEN_PARAMETERS=/dev/input/event0:rotate=270

exec /usr/bin/qt-display-test "$@"
