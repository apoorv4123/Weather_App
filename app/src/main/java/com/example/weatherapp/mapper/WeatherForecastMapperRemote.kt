package com.example.weatherapp.mapper

import com.example.weatherapp.data.model.NetworkWeatherForecast
import com.example.weatherapp.data.model.WeatherForecast

class WeatherForecastMapperRemote :
    BaseMapper<List<NetworkWeatherForecast>, List<WeatherForecast>> {
    override fun transformToDomain(type: List<NetworkWeatherForecast>): List<WeatherForecast> {
        // This method will help us when trying to access data from the internet(retrofit)
        return type.map { networkWeatherForecast ->
            WeatherForecast(
                networkWeatherForecast.id,
                networkWeatherForecast.date,
                networkWeatherForecast.wind,
                networkWeatherForecast.networkWeatherDescription,
                networkWeatherForecast.networkWeatherCondition
            )
        }
    }

    override fun transformToDto(type: List<WeatherForecast>): List<NetworkWeatherForecast> {
        // This function will help us when trying to save data online
        return type.map { weatherForecast ->
            NetworkWeatherForecast(
                weatherForecast.uID,
                weatherForecast.date,
                weatherForecast.wind,
                weatherForecast.networkWeatherDescription,
                weatherForecast.networkWeatherCondition
            )
        }
    }
}