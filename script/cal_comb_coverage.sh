#!/bin/bash
if [ $# -eq 0 ]; then
    echo "missing apk list"
    exit 1
fi


sap_dir=$1
ares_dir=$2
apk_list=$3

echo "Input apk list: $apk_list"

for apk_path in $(cat "$apk_list"); do

    out_directory=$(python2 /workspace/ella-master/tools/apkout_comb.py $apk_path)
    mkdir /workspace/coverage/dir/$out_directory
    echo "Output directory: $out_directory"
    cp $sap_dir/$out_directory/coverage.dat.* /workspace/coverage/dir/$out_directory
    cp $ares_dir/$out_directory/coverage.dat.* /workspace/coverage/dir/$out_directory
    cp $sap_dir/$out_directory/covids /workspace/coverage/dir/$out_directory
    cd /workspace/coverage/dir/$out_directory
    cat coverage.dat.* > coverage.dat.2025-06-11-18-04-31
    cd ..
    python2 /workspace/ella-master/tools/tool_coverage_comb.py $apk_path $out_directory method


done
