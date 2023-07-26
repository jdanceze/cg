#!/bin/bash

# Enter the main directory
cd /workspace/ella-master6/ella-out

# Loop through all subdirectories
for subdir in */
do
  # Navigate to the subdirectory
  cd "$subdir"

  # Concatenate the files in the subdirectory
  cat coverage.dat.* > coverage.dat.2025-06-11-18-04-31
  #rm coverage.dat.2023-06-11-18-04-31
  # Move the combined file back to the main directory
  #mv combined ../"$subdir"_combined

  # Return to the main directory
  cd ..
done
