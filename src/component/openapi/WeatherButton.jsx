import React from 'react'
import './css/weather.css'
import { Button } from 'react-bootstrap'

const WeatherButton = ({cities, setCity}) => {
  return (
    <div className='weather-btn'>
        <Button className='btn'>Current Location</Button>
        {
            cities.map((city, i) => {
                return(
                    <Button className='btn' key={i}>{city}</Button>       
                )
            })
        }
    </div>
  )
}

export default WeatherButton