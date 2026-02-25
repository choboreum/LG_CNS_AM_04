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
              onClick={() =>
                {console.log("클릭 시점 데이터:", comment) // 클릭했을 때 전체 객체 출력
                console.log("클릭 시점 데이터 id:", comment.commentId) // 클릭했을 때 전체 객체 출력
                commentDeleteHandler(comment.commentId)}
              } //comment의 id는 comment의 식별값이기 떄문에 blogId가 필요없다.
      />
    </Wrapper>
  )
}

export default BlogCommentItem