import {Button, Label, List, Select} from "flowbite-react";

export default function Menu({ menu: menu, invitationCallback }) {

    console.log("Menu: ", menu);
    console.log("invitationCallback: ", invitationCallback);

    return (
    <div>

            <form id="menuForm" className="flex max-w-md flex-col gap-4"
                  onSubmit={(e) => {
                      e.preventDefault();
                      invitationCallback();
                  }}>
                <div className="max-w-md">
                    <div className="mb-2 block">
                        <h1 className="mt-2 text-pretty text-4xl font-semibold tracking-tight text-cyan-50 sm:text-5xl">Your Menu</h1>

                            {menu.items.map(i =>
                                <>
                                <div className="mt-6 text-xl/5 text-cyan-50" key={i.item}>
                                {i.item}
                                </div>
                                <div className="mt-4 text/3 text-cyan-50">
                                {i.description}
                                </div>
                                </>
                            )}
                    </div>
                </div>
                <Button type="submit">Would You Like Us To Create an Invitation?</Button>
            </form>
    </div>
    );

}