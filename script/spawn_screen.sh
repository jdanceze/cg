#!/bin/bash

for i in {1..58}
do
  # Start screen session
  screen -dmS all_myscreen_$i
  screen -S all_myscreen_$i -X stuff "bash\n"
  screen -S all_myscreen_$i -X stuff "./cg_new.sh $i\n"
done
