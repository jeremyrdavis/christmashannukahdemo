import {Button, Label, List, Select} from "flowbite-react";

export default function Invitation({ invitation, celebration, invitationCallback }) {

        console.log("invitationCallback: ", invitationCallback);
        console.log("Menu: ", invitation.thanksgivingMenu);
        console.log("Invitation URI: ", invitation.url);
        let menu = invitation.menu;

        return (
        <div>
            <form id="menuForm" className="flex max-w-md flex-col gap-4"
                  onSubmit={(e) => {
                      e.preventDefault();
                      invitationCallback();
                  }}>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <h1 className="mt-2 text-pretty text-4xl font-semibold tracking-tight text-cyan-50 sm:text-5xl">Your
                            Invitation</h1>
                        <div className="mt-6">
                            <img src={invitation.url} alt="Your Invitation" className="w-half"/>
                        </div>
                    </div>
                </div>
                <Button type="submit">
                  {
                      celebration === "Christmas" ? "Merry Christmas" :
                      celebration === "Hannukah" ? "Happy Hannukah" :
                      celebration === "Festivus" ? "Let the Feats of Strength Begin!" :
                      "Happy Holidays!"
                  }
                </Button>
            </form>
        </div>
        );
}