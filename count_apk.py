import os

dir_path = "/Users/jdanceze/Downloads/apk/tranT45_travT1234"
count = 0

for root, dirs, files in os.walk(dir_path):
    for file in files:
        if file.endswith(".apk"):
            count += 1

print(f"Number of APK files: {count}")
