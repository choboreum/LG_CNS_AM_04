import { useNavigate } from "react-router-dom";
import styled from "styled-components";

const Wrapper = styled.div`
    width: calc(100% / 3);
    padding: 16px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    border: 1px solid grey;
    border-radius: 8px;
    cursor: pointer;
    :hover{
        background: lightgray;
    }
`
const TitleText = styled.p`
    font-size: 18px;
    font-weight: bold;
`


const BlogItem = ({blog}) => {
    const moveUrl = useNavigate();
    console.log(">>>> BlogItem : blog blogId" , blog.blogId ) ;  
    
    return (
        <Wrapper onClick={() =>moveUrl(`/blog/read/${blog.blogId}`)}>
            <TitleText>
                {blog.title}
            </TitleText>
        </Wrapper>
    )
}

export default BlogItem;