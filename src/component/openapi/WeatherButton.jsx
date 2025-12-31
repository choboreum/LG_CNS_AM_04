import React from 'react'
import './css/weather.css'
import { Button } from 'react-bootstrap'

const WeatherButton = ({cities, setCity}) => {
  return (
    <div className='weather-btn'>
        <Button className='btn'
                variant={`${setCity == '' ? 'outline-warning' : ''}`}
        >Current Location</Button>
        {
            cities.map((item, i) => {
                return(
                    <Button className='btn' 
                            key={i}
                    >{item}</Button>       
                )
            })
        }
    </div>
  )
}

export default WeatherButton