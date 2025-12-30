import styled from 'styled-components';
import BlogCommentItem from '../item/BlogCommentItem';

const Wrapper = styled.div`
    padding: 16px;
    width: calc(100% - 32px);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const BlogCommentList = ({comments, commentDeleteHandler}) => {
  return (
    <Wrapper>
        {
            comments.map( (comment, i) => {
                return(
                    <BlogCommentItem key={comment.id} //식별자
                                    comment={comment} //전달 받은 값
                                    commentDeleteHandler = {commentDeleteHandler} //전달 받은 이벤트 
                    />
                )
            })
        }
    </Wrapper>
  )
}

export default BlogCommentList;