#!/bin/bash

# Enter the main directory
cd /workspace/ella-master/ella-out

# Loop through all subdirectories
for dir in */
do
  # Check if the file exists in the subdirectory
  if [ -f "${dir}method_coverage" ]; then
    echo -n "${dir::-1}," >> subdirs_with_file.txt
    cat "${dir}method_coverage" >> subdirs_with_file.txt
    echo "" >> subdirs_with_file.txt
  fi
done
