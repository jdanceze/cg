#!/bin/bash


DIRECTORY="/workspace/coverage/dir"

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
