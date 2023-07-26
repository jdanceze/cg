import hashlib
import sys
import os

def apk_name_to_ellaout_dir(apk_name):
	appId = apk_name.replace('/','_');
	if len(appId) > 100:
		appId = hashlib.sha256(appId).hexdigest();
	return os.path.join(os.path.expanduser("/workspace/ella-master6/ella-out"),appId)

assert len(sys.argv) == 2
apk_name = sys.argv[1]
#apk_name_to_ellaout_dir(apk_name)
#print apk_name_to_ellaout_dir(apk_name)

ellaout_dir = apk_name_to_ellaout_dir(apk_name)
print(ellaout_dir)


mapping_file = "/workspace/ella-master6/ella-out/out_mapping.txt"
with open(mapping_file, "a") as file:
	#file.write(f"{apk_name},{os.path.basename(ellaout_dir)}\n")
	file.write("{},{}\n".format(apk_name, os.path.basename(ellaout_dir)))
