import csv

class StateMapping:
    def __init__(self, state_code, state_name, state_region):
        self.state_code = state_code
        self.state_name = state_name
        self.state_region = state_region

    def __repr__(self):
        return f'StateMapping(state_code={self.state_code}, state_name={self.state_name}, state_region={self.state_region})'

def print_state_code_state_mapping(state_code_state_mapping_dict):
    for state_code in state_code_state_mapping_dict.keys():
        state_mapping = state_code_state_mapping_dict.get(state_code)
        outfile.write(f'put(\"{state_code}\", new PostCodeMapping(\"{state_code}\", \"{state_mapping.state_name}\", \"{state_mapping.state_region}\"));\n')


def print_state_code_region_dict(state_code_region_dict, state_code_name_dict):
    for state_code, region in state_code_region_dict.items():
        state_name = state_code_name_dict.get(state_code)
        outfile.write(f'add(new PostCodeMapping(\"{state_code}\", \"{state_name}\", \"{region}\"));\n')

def print_state_code_dict(state_code_region_dict):
    for state_code, state_name, region in state_code_region_dict.items():
        outfile.write(f'put(new PostCodeMapping(\"{state_code}\", \"{region}\"));\n')

input_file = 'ZIP_DETAIL-Table 1.csv'
output_file = 'PostCodeMapping.txt'

state_code_name_dict = {
    "AL": "Alabama", "KY": "Kentucky", "OH": "Ohio",
    "AK": "Alaska", "LA": "Louisiana", "OK": "Oklahoma",
    "AZ": "Arizona", "ME": "Maine", "OR": "Oregon",
    "AR": "Arkansas", "MD": "Maryland", "PA": "Pennsylvania",
    "AS": "American Samoa", "MA": "Massachusetts", "PR": "Puerto Rico",
    "CA": "California", "MI": "Michigan", "RI": "Rhode Island",
    "CO": "Colorado", "MN": "Minnesota", "SC": "South Carolina",
    "CT": "Connecticut", "MS": "Mississippi", "SD": "South Dakota",
    "DE": "Delaware", "MO": "Missouri", "TN": "Tennessee",
    "DC": "District of Columbia", "MT": "Montana", "TX": "Texas",
    "FL": "Florida", "NE": "Nebraska", "TT": "Trust Territories",
    "GA": "Georgia", "NV": "Nevada", "UT": "Utah",
    "GU": "Guam", "NH": "New Hampshire", "VT": "Vermont",
    "HI": "Hawaii", "NJ": "New Jersey", "VA": "Virginia",
    "ID": "Idaho", "NM": "New Mexico", "VI": "Virgin Islands",
    "IL": "Illinois", "NY": "New York", "WA": "Washington",
    "IN": "Indiana", "NC": "North Carolina", "WV": "West Virginia",
    "IA": "Iowa", "ND": "North Dakota", "WI": "Wisconsin",
    "KS": "Kansas", "MP": "Northern Mariana Islands", "WY": "Wyoming"
}

with open(input_file, mode='r', newline='') as infile, open(output_file, mode='w', newline='') as outfile:
    reader = csv.reader(infile)
    writer = csv.writer(outfile)

    state_code_region_dict = {}
    state_code_state_dict = {}

    # Skip the header row in the input file
    next(reader)

    for row in reader:
        state_code_region_dict[row[8]] = row[0]
        # Write the selected columns to the output file
        current_state_code = row[8]
        current_state_region = row[0]
        current_state_name = state_code_name_dict.get(current_state_code)
        state_mapping = StateMapping(current_state_code, current_state_name, current_state_region)
        state_code_state_dict[current_state_code] = state_mapping

    print_state_code_state_mapping(state_code_state_dict)
    #print_state_code_dict(state_code_region_dict)
    #print_state_code_region_dict(state_code_region_dict, state_code_name_dict)
    #print_state_code_state_dict(state_code_region_dict)

