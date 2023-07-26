#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
adb devices
sleep 2
echo "Input apk list: $apk_list"
export PYTHONPATH="/workspace/ARES"
# Loop over APK paths in the list
for apk_path in $(cat "$apk_list"); do
    /workspace/kill_port.sh 26745
    sleep 10
    /workspace/ella-master6/ella.sh s
    sleep 5
    adb devices
    echo "Processing apk: $apk_path"
    out_directory=$(python2 /workspace/ella-master6/tools/apk_out.py $apk_path)
    echo "Output directory: $out_directory"
    echo "Running ella..."
    /workspace/ella-master6/ella.sh i $apk_path
    if [ ! -f $out_directory/instrumented.apk ]; then
        echo "Instrumentation failed"
        echo $apk_path >> /workspace/progress/6/instrumented_failed_apk_6.txt
        continue # skip to next APK
    fi
    echo $apk_path >> /workspace/progress/6/instrumented_success_apk_6.txt
    echo "copy apk"
    apk_name=$(basename $apk_path)
    mkdir /workspace/ARES/rl_interaction/apk_dir
    mkdir /workspace/ARES/rl_interaction/apk_dir/$apk_name
    cp $out_directory/instrumented.apk /workspace/ARES/rl_interaction/apk_dir/$apk_name/$apk_name
    
    echo "Running ARES..."
    echo $apk_path >> /workspace/progress/6/start_apk6.txt
    timeout 5000s python3 /workspace/ARES/rl_interaction/parallel_exec.py --instr_jacoco --list_devices "31_86_64" --appium_ports "4723"  --android_ports "5554" --path "/workspace/ARES/rl_interaction/apk_dir/$apk_name" --timer 60 --rotation --save_policy --emu headless --platform_version 11 --iterations 10 --algo SAC --timesteps 4000 --trials_per_app 3
    sleep 10
    #/workspace/ella-master6/ella.sh e
    adb -s emulator-5554 emu kill
    /workspace/ella-master6/ella.sh k
    # echo "calculating coverage..."
    # timeout python2 /workspace/ella-master6/tools/tool_coverage.py $apk_path method
    echo $apk_path >> /workspace/progress/6/end_apk6.txt

done
