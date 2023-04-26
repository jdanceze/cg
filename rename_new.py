import os
import re

build_tools_path = "/Users/jdanceze/Library/Android/sdk/build-tools/33.0.2/aapt"

# iterate over all files in the current directory
for filename in os.listdir():
    if filename.endswith(".apk"):
        # remove special characters from filename
        new_filename = re.sub(r'[^\w\s-]', '', filename).strip()
        os.rename(filename, new_filename)

        # get package name using aapt and awk command
        command = f"{build_tools_path} dump badging '{new_filename}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
        package_name = os.popen(command).read().strip()

        # rename file using package name
        final_filename = package_name + ".apk"
        os.rename(new_filename, final_filename)
