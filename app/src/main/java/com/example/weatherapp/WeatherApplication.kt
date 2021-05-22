package com.example.weatherapp

import android.app.Application
import android.util.Log
import androidx.preference.PreferenceManager
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import com.example.weatherapp.data.source.repository.WeatherRepository

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    val weatherRepository: WeatherRepository
        get() = ServiceLocator.provideWeatherRepository(this)

}