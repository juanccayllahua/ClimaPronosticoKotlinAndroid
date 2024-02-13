package com.creandojc.monitoreoclima.common.dataAccess

import com.creandojc.monitoreoclima.common.entity.WeatherForecastEntity
import com.creandojc.monitoreoclima.common.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface WetherService {
    @GET(Constants.ONE_CALL_PATH)
    suspend fun getWeatherForecastByCordinate(
        @Query(Constants.LATITUDE_PARAM) lat: Double,
        @Query(Constants.LONGITUDE_PARAM) lon: Double,
        @Query(Constants.APP_ID_PARAM) appId: String//,
     //   @Query(Constants.EXCLUDE_PARAM) exclude: String,
      //  @Query(Constants.UNITS_PARAM) units: String,
      //  @Query(Constants.LANGUAGE_PARAM) lang: String

    ): WeatherForecastEntity
}