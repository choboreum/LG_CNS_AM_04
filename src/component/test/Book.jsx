const Book = (props) => {
    return( //ui를 return 
        <>
            {/* <div>
                <p><strong>책 이름: {props.name}</strong></p>
                <p>책 가격 : {props.price}</p>
            </div> */}
            <div>
                <p><strong>책 이름: {props.data.name}</strong></p>
                <p>책 가격 : {props.data.price}</p>
            </div>
        </>
    )
}

export default Book;