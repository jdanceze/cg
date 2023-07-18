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

while true; do
    # Execute the command and get the current coverage value
    current_coverage=$(python2 /workspace/ella-master/tools/current_tool_cov.py $apk_path method)

    # Compare the current coverage value with the previous value
    if (( $(echo "$current_coverage > $previous_coverage" | bc -l) )); then
        # Coverage has increased, update the previous coverage value
        previous_coverage=$current_coverage
    else
        # Coverage has not increased, send termination signal to the command PID
        kill -15 $command_pid
        break
    fi

    # Wait for 5 minutes before checking again
    sleep 300
done
