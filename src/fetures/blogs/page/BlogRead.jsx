import styled, { keyframes } from "styled-components";
import Button from "../../../component/ui/Button";
import { useNavigate, useParams } from "react-router-dom";
import TextInput from "../ui/TextInput";
import BlogCommentList from "../list/BlogCommentList";
import { useEffect, useState } from "react";
import api from "../../../api/axios";
import axios from "axios";

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
  // useParams : url에서 전달되는 파라미터를 전달 받을 수 있는 hook
  const {id} = useParams();
  console.log("content params : ", id);

  const [blog, setBlog] = useState({});
  const [comments, setComments] = useState([]); //작성된 댓글들에 관련된 변수
  const [comment, setComment] = useState(''); //작성 후 등록해야 할 댓글에 관련된 변수

  const getBlog = async() =>{
    /**
     * 1. queryString : http://id:port/blogs?id=xxxx
     *  api.get(`/blogs?id=${id}`)
     *  api.get(`/blogs`, {
     *    params{
     *      id : id
     *    }
     *  })
     * 2. path variable : http://id:port/blogs?id=xxxx
     *  api.get(`/blogs/${id}`)
     *  - embed를 이용해서 특정블로그의 comments를 함께 가져와본다면
     *  api.get(`/blogs/${id}?_embed=comments`)
     */
    //await api.get(`/blogs/${id}`)
    await api.get(`/blogs/${id}?_embed=comments`)
      .then((response)=>{ // 데이터를 가져온 후 해당 데이터를 state로 변경
        console.log(response);
        console.log(response.data);

        setBlog({
          id: response.data.id,
          title: response.data.title,
          content: response.data.content,
        })

        setComments(response.data.comments); // 댓글이 없는 경우를 위해 비어있는 배열 추가
      })
      .catch((err)=>{
        console.log(err)
      })
  }

  useEffect(() => {
    getBlog()
  }, []);

  const moveUrl = useNavigate();

/**
 * 전달받은 인자를 axios를 이용해서 db.json comments에 등록하고
 * 메인페이지로 이동이 아닌, 현재 페이지(상세보기) 내부에서 댓글 등록이 되면서 갱신 후 리랜더링
 */
  const commentHandler = async(blogId, content) => { //댓글 입력 핸들러
    console.log(blogId, content)
    await api.post('/comments',{
        id : Date.now(),
        content : content,
        blogId : blogId,
      })
      .then((response)=>{ // 데이터를 가져온 후 해당 데이터를 state로 변경
        console.log(response);
        console.log(response.data);

        /* //아래 두 함수로 사용하자면, 기능 구현은 가능은 하지만 전체 렌더링이 되는 방법이므로 지양하는 방법은 아니다.
        getBlog();
        setComment(''); */ 


        // 부분 리랜더링을 위한 기본패턴(response.data가 배열일 경우) => json(객체로 구성됨)이 아닌 백엔드 서버가 구성 되어 있을 경우 가능 
        if(response.status === 201){
          //const newComment = response.data[response.data.length - 1]; //배열을 추가
          const newComment = response.data; //객체를 추가

          setComments((arr) =>{
            return [...arr, newComment] 
          })
          setComment(''); 
        }

      })
      .catch((err)=>{
        console.log(err)
      })
    }

    // 댓글 삭제 이벤트
    const commentDeleteHandler = async(id) => { //해당 id는 comment의 식별값인 id
      console.log('commentDeleteHandler id >>>>', id)
      /**
       * 전달 받은 식별값으로 해당 댓글을 삭제하고, 
       * 댓글ui만 리랜더링
       */
      await api.delete(`/comments/${id}`)
        .then((response) => {
          console.log('commentDeleteHandler response >>>>', response)
          if(response.status === 200){
            setComments( comments.filter((e) => e.id != id ) ) //filter사용 후 이벤트가 일어난 id와 같지 않은 남은 id들의 리스트들만 setComments에 담기
          }
        })
        .catch((err) => {
          console.log('commentDeleteHandler err >>>>', err)
        })
    }

  return (
    <Wrapper>
      <Container>
        <Button title={'메인으로'} onClick={() => moveUrl('/blog/index')} />

        <PostContainer>
          <TitleText>{blog.title}</TitleText>
          <ContentText>{blog.content}</ContentText>
        </PostContainer>

        {/* 블로그 댓글 설계 필요 */}
        <CommentLabel>작성된 댓글</CommentLabel>
        <BlogCommentList comments={comments || []}  //댓글이 없는 경우를 위해 비어있는 배열 추가 => || []
                          commentDeleteHandler = {commentDeleteHandler} //인자를 전달 할 이유가 없어서 축약 사용
        />

        <TextInput height={15} 
                    value={comment} 
                    changeHandler={(e) => {
                      setComment(e.target.value)
                    }} 
        />

        <Button title={'댓글작성'} onClick={() => commentHandler(blog.id, comment)} />
      </Container>
    </Wrapper>
  )
}

export default BlogRead;