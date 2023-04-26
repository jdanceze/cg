import os
import re

build_tools_path = "/Users/jdanceze/Library/Android/sdk/build-tools/33.0.2/aapt"
#build_tools_path = "aapt"
apk_dir = "/Users/jdanceze/Downloads/apk/musi_new_parent_prod_shop_soci"
android_version = "19"
i=0
num_compatible_apks = 0
compatible_apks = []

for root, dirs, files in os.walk(apk_dir):
    for filename in files:
        if filename.endswith(".apk"):
            i+=1
            print(i)
            #if i!=77:
            if True:
                apk_path = os.path.join(root, filename)


                output = os.popen(f"{build_tools_path} list -a '{apk_path}' | grep SdkVersion").read()


                target_sdk_version = None
                for line in output.splitlines():
                    if "minSdkVersion" in line:
                        target_sdk_version = line.split("=")[1].strip()

                if target_sdk_version is not None:
                    value = target_sdk_version[target_sdk_version.index("(type 0x10)") + len("(type 0x10)"):].strip()
                    if int(value,16) <= int(android_version):
                        print(f"{filename} is compatible with Android {android_version}")
                        num_compatible_apks += 1
                        compatible_apks.append(apk_path)
                    else:
                        print(f"{filename} is NOT compatible with Android {android_version}")
                else:
                    print(f"ERROR: Could not determine targetSdkVersion for {filename}")
            else:
                print(f"ERROR: Could not determine targetSdkVersion for {filename}")
with open("./compatible_apks.txt", "a") as f:
    f.write("\n".join(compatible_apks))
print(f"Found {num_compatible_apks} APKs compatible with Android {android_version}")