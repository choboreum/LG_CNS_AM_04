import { useState } from "react";
import Greeting from "../../component/rendering/Greeting";
import LoginButton from "../../component/rendering/LoginButton";
import LogoutButton from "../../component/rendering/LogoutButton";

const UserPage = () => {
    const [isflag, setIsFlag] = useState(false);

    return(
        <>
            <div>
                <Greeting flag={isflag} />
            </div>
            {
                isflag ? <LogoutButton isLogin={setIsFlag} /> : <LoginButton isLogin={setIsFlag} /> //isFlag를 내려주는 건 직접 수정이 안되기 때문에 함수인 setIsFlag를 내려준다.
            }
        </>
    )
}

export default UserPage;