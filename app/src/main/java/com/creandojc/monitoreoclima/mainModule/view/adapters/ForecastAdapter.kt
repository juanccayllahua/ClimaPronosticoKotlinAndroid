package com.creandojc.monitoreoclima.mainModule.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.creandojc.monitoreoclima.BR
import com.creandojc.monitoreoclima.R
import com.creandojc.monitoreoclima.common.entity.Forecast
import com.creandojc.monitoreoclima.databinding.ItemWeatherBinding
import com.creandojc.monitoreoclima.mainModule.viewModel.MainViewModel

class ForecastAdapter(private val listener: OnClickListener):
    ListAdapter<Forecast,RecyclerView.ViewHolder>(ForecastDiffCallback()) {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = DataBindingUtil.bind<ItemWeatherBinding>(view)

        fun setListener(forecast: Forecast){
            binding?.root?.setOnClickListener{
                //ejecucion de clic en recycler view
                listener.onClick(forecast)

            }
        }
    }

    class ForecastDiffCallback: DiffUtil.ItemCallback<Forecast>(){
        override fun areItemsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = oldItem.dt == newItem.dt

        override fun areContentsTheSame(oldItem: Forecast, newItem: Forecast): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent,
            false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val forecast = getItem(position)
        //val vm: MainViewModel by viewModels()
        //binding.lifecycleOwner = this
        //binding.viewModel = vm
        with(holder as ViewHolder){
            holder.binding?.setVariable(BR.forecast, forecast)
            holder.binding?.executePendingBindings()

            setListener(forecast)
        }
    }
}