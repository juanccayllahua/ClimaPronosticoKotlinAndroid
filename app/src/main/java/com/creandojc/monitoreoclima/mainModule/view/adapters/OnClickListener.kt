package com.creandojc.monitoreoclima.mainModule.view.adapters

import com.creandojc.monitoreoclima.common.entity.Forecast

interface OnClickListener {
    fun onClick(forecast: Forecast)
}