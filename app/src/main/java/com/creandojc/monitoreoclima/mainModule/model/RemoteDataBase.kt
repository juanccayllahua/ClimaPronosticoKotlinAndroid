package com.creandojc.monitoreoclima.mainModule.model

import android.util.Log
import com.creandojc.monitoreoclima.common.dataAccess.WetherService
import com.creandojc.monitoreoclima.common.entity.WeatherForecastEntity
import com.creandojc.monitoreoclima.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataBase {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(WetherService::class.java)

    suspend fun getWeatherForecastByCordinates(lat:Double,lon:Double,appId:String//,
    //                                           units:String,lang:String
    ) :
            WeatherForecastEntity = withContext(Dispatchers.IO){
             Log.i("PASO23::","eerrr")
                service.getWeatherForecastByCordinate(lat,lon,appId)
    }
}