import csv

input_file = 'ZIP_DETAIL-Table 1.csv'
output_file = 'ZIP_DETAIL-Table 1_filtered.csv'

with open(input_file, mode='r', newline='') as infile, open(output_file, mode='w', newline='') as outfile:
    reader = csv.reader(infile)
    writer = csv.writer(outfile)

    # Write the header
    writer.writerow(['AREA_NAME', 'ZIPCODE', 'STATE'])

    # Skip the header row in the input file
    next(reader)

    for row in reader:
        # Write the selected columns to the output file
        writer.writerow([row[0], row[5], row[9]])