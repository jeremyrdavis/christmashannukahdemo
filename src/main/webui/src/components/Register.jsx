import {Button, Label, Select, TextInput} from "flowbite-react";

export default function Register({updateWorkflow}) {
    return (
        <div>
            <form id="registerform" className="flex max-w-md flex-col gap-4"
                  onSubmit={(e) => {
                      e.preventDefault();
                      const emailAddress = e.target.email.value;
                      const celebration = e.target.celebration.value;
                      console.log("emailAddress: " + emailAddress + ", celebration: " + celebration);
                      updateWorkflow(emailAddress, celebration);
                  }}>
                <div>
                    <div className="mb-2 block">
                        <Label htmlFor="email" value="Enter your email to get started"/>
                    </div>
                    <TextInput id="email" type="email" placeholder="name@flowbite.com" required/>
                </div>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <Label htmlFor="celebration" value="Christmas or Hannukah"/>
                    </div>
                    <Select id="celebration" required>
                        <option value="CHRISTMAS">Christmas</option>
                        <option value="HANNUKAH">Hannukah</option>
                        <option value="FESTIVUS">Festivus</option>
                    </Select>
                </div>
                <Button type="submit">Let's Plan My Party!</Button>
            </form>
        </div>
    );
}
