import '../../styles/comment.css'
import Comment from '../../component/test/Comment'

const CommentPage = (props) => {
    const comments = [
        {name : "kim" , comment : "재밌어요"},
        {name : "cho" , comment : "추천합니다"},
        {name : "hong" , comment : "잘봤어요"},
    ]


    return(
        <>
            {
                comments.map( data => {
                    return(
                        <>
                            <Comment data={data} />
                        </>
                    )
                })
            }
        </>
    )
}

export default CommentPage;