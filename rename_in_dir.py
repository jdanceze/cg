import os
import re

build_tools_path = "/Users/jdanceze/Library/Android/sdk/build-tools/33.0.2/aapt"
directory_path = "/Users/jdanceze/Downloads/apk/tranT45_travT1234"  # Specify the directory path you want to iterate over

# Iterate over all files in the directory and subdirectories
for root, directories, filenames in os.walk(directory_path):
    for filename in filenames:
        if filename.endswith(".apk"):
            # Get the absolute file path
            file_path = os.path.join(root, filename)

            # Remove special characters from the filename
            new_filename = re.sub(r'[^\w\s-]', '', filename).strip()
            new_file_path = os.path.join(root, new_filename)
            os.rename(file_path, new_file_path)

            # Get the package name using aapt and awk command
            command = f"{build_tools_path} dump badging '{new_file_path}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
            package_name = os.popen(command).read().strip()

            # Rename the file using the package name
            final_filename = package_name + ".apk"
            final_file_path = os.path.join(root, final_filename)
            os.rename(new_file_path, final_file_path)
