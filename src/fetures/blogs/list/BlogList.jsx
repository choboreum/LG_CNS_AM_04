import styled from "styled-components";
import BlogItem from "../item/BlogItem";
import { useNavigate } from "react-router-dom";

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    & > * {
        :not(:last-child){
            margin-bottom: 16px;
        }
    }
`

const BlogList = (props) => {    
    const moveUrl = useNavigate();
    return (
        <Wrapper 
        //onClick={() => {moveUrl("/blog/read")}}
        >
            {
                props.blogs.map( (blog, i) => {
                    return(
                        <BlogItem key={blog.id} blog={blog} />
                    )
                })
            }
        </Wrapper>
    )
}

export default BlogList;