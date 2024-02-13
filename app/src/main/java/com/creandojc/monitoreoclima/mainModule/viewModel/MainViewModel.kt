package com.creandojc.monitoreoclima.mainModule.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.creandojc.monitoreoclima.R
import com.creandojc.monitoreoclima.common.entity.WeatherForecastEntity
import com.creandojc.monitoreoclima.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = MainRepository()

    private val result = MutableLiveData<WeatherForecastEntity>()

    fun getResult() : LiveData<WeatherForecastEntity> = result

    private val snackbarMessage = MutableLiveData<Int>()

    fun getSnackBarMessage() = snackbarMessage

    private val loaded = MutableLiveData<Boolean>()

    fun isLoaded() = loaded

    suspend fun getWeatherAndForecast(lat:Double,lon:Double,appId:String,
    //                                  units:String,lang:String
    ){

        Log.i("PASO21::","TEST")
        viewModelScope.launch {
            try {
                loaded.value = false
                val resultServer =  repository.getWeatherAndForecast(lat,lon,appId)//,units,lang)
                result.value = resultServer
                if ( resultServer.hourly == null || resultServer.hourly.isEmpty()){
                    snackbarMessage.value = R.string.main_error_empty_forecast
                }
            }catch (e: Exception){
                snackbarMessage.value = R.string.main_error_server

            }finally {
                loaded.value = true
            }

        }
    }
}