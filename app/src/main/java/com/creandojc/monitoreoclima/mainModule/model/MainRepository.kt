package com.creandojc.monitoreoclima.mainModule.model

import com.creandojc.monitoreoclima.common.entity.WeatherForecastEntity

class MainRepository {
    private val remoteDataBase = RemoteDataBase()

    suspend fun getWeatherAndForecast(lat:Double,lon:Double,appId:String//,
                                      //units:String,lang:String
    ):WeatherForecastEntity
    = remoteDataBase.getWeatherForecastByCordinates(lat,lon,appId)//,units,lang)
}