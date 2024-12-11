export function CurrentState(props)  {

    console.log("CurrentState: email=" + props.email );
    console.log("CurrentState: email=" + props.states );
    return(
        <><h1>{props.email} and {props.states}</h1></>
    )

}
