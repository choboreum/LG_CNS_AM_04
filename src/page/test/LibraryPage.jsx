import Book from "../../component/test/Book"

const LibraryPage = (props) => {
    const msg = 'lg cns am 04기'
    const books = [
        {"name" : "A", "price" : "10,000"},
        {"name" : "B", "price" : "20,000"},
        {"name" : "C", "price" : "30,000"},
    ]

    return (
        <>
            <div>
                <p>안녕하세요 <u style={{color: 'red'}}>{msg}</u>입니다.</p>
            </div>
            <hr />
            {/* <Book name="모던리액트" price="30,000" /> */}

            {
                books.map( data => {
                    return(
                        //<Book name={book.name} price={book.price} />
                        <Book data={data} />
                    )
                })
            }
        </>
    )
}

export default LibraryPage;