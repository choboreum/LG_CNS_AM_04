import Button from "./../../component/ui/Button"

const ButtonPage = () => {
    const saveHandler = () => {
        console.log('saveHandler')
    }
    
    const listHandler = () => {
        console.log('listHandler')
    }

    return(
        <>
            <div>
                <Button title="글 작성하기" onClick={e => saveHandler()} /><br />
                <Button title="목록 보기" onClick={e => listHandler()} />
            </div>
        </>
    )
}

export default ButtonPage;