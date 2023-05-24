#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
echo "Input apk list: $apk_list"
# Loop over APK paths in the list
for apk_path in $(cat "$apk_list"); do
    echo "calculating coverage..."
    python2 /workspace/ella-master6/tools/tool_coverage.py $apk_path method

done
