#!/bin/bash
if [ $# -eq 0 ]; then
    echo "Usage: $0 <APK category>"
    exit 1
fi

category=$1

for file in /workspace/foodT234_houseT12/"$category"/*
do
    if [[ $file == *.apk ]]; then
        echo "$file"
        java -jar /workspace/gencallgraphv3.jar --apk "$file" --sdk /usr/lib/android-sdk/platforms --output_file /workspace/foodT234_houseT12/output/"$category"/"$(basename "$file" .apk)".txt 2>&1 | tee /workspace/foodT234_houseT12/output/$category/"$(basename "$file" .apk)".log
    fi
done
