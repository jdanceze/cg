#!/bin/bash

# Check if the input is provided
if [ $# -eq 0 ]; then
    echo "Usage: ./script.sh {X}"
    exit 1
fi

# Get the input from the command-line argument
INPUT=$1

# Check if the input is "1" to treat it as a blank value
if [ "$INPUT" = "1" ]; then
    DIRECTORY="/workspace/ella-master/ella-out"
else
    DIRECTORY="/workspace/ella-master${INPUT}/ella-out"
fi

# Enter the main directory
cd "$DIRECTORY"

# Remove the old ella_coverage_new.txt file if it exists
if [ -f "ella_coverage_new.txt" ]; then
    rm "ella_coverage_new.txt"
fi

# Loop through all subdirectories
for dir in */
do
  # Check if the file exists in the subdirectory
  if [ -f "${dir}method_coverage" ]; then
    echo -n "${dir::-1},${DIRECTORY}/${dir}," >> ella_coverage_new.txt
    #cat "${dir}method_coverage" >> ella_coverage_new.txt
    sed 's/%/,/' "${dir}method_coverage" >> ella_coverage_new.txt
    echo "" >> ella_coverage_new.txt
  fi
done
