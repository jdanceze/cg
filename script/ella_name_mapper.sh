#!/bin/bash
if [ $# -lt 1 ]; then
    echo "Missing arguments. Usage: $0 <apk_list> [<ella_number>]"
    exit 1
fi

apk_list=$1
if [ $# -eq 2 ]; then
    ella_number=$2
    ella_path="/workspace/ella-master${ella_number}"
else
    ella_path="/workspace/ella-master"
fi

echo "Input apk list: $apk_list"
echo "Ella path: $ella_path"

for apk_path in $(cat "$apk_list"); do
    python2 $ella_path/tools/apk_out.py $apk_path
done
