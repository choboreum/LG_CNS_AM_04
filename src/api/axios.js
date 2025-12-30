import axios from 'axios';

const url = process.env.REACT_APP_SERVER_URL;
//console.log('REACT_APP_SERVER_URL >>>>', url);

const api = axios.create({
    baseURL : url,
    headers : {
        "Content-Type" : "application/json"
    }
})

export default api;