#!/bin/bash

for i in {1..20}
#for i in {21..40}
do
  # Start screen session
  screen -dmS foodT234_$i
  screen -S foodT234_$i -X stuff "bash\n"
  screen -S foodT234_$i -X stuff "./cg_new.sh $i\n"
done
