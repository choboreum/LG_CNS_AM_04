import styled from "styled-components"
import Button from "../../../component/ui/Button"

const Wrapper = styled.div`
   padding: 16px;
  width: calc(100% - 32px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`
const ContentText = styled.p`

`

const BlogCommentItem = ({comment, commentDeleteHandler}) => {
  console.log(comment.content)
  return (
    <Wrapper>
      <ContentText>
        {comment.content}
      </ContentText>
      <Button title={"삭제"} 
              onClick={() =>commentDeleteHandler(comment.id)} //comment의 id는 comment의 식별값이기 떄문에 blogId가 필요없다.
      />
    </Wrapper>
  )
}

export default BlogCommentItem