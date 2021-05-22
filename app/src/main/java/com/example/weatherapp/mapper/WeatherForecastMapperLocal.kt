package com.example.weatherapp.mapper

import com.example.weatherapp.data.model.WeatherForecast
import com.example.weatherapp.data.source.local.entity.DBWeatherForecast

// For the Db
class WeatherForecastMapperLocal : BaseMapper<List<DBWeatherForecast>, List<WeatherForecast>> {
    override fun transformToDomain(type: List<DBWeatherForecast>): List<WeatherForecast> {
        // This method will help us when trying to access data from the db
        return type.map { dbWeatherForecast ->
            WeatherForecast(
                dbWeatherForecast.id,
                dbWeatherForecast.date,
                dbWeatherForecast.wind,
                dbWeatherForecast.networkWeatherDescriptions,
                dbWeatherForecast.networkWeatherCondition
            )
        }
    }

    override fun transformToDto(type: List<WeatherForecast>): List<DBWeatherForecast> {
        // This function will help us when trying to save data into the db
        return type.map { weatherForecast ->// We'll try to convert list of weatherForecast model to list of dbWeatherForecast model
            DBWeatherForecast(
                weatherForecast.uID,
                weatherForecast.date,
                weatherForecast.wind,
                weatherForecast.networkWeatherDescription,
                weatherForecast.networkWeatherCondition
            )
        }
    }

}