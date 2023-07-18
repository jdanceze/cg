def read_file(filename):
    result = {}
    with open(filename, 'r') as file:
        for line in file:
            key, value = line.strip().split(',', 1)
            result[key] = value
    return result

def join_files(sap_file, ares_file, comb_file, output_file):
    sap_data = read_file(sap_file)
    ares_data = read_file(ares_file)
    comb_data = read_file(comb_file)

    with open(output_file, 'w') as file:
        for key in comb_data:
            sap_value = sap_data.get(key, 'NONE')
            ares_value = ares_data.get(key, 'NONE')
            comb_value = comb_data[key]
            if sap_value == 'NONE':
                sap_value = 'NONE,NONE,NONE'
            if ares_value == 'NONE':
                ares_value = 'NONE,NONE,NONE'
            line = f"{key},{sap_value},{ares_value},{comb_value}\n"
            file.write(line)

# Example usage:
sap_file = 'sap.txt'
ares_file = 'ares.txt'
comb_file = 'comb.txt'
output_file = 'result.txt'
join_files(sap_file, ares_file, comb_file, output_file)
