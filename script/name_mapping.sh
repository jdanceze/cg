#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
echo "Input apk list: $apk_list"

for apk_path in $(cat "$apk_list"); do
    python2 /workspace/ella-master/tools/apk_out.py $apk_path
done
