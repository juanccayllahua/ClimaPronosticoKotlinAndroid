package com.creandojc.monitoreoclima.mainModule.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.creandojc.monitoreoclima.R
import com.creandojc.monitoreoclima.databinding.ActivityMainBinding
import com.creandojc.monitoreoclima.mainModule.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.creandojc.monitoreoclima.common.entity.Forecast
import com.creandojc.monitoreoclima.common.utils.CommonUtils
import com.creandojc.monitoreoclima.mainModule.view.adapters.ForecastAdapter
import com.creandojc.monitoreoclima.mainModule.view.adapters.OnClickListener

class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ForecastAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setupViewModel()
        setupObservers()
        setupAdapter()
        setupRecyclerView()


    }
    private fun setupViewModel() {
        val vm: MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.viewModel = vm


    }
    private fun setupObservers() {
        binding.viewModel?.let {
            it.getSnackBarMessage().observe(this){
                resMsg-> Snackbar.make(binding.root,resMsg, Snackbar.LENGTH_LONG).show()
            }
            it.getResult().observe(this){
                result ->
                adapter.submitList(result.hourly)
            }
        }
    }
    private fun setupAdapter(){

        adapter = ForecastAdapter(this)

    }
    private fun setupRecyclerView(){
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }

    override fun onStart() {

        Log.i("PASO20::","eerrr")
        super.onStart()

        lifecycleScope.launch {
            try {

                // Llama a la función getWeatherAndForecast
                //binding.viewModel?.getWeatherAndForecast(-14.772439, -70.848785 , "6a5c325c9265883997730d09be2328e8")
                binding.viewModel?.getWeatherAndForecast(-12.04318, -77.02824, "6a5c325c9265883997730d09be2328e8")

                // Si no se lanzó ninguna excepción, la llamada fue exitosa
                Snackbar.make(binding.root, "La llamada fue exitosa", Snackbar.LENGTH_LONG).show()
            } catch (e: Exception) {
                // Si se lanzó una excepción, hubo un error
                Snackbar.make(binding.root, "Error2123: ${e.message}", Snackbar.LENGTH_LONG).show()
            }
        }



    }

    override fun onClick(forecast: Forecast) {
        //Listener
        Snackbar.make(binding.root,CommonUtils.getFullDate(forecast.dt), Snackbar.LENGTH_LONG).show()

    }


}