import React, { useEffect, useState } from 'react'
import './css/index.css'
import WeatherBox from '../../component/openapi/WeatherBox'
import WeatherButton from '../../component/openapi/WeatherButton'

const WeatherPage = () => {
    const cities = ["seoul", "busan"];
    const [city, setCity] = useState('');
    const [weather, setWeather] = useState(null); // 여러개의 정보를 가져와야해서 객체로 담을 예정

    const apiKey = process.env.REACT_APP_OPENAPI_KEY; // apikey를 env파일에 숨겨서 변수에 담아 사용하기

    // 현재 위치 정보(위도, 경도)를 얻어오기
    const getCurLoc = () => {
        navigator.geolocation.getCurrentPosition((position)=>{
            let lat = position.coords.latitude;
            let lon = position.coords.longitude;
            console.log('lat >>>> ', lat);
            console.log('lon >>>> ', lon);

            getCurWeather(lat, lon);
        })
    }

    /**
     * 1. fetch api이용해서 데이터 전달
     * 2. 전달된 데이터를 weather에 담기
     * 3. 디버그 콘솔 활용해서 weather정보를 확인해본다면?
     */
    const getCurWeather = async(lat, lon) => {
        let url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`
        const res = await fetch(url);
        let data = await res.json();
        console.log(res)
        console.log(data)

        setCity(data);
    }

    /**
     * 도시명을 선택하면 날씨 정보를 변경
     * props 및 이벤트 전달 
     * 그리고 endpoint 확인이 필요함
     */
    const getCityWeather = async() => {
        let url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric`
        const res = await fetch(url);
        let data = await res.json();

        setWeather(data);
    }

    const cityHandler = (city) => {
        console.log('cityHandler >>>>', city)
        setCity(city);
    }

    useEffect(()=>{
        console.log('weather page >>>> ', city)
        if(city == ''){
            getCurLoc();
        } else getCityWeather();
    },[city])

    return (
        <div className='container'>
            {/* weather정보 */}
            <WeatherBox weather={weather} city={city} />
            {/* city정보 */}
            <WeatherButton cities={cities} cityHandler={cityHandler} /> 
        </div>
    )
}

export default WeatherPage