#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
adb devices
sleep 2
/workspace/ella-master5/ella.sh s
sleep 5
echo "Input apk list: $apk_list"

# Loop over APK paths in the list
for apk_path in $(cat "$apk_list"); do
    adb devices
    echo "Processing apk: $apk_path"
    out_directory=$(python2 /workspace/ella-master5/tools/apk_out.py $apk_path)
    echo "Output directory: $out_directory"
    echo "Running ella..."
    /workspace/ella-master5/ella.sh i $apk_path
    if [ ! -f $out_directory/instrumented.apk ]; then
        echo "Instrumentation failed"
        echo $apk_path >> /workspace/progress/instrumented_failed_apk.txt
        continue # skip to next APK
    fi
    echo $apk_path >> /workspace/progress/instrumented_success_apk.txt
    echo "initial emu..."
    timeout 180s /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    adb push /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/foo.txt /system/foo.txt
    if [ $? -ne 0 ]; then
        echo "Emulator not ready"
        adb -s emulator-5554 emu kill
        echo "Restarting emulator..."
        timeout 180s /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    fi
    echo "Running sapienz..."
    echo $apk_path >> /workspace/progress/start_apk5.txt
    timeout 7200s python2 /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/main.py $out_directory/instrumented.apk
    sleep 10
    echo "calculating coverage..."
    /workspace/ella-master5/ella.sh e
    timeout 90s python2 /workspace/ella-master5/tools/tool_coverage.py $apk_path method
    echo $apk_path >> /workspace/progress/end_apk5.txt
    echo "clear emu"
    adb -s emulator-5554 emu kill
done