import 'bootstrap/dist/css/bootstrap.min.css';
import { useState } from 'react';
import { Button } from "react-bootstrap";

const EventPage = () => {
    const handler = (id, pw) => {
        console.log(`handler call!! \nid : ${id} \npw :${pw}`)
    }
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    return (
        <>
            <div>
                <label>아이디</label>
                <input type='text' value={id} onChange={ (e) => setId(e.target.value) } placeholder="아이디를 입력하세요."></input>
            </div>
            <div>
                <label>패스워드</label>
                <input type='password' value={pw} onChange={ (e) => setPw(e.target.value) } placeholder="비밀번호를 입력하세요."></input>
            </div>
            <Button variant="primary" onClick={ () => handler(id, pw) }>LOGIN</Button>
        </>
    )
}

export default EventPage;