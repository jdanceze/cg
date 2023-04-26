import os

#build_tools_path = "/Users/jdanceze/Library/Android/sdk/build-tools/33.0.2/aapt"

# path to directory to search for apk files
dir_path = "/workspace/lifestyle"

# path to output file
output_file = "/workspace/lifestyle/name_mapper.txt"

# open output file for writing
with open(output_file, "w") as f:
    # recursively iterate over all directories and files in dir_path
    for root, dirs, files in os.walk(dir_path):
        for filename in files:
            if filename.endswith(".apk"):
                # get package name using aapt and awk command
                file_path = os.path.join(root, filename)
                command = f"aapt dump badging '{file_path}' | awk '/package/{{gsub(\"name=|'\"'\"'\",\"\"); print $2}}'"
                package_name = os.popen(command).read().strip()

                # write filename and package name to output file
                f.write(f"{filename},{package_name}\n")
