import Button from "../ui/Button";

const LoginButton = (props) =>{
    const loginHandler = (setIsFlag) => {
        console.log(`login ${setIsFlag()}`)
        setIsFlag(true);
    }

    return(
        <>
            <Button title="LOGIN" onClick={() => loginHandler(props.isLogin)} />
        </>
    )
}

export default LoginButton;