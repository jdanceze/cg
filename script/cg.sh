#!/bin/bash
read -p "Enter the APK category (e.g. art_design): " category

for file in /workspace/apk_cate/$category/*
do
 if [[ $file == *.apk ]]; then
  echo "$file"
  java -jar /workspace/gencallgraphv2.jar --apk "$file" --sdk /usr/lib/android-sdk/platforms --output_file /workspace/output/$category/"$(basename "$file" .apk)".txt 2>&1 | tee /workspace/output/$category/"$(basename "$file" .apk)".log
 fi
done
