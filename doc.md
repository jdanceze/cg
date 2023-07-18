# Background
- Server: 10.0.104.137
- username: pattarakritr
- password: 

# Static Callgraph Generation

## Prerequisite
- Container that available for Static Callgraph Generation is -> e90f6f6aed7b

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
2. Run `spawn_screen.sh`
3. a screen will be spawn for each sub directory
4. After the generation is done go to /workspace
5. run `python3 find_time_from_log.py {directory name}` to find the time taken for each apk
6. The time to generate the callgraph for each apk will be saved in `/workspace/{directory-name}/log_times.txt`
7. Output of the static callgraph and generation log will be saved in `/workspace/{directory-name}/output/`

# Get method coverage from Sapienz

## Prerequisite
- There are 5 instance of container that can run Sapienz+ella. The container id are as follows:
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

## Background
- `list_of_apk.txt` should contain the list of {path-to-apk} that you want to run. The example content of list_of_apk.txt:
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
```
cd /workspace
./run_dynamic1.sh /workspace/target/test7.txt
./get_coverage.sh 1
```

# Generating dataset
This section will explain how to generate the dataset from the output of Sapienz+ella given the `ella_coverage_new.txt` file from the previous step.

## Prerequisite
- Container that available for Dataset Generation is -> 90bd08999126

## Background

- There are 5 instance of cg_parser directory that can be use to run.
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
