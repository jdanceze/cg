import os

# path to the directory containing the .log files
log_dir = "/workspace/lifestyle/output_bak"

# path to the text file containing the mapping of filenames to package names
mapping_file = "/workspace/lifestyle/name_mapper.txt"

# read the mapping file into a dictionary
mapping = {}
with open(mapping_file, "r") as f:
    for line in f:
        line = line.strip()
        if line:
            apk_file, package_name = line.split("|")
            apk_file = apk_file[:-4]
            mapping[apk_file] = package_name

# iterate over all files in the directory and its subdirectories
for root, dirs, files in os.walk(log_dir):
    for filename in files:
        if filename.endswith(".log"):
            # get the filename without the extension
            file_base = os.path.splitext(filename)[0]

            # check if the filename without extension is in the mapping dictionary
            if file_base in mapping:
                # get the package name from the mapping dictionary
                package_name = mapping[file_base]

                # rename the file with the package name
                old_path = os.path.join(root, filename)
                new_name = package_name + ".log"
                new_path = os.path.join(root, new_name)
                os.rename(old_path, new_path)
