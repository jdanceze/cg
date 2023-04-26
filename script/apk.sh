#!/bin/bash

# Specify the number of APKs to download
num_apks=5

# Specify the category of apps to download
category="HEALTH_AND_FITNESS"

# Specify the output file name
output_file="apk_list.txt"

#!/bin/bash

# Specify the number of apps to get
num_apps=100

# Loop through the top apps in the specified category
curl -s "https://play.google.com/store/apps/top/category/${category}" | grep -o 'href="/store/apps/details?id=[^"]*"' | awk -F= '{print $2}' | sed 's/\"//g' | grep -v "games" | sed "${num_apps}q" | while read app_id; do
  # Get the package name
  package_name=$(echo "${app_id}" | awk -F'=' '{print $2}')

  # Print the package name
  echo "${package_name}"
done


# for app_id in $(curl -s "https://play.google.com/store/apps/category/${category}" | grep -o 'href="/store/apps/details?id=[^"]*"' | awk -F= '{print $2}' | sed 's/\"//g' | grep -v "games" | head -n "${num_apps}")
# do
#   # Get the package name
#   package_name=$(echo "${app_id}" | awk -F'=' '{print $2}')

#   # Print the package name
#   echo "${package_name}"
# done

# Initialize the counter
#count=0
#https://play.google.com/store/apps/category/HEALTH_AND_FITNESS/
# Loop through the top apps in the specified category
#for app_id in $(curl -s "https://play.google.com/store/apps/category/${category}" | grep -o 'href="/store/apps/details?id=[^"]*"' | awk -F= '{print $2}' | sed 's/\"//g' | head -n "${num_apks}")

do
  # Get the package name, version, and filename
  package_name=$(echo "${app_id}" | awk -F'.' '{print $NF}')
  version=$(curl -s "https://play.google.com/store/apps/details?id=${app_id}" | grep -o "Current Version</div><div class=\"BgcNfc\">[^<]*" | awk -F'>' '{print $2}')
  filename="${package_name}_${version}.apk"

  # Download the APK file
  wget -q "https://apkpure.com/apk/${package_name}/download?from=details" -O "${filename}"

  # Record the filename, package name, and version to the output file
  echo "${filename},${app_id},${version}" >> "${output_file}"

  # Increment the counter
  count=$((count + 1))

  # Print a status message
  echo "Downloaded APK ${count} of ${num_apks}: ${filename}"
done


#https://d.apkpure.com/b/APK/com.nextdoor?version=latest
