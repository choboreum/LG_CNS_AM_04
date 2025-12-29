import {BrowserRouter, Routes, Route} from 'react-router-dom';
import styled from 'styled-components';
import SignUp from './fetures/user/page/SignUp';
import SignIn from './fetures/user/page/SignIn';
import BlogIndex from './fetures/blogs/page/BlogIndex';
import BlogWrite from './fetures/blogs/page/BlogWrite';
import BlogRead from './fetures/blogs/page/BlogRead';

const TitleBox = styled.p`
    font-size: 24px;
    font-weight: bold;
    text-align: center;
`

const BlogApp= () => {
    return(
        <>
        {/* //브라우저 라우팅을 할 요소 들은 브라우더 라우터 태그 안에 들어가야 한다 */}
        <BrowserRouter>
            <TitleBox>LG CNS AM 04</TitleBox>
            <Routes>
                <Route path='/' element={ <SignUp />} />
                <Route path='/login' element={ <SignIn />} />

                <Route path='/blog/index' element={ <BlogIndex />} />
                <Route path='/blog/write' element={ <BlogWrite />} />
                <Route path='/blog/read/:id' element={ <BlogRead />} />
            </Routes>
        </BrowserRouter>
        </>
    )
}

export default BlogApp;