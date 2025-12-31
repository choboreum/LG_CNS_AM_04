import React from 'react'

/**
 * 현재위치, 섭씨, 날씨
 * 
 */
const WeatherBox = ({weather}) => {
  return (
    <div className='weather-box'>
      <p>{weather?.sys.country}</p>
      <p>{weather?.name}</p>
      <p>{weather?.main.temp}</p>
      <p>{weather?.weather[0].main}</p>
      <p>{weather?.weather[0].main.description}</p>
    </div>
  )
}

export default WeatherBox