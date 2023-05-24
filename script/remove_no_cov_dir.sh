#!/bin/bash

# Enter the main directory
cd /workspace/ella-master6/ella-out

# Loop through all subdirectories
for dir in */
do
  # Check if the subdirectory contains coverage.dat
  if [ ! -f "${dir}coverage.dat.*" ]; then
    # Remove the subdirectory if it doesn't contain coverage.dat
    #rm -r "${dir}"
    echo $dir
  fi
done
