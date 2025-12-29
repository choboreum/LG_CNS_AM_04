import React from "react";
import styled from "styled-components";

const StyledButton = styled.button`
    padding: 8px 16px;
    font-weight: 700;
    color: #fff;
    background: #000;
    border-radius: 12px;

    // 버튼이 disabled 상태일 때 적용될 스타일
    &:disabled {
        background-color: gray;
        cursor: not-allowed;
        opacity: 0.6;
    }
`

const Button = (props) => {
    return(
        <>
            <StyledButton onClick={props.onClick} disabled={props.disabled}>{props.title}</StyledButton>
        </>
    )
}

export default Button;