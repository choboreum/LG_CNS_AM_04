import React, { useState } from 'react'
import './css/index.css'
import WeatherBox from '../../component/openapi/WeatherBox'
import WeatherButton from '../../component/openapi/WeatherButton'

const WeatherPage = () => {
    const cities = ["seoul", "busan"];
    const [city, setCity] = useState('');
    const [weather, setWeather] = useState(null); // 여러개의 정보를 가져와야해서 객체로 담을 예정
    return (
        <div className='container'>
            {/* weather정보 */}
            <WeatherBox weather={weather} />
            {/* city정보 */}
            <WeatherButton cities={cities} setCity={setCity} /> 

        </div>
    )
}

export default WeatherPage