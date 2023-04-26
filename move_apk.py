import os
import shutil

# directory with .apk files
source_dir = "/Users/jdanceze/Downloads"

# create directory to move files to
dest_dir = "/Users/jdanceze/Downloads/1"
if not os.path.exists(dest_dir):
    os.mkdir(dest_dir)

# move files
count = 0
for i, file in enumerate(os.listdir(source_dir)):
    if file.endswith(".apk"):
        count += 1
        shutil.move(os.path.join(source_dir, file), os.path.join(dest_dir, file))

        # create new destination directory if current directory has 10 files
        if count == 10:
            count = 0
            dest_dir = os.path.join(source_dir, str(int(dest_dir.split("/")[-1]) + 1))
            os.mkdir(dest_dir)
