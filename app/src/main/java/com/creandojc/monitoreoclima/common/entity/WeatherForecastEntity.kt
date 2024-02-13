package com.creandojc.monitoreoclima.common.entity

data class WeatherForecastEntity(
    val timezone:String,
    val current: Current,
    val hourly: List<Forecast>?
)
