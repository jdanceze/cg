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

# fetch the HTML content
url = 'https://www.appbrain.com/stats/google-play-rankings/top_free/dating/us'
response = requests.get(url)
html_content = response.text


target = sys.argv[1]

# package_names = set()
# for match in re.findall(r'/app/[^/]+/([^"]+)', html_content):
#     package_names.add(match)

# if package_names:
#     print('Package names found:', package_names)
# else:
#     print('Package names not found.')

# print("Total: ", len(package_names))

# #package_names = ["com.picso.android","how.draw.cutefood"]
# #,"com.circular.pixels","com.delgeo.desygner","me.bazaart.app"
# #write package names to txt file

# with open("package/photography.txt", "w") as file:
#     for package_name in package_names:
#         file.write(f"{package_name}\n")

#read package names from txt file
package_names = []
with open(f"package/new/sub/{target}.txt", "r") as file:
    for line in file:
        package_names.append(line.strip())

#print(package_names)
for package_name in package_names:
    print('Fetching app details... ', package_name)
    try:
        result = app(package_name)
        latest_version = result['version']

        #print(f"App name: {result['title']}")
        print(f"Latest version: {latest_version}\n")

        download_url = f"https://d.apkpure.com/b/APK/{package_name}?version=latest"
        webbrowser.open(download_url)
        time.sleep(5)
        # r = requests.get(download_url, allow_redirects=False)
        # headers = r.headers
        # print(headers)
        # open(f"{package_name}.apk", 'wb').write(r.content)
        #append package name, app name, latest version, download url to csv file
        with open(f"{target}.txt", "a") as file:
            file.write(f"{package_name},{latest_version},{download_url}\n")
    except:
        print("Error: ", package_name)