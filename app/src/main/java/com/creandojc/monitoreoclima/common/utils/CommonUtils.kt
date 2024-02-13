package com.creandojc.monitoreoclima.common.utils

import com.creandojc.monitoreoclima.common.entity.Weather
import java.text.SimpleDateFormat
import java.util.Locale

object CommonUtils {
    fun getHour(epoch: Long ) : String =  getFormatedTime(epoch, "HH:mm")

    fun getFullDate(epoch: Long ) : String =  getFormatedTime(epoch, "dd/MM/yy HH:mm")

    private fun getFormatedTime(epoch: Long, formato: String): String {
        return SimpleDateFormat(formato, Locale.getDefault()).format(epoch*1_000)
    }
    fun getWeatherMain(weather: List<Weather>?):String{
        return if (weather != null && weather.isNotEmpty()) weather[0].main else "-"
    }
    fun getWeatherDescription(weather: List<Weather>?):String{
        return if (weather != null && weather.isNotEmpty()) weather[0].description else "-"
    }

    fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.15
    }
}