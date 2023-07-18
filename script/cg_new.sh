#!/bin/bash
if [ $# -eq 0 ]; then
    echo "Usage: $0 <APK category>"
    exit 1
fi

category=$1

for file in /workspace/lifestyle/"$category"/*
do
    if [[ $file == *.apk ]]; then
        echo "$file"
        java -jar /workspace/gencallgraphv3.jar --apk "$file" --sdk /usr/lib/android-sdk/platforms --output_file /workspace/lifestyle/output/"$category"/"$(basename "$file" .apk)".txt 2>&1 | tee /workspace/lifestyle/output/$category/"$(basename "$file" .apk)".log
    fi
done
