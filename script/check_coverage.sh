#!/bin/bash

# Enter the main directory
cd /workspace/ella-master5/ella-out

# Loop through all subdirectories
for dir in */
do
  # Check if the file exists in the subdirectory
  if [ -f "${dir}method_coverage" ]; then
    echo -n "${dir::-1}," >> ella_coverage.txt
    cat "${dir}method_coverage" >> ella_coverage.txt
    echo "" >> ella_coverage.txt
  fi
done