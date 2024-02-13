package com.creandojc.monitoreoclima.common.entity

data class Forecast(
    var dt:Long,
    var humidity:Int,
    var temp:Double,
    var weather: List<Weather>,
    val pop:Double
): WeatherBase(dt,humidity,temp,weather)
