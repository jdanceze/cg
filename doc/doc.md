# Background
- Server: 10.0.104.137
- username: pattarakritr
- password: 
- All of the mount volume when starting the container should be `-v /mnt/hdd1/pattarakritr/java:/workspace`. Because all of the script are stored in `/mnt/hdd1/pattarakritr/java` of the local machine and all of the container described in this document are shared the same mount volume.

# Content
- [Static Callgraph Generation](#static-callgraph-generation)
- [Get method coverage from Sapienz+ella](#get-method-coverage-from-sapienzella)
- [Generating dataset](#generating-dataset)
- [Get method coverage from Ares+ella](#get-method-coverage-from-ares)
- [Calculate combined dynamic coverage](#calculate-the-combined-dynamic-coverage)
- [Download apk](#apk-download)
- [Android emulator with GPU support](#emulator-with-gpu)
- [Line coverage](#line-coverage)
- [Resource](#resource)

# Static Callgraph Generation

## Start container from docker image

- start container from image: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_cg -it apktester/cg:v1 /bin/bash`
 

## Prerequisite
- Assume that the current container that available for Static Callgraph Generation is -> e90f6f6aed7b

## Background

- The downloaded apk files are located in several directory in /workspace/{directory name}
- These are the directory name that contain apks file. Usually, it is a category name.
```
1_newsT1234_parentT1234_photoT1234_prodT1234_shopT1
2_newsT1234_parentT1234_photoT1234_prodT1234_shopT1
personalization
comicT1234_commuT1234_datingT1234_eduT1234
enterT1234_eventT12
photography_100
comics_100
eventT3_financeT1234_foodT1
communication_100
dating_100
shoppingT234_socialT123
finance
edu_enter_event_house_lib_media
foodT234_houseT12
socialT4_sportsT1234_toolT1
art_design
food_drink
auto_100
health_fitness
sport_tool_tran_wea_auto1_auto2
auto_t300
houseT34_libT1234
auto_t400
lifestyle
toolT234_tranT123
beautyT100_beautyT200_beautyT300_beautyT400_bookT100_bookT200_bookT300
lifestyleT1234_medicalT12
tranT45_travT1234
beauty_100
travel_local_100
bookT4_bussiT1234
medicalT34_musicT1234
weaT1234
books_reference_100
medical_100
business_100
musi_new_parent_prod_shop_soci
```

- The structure of the directory is as follows: (Showing /workspace/beauty_100 as an example)
```
/workspace/beauty_100
|
- 1 .. 10 -> is a sub directory that contain apk files (10 apk files per sub directory)
|
- output -> is a directory that contain the output of the static callgraph generation <apk_name>.txt for callgraph file and (<apk_name>.log for log file)
|
- cg_new.sh -> a script to generate static callgraph
|
- spawn_screen.sh -> a script to spawn screen for cg generation
|
- log_times.txt -> a file that contain the time taken for each apk to generate the static callgraph
```

## Cg Generation steps
1. Go to /workspace/{directory name}
2. Run `spawn_screen.sh`. (For each spawn_screen.sh script, you can edit the script to set the number of sub directory that you want to generate the callgraph)
3. a screen will be spawn for each sub directory
4. After the generation is done go to /workspace
5. run `python3 find_time_from_log.py {directory name}` to find the time taken for each apk
6. The time to generate the callgraph for each apk will be saved in `/workspace/{directory-name}/log_times.txt`
7. Output of the static callgraph and generation log will be saved in `/workspace/{directory-name}/output/`


### Example for static cg genaration for apk inside comics_100 directory(e90f6f6aed7b)
Attach to the container by running `docker attach e90f6f6aed7b`
```
cd /workspace/comics_100

./spawn_screen.sh

cd /workspace

python3 find_time_from_log.py comics_100
```

# Get method coverage from Sapienz+ella
This section will describe how to get the method coverage from Sapienz+ella.
### Environment
- Android 4.4
- Static run: Timeout is 60 minutes
- Dyanmic run: Star the timeout checking after 30 minutes then check coverage every 10 minutes. It will stop, if the coverage does not increase.
- The setting parameter for Sapienz is set as the default value in the Sapienz paper. The setting file is located at `/workspace/sapienz-d0f06c30800332bbafa7cf0ed32379fe1abcad5d/settings.py`

## Start container from docker image
- start container from image: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_sap_1 -it --gpus all --device /dev/kvm apktester/android:v5 /bin/bash`
- You can start multiple container from the same image. I have create 5 different sets of script to support 5 running instance of Sapienz+ella, so you can start 5 container to run 5 Sapienz+ella.

## Prerequisite
- The list of current compatible apk are located in `/mnt/hdd1/pattarakritr/java/compatible_apks.txt` or in the docker container that mount with `-v /mnt/hdd1/pattarakritr/java:/workspace` it is located in `/workspace/compatible_apks.txt` or `compatible_apks.txt` in this document directory.
- Currently There are 5 instance of container that can run Sapienz+ella. The container id are as follows:
    - container 1 -> 90bd08999126
    - container 2 -> 98fec4845c1d
    - container 3 -> 6073953ab577
    - container 4 -> aa05d635036a
    - container 5 -> 367f5d3b00f1
- Each container can run 1 individual instance of Sapienz+ella to help speed up the process
- You can feed the list of apks that you want to run for each container
- all of the /workspace of the containers are mounted to the same location of the host machine
- So I created the running script for each container number
- The number in this case is 1 to 5
- Please use the same number when running the set of scripts
- For `./run_dynamic1.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master/ella-out`
- other (2-4) `./run_dynamic{number}.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master{number}/ella-out`
- `list_of_apk.txt` should contain 15 to 20 apks for each run. I have tried more than that (>20apks) but when initiate the emulator it will fail. So I suggest that you should run 15 to 20 apks for each run then restart the container and run the next 15 to 25 apks.

## Background
- `{list_of_apk.txt}` should contain the list of {path-to-apk} that you want to run. The example content of list_of_apk.txt:
```
/workspace/edu_enter_event_house_lib_media/52/com.hdmovies2022.free.movies.hd.cik2.apk
/workspace/edu_enter_event_house_lib_media/41/com.tonewdigital.myapplication.apk
/workspace/edu_enter_event_house_lib_media/48/app.apk.backup.apk
/workspace/edu_enter_event_house_lib_media/48/codematics.universal.tv.remote.control.apk
/workspace/edu_enter_event_house_lib_media/48/insignia.fire.tv.remote.apk
/workspace/edu_enter_event_house_lib_media/24/com.bpva.video.player.free.apk
```

- <b><u>output of ella:</u></b> The coverage data are stored inside a subdirectory of /ella-out directory. The name of the subdirectory is derived from {path-to-apk}. Currently, coverage data are stored in files coverage.dat and covids. covids contain the list of method signatures; index of a method is its identifier. coverage.dat contains the list of method identifiers that were executed.
<!-- The files detail of ella output are as follows:
```
coverage.dat.* -> is the coverage file for each apk, it is the index of the method in the covids file
covids -> is the file that contain the method name, the index is the line number
``` -->
- The example of the output of the `ella_coverage_new.txt`: *This file will be further used to genarate the dataset.

The format of ella_coverage_new.txt content: (seperate by comma, each line is for each apk)
```
subdirectory_name_from_ella, path_of_ella_output_directory_for_each_apk, method_coverage percentage, ( total_covered_method / total_method )
```
example of ella_coverage_new.txt:
```
15c6a029a8ce6ca7242bcdec5ee084c650d5062e73ca16392418accf568305a3,/workspace/ella-master4/ella-out/15c6a029a8ce6ca7242bcdec5ee084c650d5062e73ca16392418accf568305a3/,80.0,( 108 / 135 )
_workspace_finance_10_com.autostart.apk,/workspace/ella-master5/ella-out/_workspace_finance_10_com.autostart.apk/,79.74683544,( 63 / 79 )
```


## Running Sapienz+ella
*Noted: If you want to run with out the dynamic timeout and stick to the static timeout you can change the `run_dynamic{number2-4}.sh` to `run{number2-4}.sh` (only for run_dynamic1.sh to run.sh)*
1. Go to /workspace
2. Create a screen session by running `screen`
3. Run `./run_dynamic{number}.sh {path to list_of_apk.txt}` (I suggest that each of the container number can run the according number. For example container 1 -> 90bd08999126 should run ./run_dynamic1.sh, container 2 -> 98fec4845c1d should run ./run_dynamic2.sh, and so on)
4. When the process finish, the output of the method coverage will be saved in /workspace/ella_master or /workspace/ella_master{number} (depending on which script you run)
5. To retrieve the total of method coverage for ran apk, you can go to `/workspace` then run `/get_coverage.sh {number}`
6. The output of the total method coverage will be saved in `/workspace/ella_master/ella-out/ella_coverage_new.txt` or `/workspace/ella_master{number}/ella-out/ella_coverage_new.txt` (depending on which script you run)

### Example for running Sapienz+ella for container 1 (90bd08999126)
Attach to the container by running `docker attach 90bd08999126`
```
cd /workspace

./run_dynamic1.sh /workspace/target/test7.txt

./get_coverage.sh 1
```

# Generating dataset
This section will explain how to generate the dataset from the output of Sapienz+ella given the `ella_coverage_new.txt` file from the Sapienz+ella or Ares+ella step.

We parse static callgraph from soot static callgraph and dynamic callgraph from ella to the format required by Autopruner. First we use static cg generated from soot convert to csv format that contain ther method signeture of caller and callee. Then we add a label indicate that for each method whether it is executed or not. This information we retrieved from ella. We convert the method signater format from ella to soot format then checked if ther caller and callee method is executed or not. If it is executed we set the label to 1 otherwise 0. Next we add extra features to the this callgraph by using the extra feature generation script the same as Autopruner use. Lastly, Autopruner require the source code for each method so we create a script to lookup the source code for each method signature then put it to the dataset.
## Start container from docker image
- start container from image: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_and_gpu -it --gpus all --device /dev/kvm apktester/android:v5 /bin/bash`

*Noted: This docker image is the same image that use in the Sapienze+ella step, so you can use the same container to run this task*

## Prerequisite
- Container that available for Dataset Generation is -> 90bd08999126
- The original source code of the dataset generation script is at https://github.com/jdanceze/cg_parser
## Background

- There are 5 instance of cg_parser directory that can be use to run. You can start multiple screen session to run each set of cg_parser script.
- The working directory located in /workspace/data_prep/cg_parser{1..5}
- Eace cg_parser directory can run 1 instance of cg_parser so the use can given the seperate list of apk to run for each cg_parser directory
- The output of the dataset will be saved in /workspace/data_prep/cg_parser{1..5}/data/{apk_name}
- The detail of the output of the dataset is as follows:

    - combinationWithExtraFeatures.csv: a final static call-graph use for training (include extra features)
    - combinationWithExtraFeatures_label.csv: a final dynamic call-graph use for training (include extra features, label field)
    - raw_cg.csv: raw static call-graph in csv format directly parse from soot static call-graph
    - refine_cg.csv: a post-processed static call-graph from raw_cg.csv before generating extra feature (no extra features)
    - labeled_cg.csv: a dynamic call-graph before process to generate extra feature (no extra features, label field)
    - sig_to_func.csv: the method signature and its correlated source code  
- The script require `ella_name_map.txt` file to run. The file is the mapping of the apk path and its corresponding ella output directory name. So if you has additionla apk that does not located in the mapper you can run `/workspace/ella_name_mapper.sh {list of apk} 1`
- The location of the current `ella_name_map.txt` file is in `/workspace/data_prep/cg_parser1/ella_name_map.txt`
- The example content of the `ella_name_map.txt` file: ([apk path, ella output directory name],seperate by comma, each line is for each apk)
```
/workspace/personalization/5/com.zhekapps.leddigitalclock.apk,_workspace_personalization_5_com.zhekapps.leddigitalclock.apk
/workspace/personalization/5/com.digitalcosmos.shimeji.apk,_workspace_personalization_5_com.digitalcosmos.shimeji.apk
```

## Running CG Parser
1. Go to /workspace/data_prep/cg_parser{1..5}
2. Create a screen session by running `screen`
3. Run `init_resource.sh {path to ella_coverage_new.txt file}`
4. The output of the dataset will be saved in /workspace/data_prep/cg_parser{1..5}/data/{apk_name}

### Example for running CG Parser for cg_parser1

```
cd /workspace/data_prep/cg_parser1

screen

./init_resource.sh /workspace/data_prep/target/40.txt
```
# Get method coverage from Ares

### Environment
- Android 12
- Timeout for each apk is set to 60 minutes
## Start container from docker image
- start container from image: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_ares_1 -it --device /dev/kvm apktester/ares:v2 /bin/bash`

- You can start multiple container from the same image. I have create 5 different sets of script to support 5 running instance of Ares+ella, so you can start 5 container to run 5 Ares+ella.

## Prerequisite
- Currently There are 5 instance of container that can run Ares+ella. The container id are as follows:
    - container 1 -> e626f2cd89e5
    - container 2 -> e597d1f2de07
    - container 3 -> 52d85aff8147
    - container 4 -> ae02085fb627
    - container 5 -> 7e69e1917c5f
- Each container can run 1 individual instance of Ares+ella to help speed up the process
- You can feed the list of apks that you want to run for each container
- So I created the running script for each container number
- The number in this case is 1 to 5
- Please use the same number when running the set of scripts
- Every ares{number}.sh script has it corelated ella output directory like `ares{number}.sh` -> `ella_master{out_number}`
- For `./ares1.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master6/ella-out`
- For `./ares2.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master7/ella-out`
- For `./ares3.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master8/ella-out`
- For `./ares4.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master9/ella-out`
- For `./ares5.sh` The <b><u>output of ella</u></b> is in `/workspace/ella_master10/ella-out`


## Background (Quite The same as the background of Sapientze+ella)
- `{list_of_apk.txt}` should contain the list of {path-to-apk} that you want to run. The example content of list_of_apk.txt:
```
/workspace/edu_enter_event_house_lib_media/52/com.hdmovies2022.free.movies.hd.cik2.apk
/workspace/edu_enter_event_house_lib_media/41/com.tonewdigital.myapplication.apk
/workspace/edu_enter_event_house_lib_media/48/app.apk.backup.apk
/workspace/edu_enter_event_house_lib_media/48/codematics.universal.tv.remote.control.apk
/workspace/edu_enter_event_house_lib_media/48/insignia.fire.tv.remote.apk
/workspace/edu_enter_event_house_lib_media/24/com.bpva.video.player.free.apk
```

- <b><u>output of ella:</u></b> The coverage data are stored inside a subdirectory of /ella-out directory. The name of the subdirectory is derived from {path-to-apk}. Currently, coverage data are stored in files coverage.dat and covids. covids contain the list of method signatures; index of a method is its identifier. coverage.dat contains the list of method identifiers that were executed.

- The latest coverage output file after merging multiple coverage.dat file (step 8) for a apk will be saved as `coverage.dat.2025` file

- The example of the output of the `ella_coverage_new.txt`: *This file will be further used to genarate the dataset.
The format of ella_coverage_new.txt content: (seperate by comma, each line is for each apk)
```
subdirectory_name_from_ella, path_of_ella_output_directory_for_each_apk, method_coverage percentage, ( total_covered_method / total_method )
```
example of ella_coverage_new.txt:
```
15c6a029a8ce6ca7242bcdec5ee084c650d5062e73ca16392418accf568305a3,/workspace/ella-master4/ella-out/15c6a029a8ce6ca7242bcdec5ee084c650d5062e73ca16392418accf568305a3/,80.0,( 108 / 135 )
_workspace_finance_10_com.autostart.apk,/workspace/ella-master5/ella-out/_workspace_finance_10_com.autostart.apk/,79.74683544,( 63 / 79 )
```



## Running Ares+ella
1. Create a screen session by running `screen`
2. Go to ares directory `cd /workspace/ARES`
3. Activate the virtual environment by running `source venv/bin/activate`
4. Go `cd /rl_interaction`
5. Run `/workspace/ares{number}.sh {path to list_of_apk.txt}`
6. When the process finish, the output of the method coverage will be saved in `ella_master{out_number}` (depending on which script you run)
7. Go to the ella output directory `cd /workspace/ella_master{out_number}`
8. When running Ares, multiple coverage.dat file are generated so we need to combine multiple coverage.dat in to one file by running `./combind_cov.sh` as `coverage.dat.2025` file
9. Calculate the total method coverage by running `./cal_coverage_ares.sh {path to list_of_apk.txt}` *Noted: {path to list_of_apk.txt} should be the same as the one you use in step 3
10. To retrieve the total of method coverage for ran apk, you can go to `cd /workspace` then run `/get_coverage.sh {out_number}`
11. The output of the total method coverage will be saved in `/workspace/ella_master{out_number}/ella-out/ella_coverage_new.txt` (depending on which script you run)

### Example for running Ares+ella for container 1 (e626f2cd89e5)
Attach to the container by running `docker attach e626f2cd89e5`
```
screen

cd /workspace/ARES

source venv/bin/activate

cd /rl_interaction

/workspace/ares1.sh /workspace/target/test7.txt

cd /workspace/ella_master6

./combind_cov.sh

./cal_coverage_ares.sh /workspace/target/test7.txt

cd /workspace

./get_coverage.sh 6
```

# Calculate the combined dynamic coverage
This section describe how to calculate the combined coverage from the output of Sapienze+ella and Ares+ella

## Start container from docker image
- start container from image: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_and_gpu -it --gpus all --device /dev/kvm apktester/android:v5 /bin/bash`

*Noted: This docker image is the same image that use in the Sapienze+ella step, so you can use the same container to run this task*

## Background 
- The combined coverage output for a apk will be saved as `coverage.dat.2025` file
- The combined coverage output for all apks will be saved as `ella_coverage_new.txt` file

*Output files and format from ella are the same as the Sapienz+ella output since we still use ella to calculate the coverage*

- `result.txt` file is the output of the comparison between Sapienz+ella and Ares+ella. "NONE" means that the apk is missing from Ares+ella or Sapienz+ella
- the format of `result.txt` file: (seperate by comma, each line is for each apk)
```
subdirectory_name_from_ella, path_of_ella_output_directory_for_each_apk_from_Sapienz, Sapienz method_coverage percentage, Sapienz ( total_covered_method / total_method ),path_of_ella_output_directory_for_each_apk_from_Ares, Ares method_coverage percentage, Ares ( total_covered_method / total_method ),path_of_ella_output_directory_for_each_apk_from_Combination, Combination method_coverage percentage, Combination ( total_covered_method / total_method )
```
- example of `result.txt` file:
```
36b8015a246fd49ac851a24110f3a53bbce96220389fe5a58b49be940fed5a44,/workspace/ella-master5/ella-out/36b8015a246fd49ac851a24110f3a53bbce96220389fe5a58b49be940fed5a44/,10.4947526237, ( 140 / 1334 ),/workspace/ella-master10/ella-out/36b8015a246fd49ac851a24110f3a53bbce96220389fe5a58b49be940fed5a44/,8.99550224888, ( 120 / 1334 ),/workspace/coverage/dir/36b8015a246fd49ac851a24110f3a53bbce96220389fe5a58b49be940fed5a44/,10.4947526237, ( 140 / 1334 )
46aed462491c54043e05268ca6cd1313ffecdd5e0bb7c6d1a80bc378c3b4d1f7,/workspace/ella-master5/ella-out/46aed462491c54043e05268ca6cd1313ffecdd5e0bb7c6d1a80bc378c3b4d1f7/,15.7061719046, ( 4148 / 26410 ),NONE,NONE,NONE,/workspace/coverage/dir/46aed462491c54043e05268ca6cd1313ffecdd5e0bb7c6d1a80bc378c3b4d1f7/,15.7061719046, ( 4148 / 26410 )
```

## Running the script to calculate the combined coverage
1. Go to coverage directory `cd /workspace/coverage`
2. Run `./cal_comb_coverage.sh {Sapienz+ella output directory} {Ares+ella output directory} {path to list_of_apk.txt}` to process the output of Sapienz+ella and Ares+ella
3. Run `./get_coverage_comb.sh`to get the combined coverage information file `ella_coverage_new.txt` like in the previous step
4. The previous two scripts will process the output files to `dir` directory so you change the `dir` directory name to the name of the any thing you desire `mv dir/ {anyname}_dir`
5. Run `python3 comb_result.py {Sapienz+ella output directory} {Ares+ella output directory} {path to ella_coverage_new.txt} {path to compare output result.txt file}` to compare the coverage between Sapienz+ella and Ares+ella the result of the comparison will be saved as result.txt in the directory that you specify in the last argument


### Example for calculating dynamic method coverage (90bd08999126)
*Noted: `dir` directory is the output directory so you can remove it first*

```
rm -r dir/

./cal_comb_coverage.sh /workspace/ella-master4/ella-out/ /workspace/ella-master9/ella-out/ /workspace/target/616_630.txt

./get_coverage_comb.sh

mv dir/ 616_630_dir

python3 comb_result.py /workspace/ella-master4/ella-out/ella_coverage_new.txt /workspace/ella-master9/ella-out/ella_coverage_new.txt /workspace/coverage/616_630_dir/ella_coverage_new.txt /workspace/coverage/616_630_dir/result.txt
```

# APK download
This section will describe how I download the apk.

Background:
- For downloading apk using `crawler2.py` script it is Mac OS or Linux which has a screen GUI because `webbrowser.open()` that use in the script will open the browser to download the apk.

- The full list of apk that I have download are located in `/mnt/hdd1/pattarakritr/java/apk_location.txt` or in the docker container that mount with `-v /mnt/hdd1/pattarakritr/java:/workspace` it is located in `/workspace/apk_location.txt` or `apk_location.txt` in this document directory.


## Detail
- Get the package name from two website then download according to the package name retrieved
    1. https://www.androidrank.org/
    
        For https://www.androidrank.org/ I use the `package_craw.py` script to reteive the list of apk for each category. You can edit `category = "WEATHER"`in the script to set the target category that want to retreive the package list and set `target = "weather"` to set the name of package list file out. Then you can use `python3 crawler2.py {package list file.txt}` to download the apk from the list of package name. It use 
    apkpure.com to download the apk. 
    
        *For https://www.androidrank.org/ I have retrieve and download all apk for each category under applications section in the website*

    2. https://www.appbrain.com/stats/google-play-rankings/top_free/

        For https://www.appbrain.com You can use `python3 crawler.py` to retrieve the apk for each category. You can edit url in the crawler.py file to fetch for each page. Then you can use `python3 crawler2.py {package list file.txt}` to download the apk from the list of package name.

        *For https://www.appbrain.com/ I have retrieve and download all apk for each category under Top free and United States section in the website*

    

# Emulator with GPU
 (Face problem)
- Start the container with `-gpus all --device /dev/kvm` but when start the emulator with `-gpu -host` it is fail.

    - run: `emulator -writable-system -avd 19_86 -gpu -no-accel -no-audio -no-boot-anim -no-snapshot-save -no-window -skip-adb-auth -verbose -wipe-data`
    - error:

    ```
        ERROR   | OpenGLES emulation failed to initialize. Please consider the following troubleshooting steps:

    1. Make sure your GPU drivers are up to date.

    2. Erase and re-download the emulator ($ANDROID_SDK_ROOT/emulator).

    3. Try software rendering: Go to Extended Controls > Settings > Advanced tab and change "OpenGL ES renderer (requires restart)" to "Swiftshader".

    Or, run emulator from command line with "-gpu swiftshader_indirect". 4. Please file an issue to https://issuetracker.google.com/issues?q=componentid:192727 and provide your complete CPU/GPU info plus OS and display setup.
    FATAL   | Emulator: exiting becase of the internal error 'OpenGLES emulation failed to initialize. Please consider the following troubleshooting steps:

    1. Make sure your GPU drivers are up to date.

    2. Erase and re-download the emulator ($ANDROID_SDK_ROOT/emulator).

    3. Try software rendering: Go to Extended Controls > Settings > Advanced tab and change "OpenGL ES renderer (requires restart)" to "Swiftshader".

    Or, run emulator from command line with "-gpu swiftshader_indirect". 4. Please file an issue to https://issuetracker.google.com/issues?q=componentid:192727 and provide your complete CPU/GPU info plus OS and display setup.
    '
    Aborted (core dumped)

    ```
    - Then try running with `-gpu swiftshader_indirect` it can run but the result is the same with running without `-gpu swiftshader_indirect`.

- Try routing the emulator inside the docker container to display on the server host machine but cannot connect.
    - on the server host run: `docker run --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_emu -p 5038:5555 -it --gpus all --device /dev/kvm apktester/ares:v1 /bin/bash`
    - Start the emulator inside the container
    - On the host server grep the ip adress of the container by running `docker inspect db5f665d92a3 | grep IPAddress`
    - Use the ip address to connect to the emulator by running `adb connect 172.17.0.25:5555`
    - Got error: `failed to connect to '172.17.0.25:5555': Connection refused`


- Try routing the display from docker container to display the emulator screen inside the docker container.
    - Start the container with: ` docker run -e DISPLAY=202.161.34.104:0.0 --user=root -v /mnt/hdd1/pattarakritr/java:/workspace --name pattarakrit_and_test -it --gpus all --device /dev/kvm apktester/android:v5 /bin/bash`
    - In side the container run: `export DISPLAY=202.161.34.104:0.0`
    - Got the same error
    ```
        ERROR   | OpenGLES emulation failed to initialize. Please consider the following troubleshooting steps:

    1. Make sure your GPU drivers are up to date.

    2. Erase and re-download the emulator ($ANDROID_SDK_ROOT/emulator).

    3. Try software rendering: Go to Extended Controls > Settings > Advanced tab and change "OpenGL ES renderer (requires restart)" to "Swiftshader".

    Or, run emulator from command line with "-gpu swiftshader_indirect". 4. Please file an issue to https://issuetracker.google.com/issues?q=componentid:192727 and provide your complete CPU/GPU info plus OS and display setup.
    FATAL   | Emulator: exiting becase of the internal error 'OpenGLES emulation failed to initialize. Please consider the following troubleshooting steps:

    1. Make sure your GPU drivers are up to date.

    2. Erase and re-download the emulator ($ANDROID_SDK_ROOT/emulator).

    3. Try software rendering: Go to Extended Controls > Settings > Advanced tab and change "OpenGL ES renderer (requires restart)" to "Swiftshader".

    Or, run emulator from command line with "-gpu swiftshader_indirect". 4. Please file an issue to https://issuetracker.google.com/issues?q=componentid:192727 and provide your complete CPU/GPU info plus OS and display setup.
    '
    Aborted (core dumped)

    ```

- Confusion with xauthority https://docs.citrix.com/en-us/linux-virtual-delivery-agent/1912-ltsr/configuration/configure-xauthority.html to manage the display for routing to docker container.

# Line coverage
(Face problem)
## Background
- Using ACVtool https://github.com/pilgun/acvtool

## Using ACVtool with Sapienz
- Sapienz can run with android version 4.4
- Following the acvtool instruction in github. When calling `acv start` it error happend as following
```
root@e626f2cd895:/workspace/acvtool# python acvtool.py start com.rvappstudios.magnifyingglass
WARNING: linker: libdvm.so has text relocations. This is wasting memory and is a security risk. Please fix.
Operation not allowed: java.lang. SecurityException: Can't change android-permission.READ_EXTERNAL_ STORAGE. It is required by the application
WARNING: linker: libdvm.so has text relocations. This is wasting memory and is a security risk. Please fix.
Operation not allowed: java.lang. SecurityException: Can't change android permission.WRITE_EXTERNAL_ STORAGE. It is required by the application
```
- The logcat of the error is as follows:
```
D/AcvInstrumentation ( 2260): onCreate: Obtained instrumentation intent: Bundle [marcelledData.dataSize=52]
W/System.err( 2260): java.io.IOException: open failed: EROFS (Read-only file system)
W/System.err 2260):
at java. io. File. createNewFile(File. java: 946)
W/System.err ( 2260):
at tool. ac.AcvInstrumentation.onCreate(acvinstrumentation.java:99)
W/System.err( 2260):
at android. app. ActivityThread. handleBindApplication (ActivityThread. java: 4335)
W/System.err( 2260):
at android.app.ActivityThread. access$1500 (ActivityThread. java: 135)
W/System.err ( 2260) :
at android.app. ActivityThread$H. handleMessage (ActivityThread. java: 1256)
```
- The problem may come from `/mnt/sdcard` may not been writable so I change the code to use `/system/` which can be wirtable. But the error still happen as the same.

## Using ACVtool with ARES
- Runnning with android 8
- Can work perfectly when running on the emulator with android 8 but when adding the ACVtool pipeline to ARES the ACVtool cannot work.
- I Add the following code to `test_application.py` in ARES to run ACVtool. However right after the application is launched the ACVtool is terminated.
```python
os.system(f'{adb_path} -s {udid} install -t -r {application}')
os.system("python2 /workspace/acvtool/acvtool.py install " + "/workspace/ARES/rl_interaction/apk_dir/com.rvappstudios.magnifyingglass.apk/instr_com.rvappstudios.magnifyingglass.apk")
print("after install")
os.system("screen -dmS cov bash -c 'python2 /workspace/acvtool/acvtool.py start com.rvappstudios.magnifyingglass | tee /workspace/log_instru.txt'")
os.system("screen -dmS log bash -c 'adb logcat | tee /workspace/log_android.txt'")
print("after instru")
time.sleep(10)
result = subprocess.run(
    [adb_path, "shell", "su", "0", "find", "/data/data/", "-type", "d", "-name", f'"{my_package}*"'],
    capture_output=True)
package = result.stdout.decode('utf-8').strip('\n').rsplit('/')[-1]

```
- The full logcat is in `log_acv.txt` file in this doc directory


# Resource
- Time to generate static callgraph. https://docs.google.com/spreadsheets/d/1HINFH7POIZPFMCaorr6xKJI3fEQhnnJvIyzLK0_gEVk/edit?usp=sharing (Static cg time sheet)
    - Did not set any timeout for static cg generation

- Sapienze Coverage + list of apk ran by Sapienz. https://docs.google.com/spreadsheets/d/1lMMpjPRPNUUbfL0EgPWKQDlJbmKuylCqOEhtKNWjKRY/edit?usp=sharing
    - Android 4.4
    - Dyanmic run: Start timeout checking after 30 minutes then check coverage every 10 minutes. It will stop, if the coverage does not increase.

- Ares Coverage + list of apk ran by Ares. https://docs.google.com/spreadsheets/d/15o1ZQEr8Wk4XQIdcCg2xClaoQ6Yaa6oQHDEMLc0eZCY/edit?usp=sharing
    - Android 12
    - Timeout for each apk is set to 60 minutes

- Dynamic Coverage Comparison. https://docs.google.com/spreadsheets/d/17lOGAP8PDgeudMZ_UO1TyahbWgnqqEF5dC3WhMqWPNo/edit?usp=sharing
- Combined Coverage. https://docs.google.com/spreadsheets/d/1A9HNk5hfu1v2ZkNCaXUvfOnvQsCi4mnZdCcsj5cqKBc/edit?usp=sharing
- List of all apk: `apk_location.txt` in this doc directory
- List of all apk that can run with Sapienz (or android 4.4): `compatible_apks_android4.txt` in this doc directory