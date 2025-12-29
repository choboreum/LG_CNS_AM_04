import React, { useState } from "react";
import styled from "styled-components";
import api from "../../../api/axios";
import { Link, useNavigate } from "react-router-dom";

// Container
const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f2f2;
`;

// Form Box
const FormWrapper = styled.div`
  background-color: white;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0px 8px 16px rgba(0,0,0,0.1);
  width: 400px;
`;

// Title
const Title = styled.h2`
  text-align: center;
  margin-bottom: 20px;
  color: #333;
`;

// Input
const Input = styled.input`
  width: 100%;
  padding: 12px;
  margin-bottom: 15px;
  border-radius: 6px;
  border: 1px solid #ccc;
  font-size: 16px;

  &:focus {
    outline: none;
    border-color: #007bff;
    box-shadow: 0 0 5px rgba(0,123,255,0.3);
  }
`;

// Button
const Button = styled.button`
  width: 100%;
  padding: 12px;
  background-color: #007bff;
  color: white;
  border: none;
  font-size: 16px;
  border-radius: 6px;
  cursor: pointer;
  margin-top: 10px;

  &:hover {
    background-color: #0056b3;
  }

  &:disabled {
    background-color: #aaa;
    cursor: not-allowed;
  }
`;

// Link
const TextLink = styled(Link)`
  display: block;
  text-align: center;
  margin-top: 15px;
  font-size: 14px;
  color: #007bff;
  text-decoration: none;
  cursor: pointer;

  &:hover {
    text-decoration: underline;
  }
`;

const SignUp = () =>{
    const [form, setForm] = useState({
        name : '',
        email : '',
        password : '',
    })

    const handlerChange = (e) => {
        const {name, value} = e.target; //e.target.name, e.target.value

        setForm({...form, [name] : value}) //스프레스 연산자를 사용하는 이유, form의 변수를 그대로 사용하기 위해
                                            //복사한 form에게 name의 value값을 전달
    }

    const moveUrl = useNavigate();

    const handlerSubmit = async(e) => { //서버로 json 형식의 데이터 전달, 비동기 방식의 통신을 지향, 비동기 방식 ???? => async!!
        e.preventDefault(); // button이 가지고 있는 이벤트와 리랜더링의 이벤트 버블링을 막기 위해 사용
        try{
            const response = await api.post("/users", { // response에 post방식으로 데이터를 전달하고 저장
                // async로 비동기 통신을 하기 떄문에 await이 필요
                name : form.name,
                email : form.email,
                password : form.password,
            });
            moveUrl("/login");
            console.log(response);
        } catch(error) {

        }
    }
    return(
        <>
            <Container>
                <FormWrapper>
                    <Title>회원가입</Title>
                    <form onSubmit={handlerSubmit}>
                        <Input type="text" name="name" value={form.name} onChange={handlerChange} placeholder="name" />
                        <Input type="email" name="email" value={form.email} onChange={handlerChange} placeholder="email" />
                        <Input type="password" name="password" value={form.password} onChange={handlerChange} placeholder="password" />
                        <Button type="submit">가입하기</Button>
                    </form>
                    <TextLink to={'/login'}>로그인페이지로 이동하기</TextLink>
                </FormWrapper>
            </Container>
        </>
    )
}

export default SignUp;