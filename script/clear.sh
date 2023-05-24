#!/bin/bash
adb -s emulator-5554 emu kill
adb -s emulator-5554 emu kill
echo "initial emu"
sleep 5
echo "start emu"
#emulator -writable-system -avd 19_86 -no-accel -no-audio -no-boot-anim -no-snapshot-save -no-window -skip-adb-auth -verbose &
screen -dmS emulator_session emulator -writable-system -avd 19_86 -no-accel -no-audio -no-boot-anim -no-snapshot-save -no-window -skip-adb-auth -verbose -wipe-data
echo "Waiting for emulator to boot..."
sleep 60
adb root
adb remount
echo "Fin"