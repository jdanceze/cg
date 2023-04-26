import os
import re

# path to the directory containing the .log files
log_dir = "/workspace/lifestyle/output_bak"

# regular expression to match the time in the log file
time_regex = r"Total time to construct call graph: (\d+\.\d+) seconds"

# create a list to store the log file names and their corresponding times
log_times = []

# iterate over all files in the directory and its subdirectories
for root, dirs, files in os.walk(log_dir):
    for filename in files:
        if filename.endswith(".log"):
            # read the contents of the log file
            log_path = os.path.join(root, filename)
            with open(log_path, "r") as f:
                log_content = f.read()

            # extract the time from the log file using the regular expression
            match = re.search(time_regex, log_content)
            if match:
                time = float(match.group(1))
            else:
                time = None

            # add the log file name and time to the list
            file_base = os.path.splitext(filename)[0]
            log_times.append((file_base, time))

# save the log file names and times to a text file
with open("/workspace/lifestyle/log_times.txt", "w") as f:
    for log_time in log_times:
        f.write(f"{log_time[0]}: {log_time[1]}\n")
