#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi

apk_list=$1
echo "Input apk list: $apk_list"

for apk_path in $(cat "$apk_list"); do

    out_directory=$(python2 /workspace/ella-master/tools/apkout_comb.py $apk_path)
    mkdir /workspace/coverage/$out_directory
    echo "Output directory: $out_directory"
    cp /workspace/ella-master/ella-out/$out_directory/coverage.dat.* /workspace/coverage/$out_directory
    cp /workspace/ella-master6/1/$out_directory/coverage.dat.* /workspace/coverage/$out_directory
    cp /workspace/ella-master/ella-out/$out_directory/covids /workspace/coverage/$out_directory
    cd /workspace/coverage/$out_directory
    cat coverage.dat.* > coverage.dat.2025-06-11-18-04-31
    cd ..
    python2 /workspace/ella-master/tools/tool_coverage_comb.py $apk_path $out_directory method


done