import csv

# Read data from 1.txt
with open('/Users/jdanceze/Desktop/hub/cg/log_time.txt', 'r') as f:
    data1 = f.read().splitlines()

# Read data from 2.txt
with open('/Users/jdanceze/Desktop/hub/cg/list/art_design_new.txt', 'r') as f:
    data2 = f.read().splitlines()

# Create a dictionary to map package names to app names and versions
package_data = {}
for line in data2:
    package_name, version = line.split(',')
    package_data[package_name] = (version)

# Combine data from 1.txt and 2.txt
combined_data = []
missing_packages = []
for line in data1:
    package_name, time = line.split(',')
    if package_name in package_data:
        version = package_data[package_name]
        combined_data.append([package_name, version, time])
    else:
        missing_packages.append(package_name)

# Write combined data to CSV file
with open('combined_data.csv', 'w', newline='') as f:
    writer = csv.writer(f)
    writer.writerow(['Package Name','Version', 'Time'])
    writer.writerows(combined_data)

# Print missing packages
if missing_packages:
    print("The following packages were not found in data2:")
    for package_name in missing_packages:
        print(package_name)
else:
    print("All packages in data1 were found in data2.")
