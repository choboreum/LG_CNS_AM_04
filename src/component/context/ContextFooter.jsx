import { useContext } from 'react'
import Button from '../ui/Button'
import ctx from './../util/Context'

const ContextFooter = () => {
    const {isMode, setIsMode} = useContext(ctx);

    const modeHandler = () =>{
        setIsMode(!isMode)
    }
    return (
        <footer>
            <Button title={"모드 변경"} onClick={() => modeHandler()} />
        </footer>
    )
}

export default ContextFooter