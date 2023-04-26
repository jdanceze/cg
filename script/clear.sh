#!/bin/bash
adb -s emulator-5554 emu kill
adb -s emulator-5554 emu kill
emulator -writable-system -avd 19_86 -no-accel -no-audio -no-boot-anim -no-snapshot-save -no-window -skip-adb-auth -verbose &
echo "Waiting for emulator to boot..."
sleep 30
adb root
adb remount
echo "Fin"