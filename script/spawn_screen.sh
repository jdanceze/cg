#!/bin/bash

for i in {1..29}
#for i in {30..53}
do
  # Start screen session
  screen -dmS socialT4_$i
  screen -S socialT4_$i -X stuff "bash\n"
  screen -S socialT4_$i -X stuff "./cg_new.sh $i\n"
done
