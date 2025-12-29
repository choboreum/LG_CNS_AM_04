import styled from "styled-components"

const StyledTextInput = styled.textarea`
    width: calc(100% - 32px);
    ${(props) => props.height &&
    `
        height : ${props.height}px;
    `
    };
    padding: 16px;
    line-height: 20px;
    margin-bottom: 16px;
`   

const TextInput = (props) => {
    return (
        <StyledTextInput height={props.height} value={props.value} onChange={props.changeHandler} />
    )
}

export default TextInput