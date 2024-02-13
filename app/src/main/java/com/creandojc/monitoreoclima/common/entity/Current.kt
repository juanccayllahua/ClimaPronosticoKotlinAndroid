package com.creandojc.monitoreoclima.common.entity

data class Current(
    var dt:Long,
    var humidity:Int,
    var temp:Double,
    var weather: List<Weather>,
    val sunrise: Long
): WeatherBase(dt,humidity,temp,weather)
