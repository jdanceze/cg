import os

dir_path = "/Users/jdanceze/Downloads/apk/sport_tool_tran_wea_auto1_auto2"
count = 0

for root, dirs, files in os.walk(dir_path):
    for file in files:
        if file.endswith(".apk"):
            count += 1

print(f"Number of APK files: {count}")
