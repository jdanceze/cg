import re
import sys
import requests
from google_play_scraper import app
from bs4 import BeautifulSoup
import json
import time
import wget
from selenium import webdriver
import subprocess
import webbrowser

#target = sys.argv[1]
#page_num = 48
category = "MUSIC_AND_AUDIO"
target = "music_audio"

#read old package names from txt file
old_package_names = []
with open(f"package/{target}.txt", "r") as file:
    for line in file:
        old_package_names.append(line.strip())

package_names = set()
for page_num in range(2, 49):
    print(f"Page {page_num}")
    url = f"https://www.androidrank.org/android-most-popular-google-play-apps?start={page_num}1&sort=0&price=all&category={category}"
    response = requests.get(url)
    html_content = response.text
    for match in re.findall(r'/application/[^/]+/([^"]+)', html_content):
        if(match not in old_package_names):
            package_names.add(match)

    if package_names:
        print('Package names found:', package_names)
    else:
        print('Package names not found.')

print("Total: ", len(package_names))


with open(f"package/new/{target}.txt", "w") as file:
    for package_name in package_names:
        file.write(f"{package_name}\n")

# #read package names from txt file
# package_names = []
# with open(f"package/{target}.txt", "r") as file:
#     for line in file:
#         package_names.append(line.strip())

# #print(package_names)
# for package_name in package_names:
#     print('Fetching app details... ', package_name)
#     try:
#         result = app(package_name)
#         latest_version = result['version']

#         #print(f"App name: {result['title']}")
#         print(f"Latest version: {latest_version}\n")

#         download_url = f"https://d.apkpure.com/b/APK/{package_name}?version=latest"
#         webbrowser.open(download_url)
#         time.sleep(5)
#         # r = requests.get(download_url, allow_redirects=False)
#         # headers = r.headers
#         # print(headers)
#         # open(f"{package_name}.apk", 'wb').write(r.content)
#         #append package name, app name, latest version, download url to csv file
#         with open(f"{target}.txt", "a") as file:
#             file.write(f"{package_name},{latest_version},{download_url}\n")
#     except:
#         print("Error: ", package_name)