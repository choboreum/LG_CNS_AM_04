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

const BlogCommentList = ({comments}) => {
  return (
    <Wrapper>
        {
            comments.map( (comment, i) => {
                return(
                    <BlogCommentItem key={comment.id} comment={comment} />
                )
            })
        }
    </Wrapper>
  )
}

export default BlogCommentList;