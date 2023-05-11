#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
echo "Input apk list: $apk_list"

# Loop over APK paths in the list
for apk_path in $(cat "$apk_list"); do
    echo "Processing apk: $apk_path"
    out_directory=$(python2 /workspace/ella-master/tools/apk_out.py $apk_path)
    echo "Output directory: $out_directory"
    echo "Running ella..."
    /workspace/ella-master/ella.sh i $apk_path
    if [ ! -f $out_directory/instrumented.apk ]; then
        echo "Instrumentation failed"
        echo $apk_path >> /workspace/instrumented_failed_apk.txt
        continue # skip to next APK
    fi
    echo $apk_path >> /workspace/instrumented_success_apk.txt
    echo "initial emu..."
    timeout 180s /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    adb push /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/foo.txt /system/foo.txt
    if [ $? -ne 0 ]; then
        echo "Emulator not ready"
        echo "Restarting emulator..."
        timeout 180s /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    fi
    echo "Running sapienz..."
    echo $apk_path >> /workspace/start_apk.txt
    timeout 3600s python2 /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/main.py $out_directory/instrumented.apk
    echo "calculating coverage..."
    /workspace/ella-master/ella.sh e
    python2 /workspace/ella-master/tools/tool_coverage.py $apk_path method
    echo $apk_path >> /workspace/end_apk.txt
    echo "clear emu"
    adb -s emulator-5554 emu kill
done