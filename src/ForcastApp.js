import {BrowserRouter, Routes, Route} from 'react-router-dom';
import ForcastPage from './fetures/forecast/ForcastPage';
import ForcastList from './fetures/forecast/ForcastList';

const ForcastApp= () => {
    return(
        <>
        {/* //브라우저 라우팅을 할 요소 들은 브라우더 라우터 태그 안에 들어가야 한다 */}
        <BrowserRouter>
            <Routes>
                <Route path='/' element={ <ForcastPage />} />
                <Route path='/list' element={ <ForcastList />} />
            </Routes>
        </BrowserRouter>
        </>
    )
}

export default ForcastApp;