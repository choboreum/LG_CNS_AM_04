import styled from "styled-components";
import TextInput from "../ui/TextInput";
import Button from "../../../component/ui/Button";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import api from "../../../api/axios";

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

const BlogWrite = () => {
    /** 요구사항)
     * 1. 타이틀과 내용은 hook을 이용해서 상태 관리를 한다.
     * 2. 버튼 이벤트 : axios를 이용해서 데이터를 전달하여 db.json에 저장한다.
     * 3. 작성글의 식별값(id)는 시간객체를 활용한다.
     * 4. 이벤트가 완료 된 이후 화면은 라우터를 이용하여 "/blog/index"로 이동한다.
     */
    const moveUrl = useNavigate();

    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    const id = Date.now();

    const saveHandler = async() => {
        //try{} catch{}방식
        try{
            const response = await api.post("/blogs", {
                id: id,
                title: title,
                content: content,
            })
            console.log(`title : ${title} \ncontent : ${content}`);
            console.log('response >>>> ', response.data);
            
            moveUrl('/blog/index');
        } catch(err){
            console.log(err);
        }

        /*
        //.then.catch방식
        await api.post("/blogs", {
            id: id,
            title: title,
            content: content,
        })
        .then( (response) =>{
            moveUrl('/blog/index');
            console.log(response.data);
        })
        .catch((err) =>{
            console.log(err);
        })
        */
    }

    return (
        <Wrapper>
            <Container>
                <TextInput height={20} value={title} changeHandler={(e) => setTitle(e.target.value)} />
                <TextInput height={480} value={content} changeHandler={(e) => setContent(e.target.value)} />
                <Button title={"작성글 저장"} onClick={(e) => saveHandler(title, content)} /> &nbsp;
                <Button title={"이전"} onClick={() => moveUrl("/blog/index")} />
            </Container>
        </Wrapper>
    )
}

export default BlogWrite;