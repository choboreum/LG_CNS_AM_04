import styled, { keyframes } from "styled-components";
import Button from "../../../component/ui/Button";
import { useNavigate } from "react-router-dom";
import TextInput from "../ui/TextInput";
import BlogCommentList from "../list/BlogCommentList";

const Wrapper = styled.div`
    padding: 16px;
    width: calc(100% - 32px);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
`;

const Container = styled.div`
    width: 100%;
    max-width: 720px;

    & > * {
        :not(:last-child) {
            margin-bottom: 16px;
        }
    }
`;

const PostContainer = styled.div`
    padding: 8px 16px;
    border: 1px solid grey;
    border-radius: 8px;
`;

const TitleText = styled.p`
    font-size: 28px;
    font-weight: 500;
`;

const ContentText = styled.p`
    font-size: 20px;
    line-height: 32px;
    white-space: pre-wrap;
`;

const CommentLabel = styled.p`
    font-size: 16px;
    font-weight: 500;
`;

const spin = keyframes`
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
`;

const Spinner = styled.div`
  border: 6px solid #f3f3f3;
  border-top: 6px solid #3498db;
  border-radius: 50%;
  width: 48px;
  height: 48px;
  animation: ${spin} 1s linear infinite;
  margin: 100px auto;
`;

const WelcomeMessage = styled.div`
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 16px;
    color: #333;
`;

const BlogRead = () => {
  const moveUrl = useNavigate();
  return (
    <Wrapper>
      <Container>
        <Button title={'메인으로'} onClick={() => moveUrl('/blog/index')} />

        <PostContainer>
          <TitleText>TITLE</TitleText>
          <ContentText>CONTENT</ContentText>
        </PostContainer>

        {/* 블로그 댓글 설계 필요 */}
        <CommentLabel>작성된 댓글</CommentLabel>
        <BlogCommentList />

        <TextInput height={15} />

        <Button title={'댓글작성'} onClick={() => {}} />
      </Container>
    </Wrapper>
  )
}

export default BlogRead;