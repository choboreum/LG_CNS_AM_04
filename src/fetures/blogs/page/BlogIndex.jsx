import styled from "styled-components";
import Button from "../../../component/ui/Button";
import BlogList from "../list/BlogList";
import { useEffect, useState } from "react";
import api from "../../../api/axios";
import { Link, useNavigate } from "react-router-dom";

const Wrapper = styled.div`
    padding: 16px;
    width: calc(100% - 32px);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const Container = styled.div`
    width: 100%;
    max-width: 720px;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }
`;

const WelcomeMessage = styled.div`
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 16px;
    color: #333;
`;

const LogoutButton = styled(Button)`
    background-color: #f44336;
    color: white;

    &:hover {
        background-color: #d32f2f;
    }
`;

const BlogIndex = () => {
    const [arr, setArr] = useState([]);

    const moveUrl = useNavigate();

    // token 정보 가져오기
    const email = localStorage.getItem("token");
    console.log("BlogIndex token get >>>> ", email);
    const at = localStorage.getItem("access_token");
    console.log("BlogIndex access token get >>>> ", at);

    const loadDate= async() => { // 데이터와 통신을 해야하기 때문에 async사용
        try{
            const response = await api.get("/blogs/list", {
                headers: {Authorization: at ? at : ""}
            })
            console.log(response);
            console.log("response data >>>> ", response.data);

            setArr(response.data);
        } catch(err) {
            console.log(err);
        }
    }

    const logoutHandler = async() => {
        console.log("logoutHandler >>>> ")

        try{
            const response = await api.post(`/users/logout`, null, {
                headers: {Authorization: at ? at : ""}
            })
            console.log(response);
            
            localStorage.removeItem("token");
            localStorage.removeItem("access_token");
            console.log('token remove >>>>');

            moveUrl('/');
        } catch(err) {
            console.log("logoutHandler error : ", err)
        }
    }

    useEffect(() =>{
        loadDate();
    },[]); // 마운트 될 때 실행

    return(
        <Wrapper>
            <Container>
                {email && <WelcomeMessage>{email}님, 환영합니다.</WelcomeMessage>} 
                <Button title={"글 작성하기"} onClick={() =>{ moveUrl("/blog/write") }} /><br />
                <Button title={"logout"} onClick={() =>{ logoutHandler() }} />

                <BlogList blogs={arr} />
            </Container>
        </Wrapper>
    )
}

export default BlogIndex;