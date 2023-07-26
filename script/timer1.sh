#!/bin/bash

if [ $# -ne 2 ]; then
    echo "Usage: $0 <command PID> <APK path>"
    exit 1
fi

# Get the command PID and APK path from the command-line arguments
command_pid=$1
apk_path=$2

# Initialize the previous coverage value
previous_coverage=0
rm /workspace/dynamic_log1.txt
echo "start" >> /workspace/dynamic_log1.txt

sleep 1200

echo "after 30min" >> /workspace/dynamic_log1.txt

while true; do
    # Execute the command and get the current coverage value
    current_coverage=$(python2 /workspace/ella-master/tools/current_tool_cov.py $apk_path method)
    #sleep 30
    echo "in true" >> /workspace/dynamic_log1.txt
    echo "cur cov:" $current_coverage >> /workspace/dynamic_log1.txt
    echo "prev cov:" $previous_coverage >> /workspace/dynamic_log1.txt
    # Compare the current coverage value with the previous value
    if (( $(echo "$current_coverage > $previous_coverage" | bc -l) )); then
        # Coverage has increased, update the previous coverage value
        previous_coverage=$current_coverage
        echo "cov increase" >> /workspace/dynamic_log1.txt
        echo $current_coverage >> /workspace/dynamic_log1.txt
    else
        # Coverage has not increased, send termination signal to the command PID
        echo "kill" >> /workspace/dynamic_log1.txt
        echo $current_coverage >> /workspace/dynamic_log1.txt
        kill -15 $command_pid
        break
    fi

    # Wait for 10 minutes before checking again
    sleep 600
done
