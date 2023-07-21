import re
import sys
import requests


# fetch the HTML content
url = 'https://www.appbrain.com/stats/google-play-rankings/top_free/dating/us'
response = requests.get(url)
html_content = response.text
output = "package_list"

package_names = set()
for match in re.findall(r'/app/[^/]+/([^"]+)', html_content):
    package_names.add(match)

if package_names:
    print('Package names found:', package_names)
else:
    print('Package names not found.')

print("Total: ", len(package_names))

#package_names = ["com.picso.android","how.draw.cutefood"]
#,"com.circular.pixels","com.delgeo.desygner","me.bazaart.app"
#write package names to txt file

with open(f"{output}.txt", "w") as file:
    for package_name in package_names:
        file.write(f"{package_name}\n")

