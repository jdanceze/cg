import os

build_tools_path = "/Users/jdanceze/Library/Android/sdk/build-tools/33.0.2/aapt"

# iterate over all files in the current directory
for filename in os.listdir():
    if filename.endswith(".apk"):
        # get package name using aapt and awk command
        command = f"{build_tools_path} dump badging '{filename}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
        package_name = os.popen(command).read().strip()

        # rename file using package name
        new_filename = package_name + ".apk"
        os.rename(filename, new_filename)
