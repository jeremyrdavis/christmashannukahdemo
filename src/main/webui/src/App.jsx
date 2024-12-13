import { useState } from "react";
import { Flowbite } from "flowbite-react";
import Menu from "./components/Menu.jsx";
import Region from "./components/Region";
import Register from "./components/Register";
import Invitation from "./components/Invitation.jsx";

const menuUrl = 'http://localhost:8080/static/thanksgiving-menu-01.png';
const invitationUrl = 'http://localhost:8080/api/ai/invitation';
const getMenuUrl = 'http://localhost:8080/api/ai/menu';

function App() {

        const [step, setStep] = useState(1);
        const [email, setEmail] = useState("");
        const [celebration, setCelebration] = useState("");
        const [stateCodes, setStateCodes] = useState([]);
        const [menu, setMenu] = useState();
        const [invitation, setInvitation] = useState();

        const registerCelebration = async (emailAddress, celebration) => {
                console.log("received emailAddress: " + emailAddress + ", celebration: " + celebration);
                setEmail(emailAddress);
                setCelebration(celebration);
                setStep(2);
        }

        const updateStateCodes = async (s) => {
                console.log("updateStateCodes: states=" + s);
                console.log("getMenu: states=" + s);
                let payload = JSON.stringify({email : email, holiday: celebration, stateCodes: s});
                console.log("payload: ", payload);
                const response = await fetch(getMenuUrl, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json'
                        },
                        body: payload
                });
                const data = await response.json();
                console.log(data);
                setMenu(data);
                setStep(3);
        }

        const createInvitation = async () => {
                console.log("createInvitation");
                let createInvitationCommand = {
                        menuRecord: menu
                }
                console.log("createInvitationCommand: ", JSON.stringify(createInvitationCommand));
                const response = await fetch(invitationUrl, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Accept': 'application/json',
                        },
                        body: JSON.stringify(createInvitationCommand)
                });
                const data = await response.json();
                console.log("invitation result: " + data);
                console.log("invitation menu: " + data.menuRecord);
                setInvitation(data);
                setStep(4);
        }

        const createPdf = async () => {
                console.log("createPdf");
        }

        const logWorkflow = (msg) => {
                console.log(msg);
                console.log("email: ", email);
                console.log("stateCodes: ", stateCodes);
        }

        const getMenu = async (s) => {
        }

        return (
            <Flowbite theme={{ mode: 'dark' }}>
              <main className="flex min-h-screen items-center justify-center gap-2 dark:bg-gray-800">
                      {step === 1 && <Register updateWorkflow={registerCelebration}/>}
                      {step === 2 && <Region callback={updateStateCodes}/>}
                      {step === 3 && <Menu menu={menu} invitationCallback={createInvitation}/> }
                      {step === 4 && <Invitation invitation={invitation} celebration={celebration} invitationCallback={createPdf}/>}
                  </main>
            </Flowbite>
       );
  }

export default App;
