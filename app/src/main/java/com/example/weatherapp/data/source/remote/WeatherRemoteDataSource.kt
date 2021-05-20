package com.example.weatherapp.data.source.remote

import com.example.weatherapp.data.model.LocationModel
import com.example.weatherapp.data.model.NetworkWeather
import com.example.weatherapp.data.model.NetworkWeatherForecast
import com.example.weatherapp.utils.Result

interface WeatherRemoteDataSource {

    suspend fun getWeather(locationModel: LocationModel): Result<NetworkWeather>
    //This method is for getCurrentWeather() in parameters we need to pass latitude & longitude.
    // We made a custom model LocationModel for this, so we used it.

    suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>>// For getWeatherForecast()

    suspend fun getSearchWeather(query: String): Result<NetworkWeather>// For getSpecificWeather()

}