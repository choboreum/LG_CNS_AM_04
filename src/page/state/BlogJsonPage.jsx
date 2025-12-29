import { useEffect, useState } from "react";
import api from "../../api/axios";

const BlogJsonPage = () => {
    const [arr, setArr] = useState([]);
    const getBlogs = async() => { //json의 데이터를 가져오기 위해서는 async가 필요하고
        const response = await api.get('/blogs'); //async를 사용하기 위해서는 await이 필요하다
        console.log(response)
        setArr(response.data);
    }
    useEffect( () => {
        getBlogs();
    }, [])

    return(
        <>
            <div>{`${arr[0]?.title}`}</div>
        </>
    )
}

export default BlogJsonPage;