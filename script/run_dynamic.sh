#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
adb devices
sleep 2
#/workspace/ella-master/ella.sh s
#sleep 5
echo "Input apk list: $apk_list"

# Loop over APK paths in the list
for apk_path in $(cat "$apk_list"); do
    /workspace/kill_port.sh 23745
    sleep 5
    adb devices
    /workspace/ella-master/ella.sh s
    sleep 5
    echo "Processing apk: $apk_path"
    out_directory=$(python2 /workspace/ella-master/tools/apk_out.py $apk_path)
    echo "Output directory: $out_directory"
    echo "Running ella..."
    /workspace/ella-master/ella.sh i $apk_path
    if [ ! -f $out_directory/instrumented.apk ]; then
        echo "Instrumentation failed"
        echo $apk_path >> /workspace/progress/1/instrumented_failed_apk.txt
        /workspace/ella-master/ella.sh k
        sleep 10
        continue # skip to next APK
    fi
    echo $apk_path >> /workspace/progress/1/instrumented_success_apk.txt
    echo "initial emu..."
    /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    adb push /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/foo.txt /system/foo.txt
    if [ $? -ne 0 ]; then
        echo "Emulator not ready"
        adb -s emulator-5554 emu kill
        echo "Restarting emulator..."
        /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/clear.sh
    fi
    #echo "load start stage"
    #adb emu avd snapshot load start
    echo "Running sapienz..."
    echo $apk_path >> /workspace/progress/1/start_apk.txt

    # Execute the command without a static timeout
    python2 /workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/main.py $out_directory/instrumented.apk &

    # Get the process ID of the command
    local pid=$!
    /timer.sh $pid $apk_path

    # Wait for the termination signal from the other script
    wait $pid

    sleep 10
    echo "calculating coverage..."
    #/workspace/ella-master/ella.sh e
    adb -s emulator-5554 emu kill
    /workspace/ella-master/ella.sh k
    timeout 90s python2 /workspace/ella-master/tools/tool_coverage.py $apk_path method
    echo $apk_path >> /workspace/progress/1/end_apk.txt
    #echo "clear emu"
    #adb -s emulator-5554 emu kill
    #/workspace/ella-master/ella.sh k
done