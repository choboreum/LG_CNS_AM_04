import { useContext } from 'react'
import ctx from './../util/Context'

const ContextHeader = () => {
    const {isMode} = useContext(ctx); //구조분해로 isMode를 가져온 후 useContext 사용
  return (
    <div>
        <header style={{background:isMode ?  '#000': '#fff',
                        color:isMode ?  '#fff': '#000'}}>
            <h1>헤더입니다.</h1>
        </header>
    </div>
  )
}

export default ContextHeader