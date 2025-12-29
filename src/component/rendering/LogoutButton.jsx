import Button from "../ui/Button";

const LogoutButton = (props) =>{
    const logoutHandler = (setIsFlag) => {
        console.log(`Logout ${setIsFlag()}` )
        setIsFlag(false);
    }

    return(
        <>
            <Button title="LOGOUT" onClick={() => logoutHandler(props.isLogin)} />
        </>
    )
}

export default LogoutButton;