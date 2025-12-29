import GuestGreeting from "./GuestGreeting";
import UserGreeting from "./UserGreeting";

const Greeting = ({flag}) =>{
    const isFlag = flag;
    /* if(isFlag) {
        return(
            <>
                <UserGreeting />
            </>
        )
    } else {
        return(
            <>
                <GuestGreeting />
            </>
        )
    } */

    {
        return isFlag ? <UserGreeting /> : <GuestGreeting />
    }
}

export default Greeting;