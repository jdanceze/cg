import os

build_tools_path = "aapt"

# iterate over all files in the directory and subdirectories
for root, dirs, files in os.walk("."):
    for filename in files:
        if filename.endswith(".apk"):
            apk_path = os.path.join(root, filename)

            # get package name using aapt and awk command
            command = f"{build_tools_path} dump badging '{apk_path}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
            package_name = os.popen(command).read().strip()

            # rename file using package name
            new_filename = package_name + ".apk"
            new_apk_path = os.path.join(root, new_filename)
            os.rename(apk_path, new_apk_path)
