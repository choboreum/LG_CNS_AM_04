import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import LibraryPage from './page/test/LibraryPage';
import CommentPage from './page/test/CommentPage';
import ButtonPage from './page/test/ButtonPage';
import CapacityPage from './page/state/CapacityPage';
import BlogJsonPage from './page/state/BlogJsonPage';
import EventPage from './page/event/EventPage';
import UserPage from './page/redering/UserPage';
import BlogApp from './BlogApp';
import ContextApp from './ContextApp';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <>
    {/* // Context/provider 적용 예) */}
    <ContextApp />

    {/* // Blog 적용 예) */}
    {/* <BlogApp /> */}
  </>
)

// root.render(
//   <>
//     {/* // 이벤트 적용 예) */}
//     <UserPage />

//     <hr />
    
//     {/* // 이벤트 적용 예) */}
//     <EventPage />

//     <hr />
    
//     {/* // axios통신과 json데이터 적용 예) */}
//     <BlogJsonPage />

//     <hr />
    
//     {/* // status(hook) 관리 적용 예) */}
//     <CapacityPage />

//     <hr />
    
//     {/* // 컴포넌트 styled 및 props 적용한 버튼 예) */}
//     <ButtonPage /> 

//     <hr />
        
//     {/* // 컴포넌트 css 적용 예) */}
//     <CommentPage /> 
    
//     <hr />

//     {/* 컴포넌트 합성(Composition) 및 props 적용 예) */}
//     <LibraryPage /> 

//     {/* <React.StrictMode>
//       <App />
//     </React.StrictMode> */}
//   </>
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
