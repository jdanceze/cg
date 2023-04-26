import os

build_tools_path = "aapt"

# iterate over all files in the current directory and its subdirectories
for root, dirs, files in os.walk('.'):
    for filename in files:
        if filename.endswith(".apk"):
            # get package name using aapt and awk command
            command = f"{build_tools_path} dump badging '{os.path.join(root, filename)}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
            package_name = os.popen(command).read().strip()

            # rename file using package name
            new_filename = package_name + ".apk"
            os.rename(os.path.join(root, filename), os.path.join(root, new_filename))
