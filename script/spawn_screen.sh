#!/bin/bash

for i in {1..20}
#for i in {20..38}
do
  # Start screen session
  screen -dmS lifestyle_$i
  screen -S lifestyle_$i -X stuff "bash\n"
  screen -S lifestyle_$i -X stuff "./cg_new.sh $i\n"
done
