import {Button, Label, Select} from "flowbite-react";

export default function Region({callback}) {
    const states = [
        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
        "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
        "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
        "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
        "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
        "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia",
        "Wisconsin", "Wyoming"
    ];

    return (

        <div>
            <form id="registerform" className="flex max-w-md flex-col gap-4"
                  onSubmit={(e) => {
                      e.preventDefault();
                      const selectedStates = Array.from(e.target.countries.selectedOptions).map(option => option.value);
                      console.log("states: " + selectedStates);
                      callback(selectedStates);
                  }}>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <Label htmlFor="countries" value="Add favorites from your favorite state(s)"/>
                    </div>
                    <Select id="countries" required multiple >
                        <option value="none" key="none">None</option>
                        {states.map((state) => (
                            <option value={state} key={state}>{state}</option>
                        ))}
                    </Select>
                </div>
                <Button type="submit">Continue</Button>
            </form>
        </div>
    );
}
