import React from 'react'
import './css/weather.css'
import { Button } from 'react-bootstrap'

const WeatherButton = ({cities, city, cityHandler}) => {
  return (
    <div className='weather-btn'>
        <Button className='btn'
                variant={`${city == '' ? 'outline-warning' : ''}`}
                onClick={() => cityHandler('')}
        >Current Location</Button>
        {
            cities.map((item, i) => {
                return(
                    <Button className='btn' 
                            key={i}
                            variant={`${city == item ? 'outline-warning' : ''}`}
                            onClick={()=>cityHandler(item)}
                    >{item}</Button>       
                )
            })
        }
    </div>
  )
}

export default WeatherButton