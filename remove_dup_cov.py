import pandas as pd

def remove_duplicates_by_coverage(csv_file):
    # Read the CSV file into a DataFrame
    df = pd.read_csv(csv_file, delimiter='\t')

    # Remove duplicates based on the "name" column and keep the row with the highest coverage value
    df = df.sort_values('coverage', ascending=False).drop_duplicates(subset='name')

    # Save the result to a new CSV file
    output_file = 'result.csv'  # Specify the desired output file name
    df.to_csv(output_file, sep=',', index=False)

    print(f"Duplicate rows removed. Result saved to {output_file}.")

# Example usage:
csv_file = '/Users/jdanceze/Desktop/hub/cg/dup.csv'  # Specify the path to your CSV file
remove_duplicates_by_coverage(csv_file)
