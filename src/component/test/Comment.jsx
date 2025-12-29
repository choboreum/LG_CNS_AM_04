const styles = {
    content : {
        display: "flex",
        flexDirection: "column",
        gap: "4px",
        flex: 1,
    },
    name : {
        fontSize: "24px",
    },
    comment : {
        color: "#666",
    },
    imgBox : {
        width: "80px",
        borderRadius: "50%",
        overflow: "hidden",
    }
}

const Comment = (props) => {
    return(
        <>
            <div className='wrapper'>
                <div style={styles.imgBox}>
                    <img src="../../img/member-1.png" alt="" style={{width : '100%'  /*인라인*/ }} />
                </div>
                <div style={styles.content}>
                    <b style={styles.name}>{props.data.name}</b>
                    <span style={styles.comment}>{props.data.comment}</span>
                </div>
            </div>
        </>
    )
}

export default Comment;