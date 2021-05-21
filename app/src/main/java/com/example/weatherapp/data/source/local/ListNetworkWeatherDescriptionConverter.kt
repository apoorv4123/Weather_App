package com.example.weatherapp.data.source.local

import androidx.room.TypeConverter
import com.example.weatherapp.data.model.NetworkWeatherDescription
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListNetworkWeatherDescriptionConverter {

    val gson = Gson()

    val type: Type = object : TypeToken<List<NetworkWeatherDescription?>?>() {}.type

    /**
     * Converts a listOf[NetworkWeatherDescription] to a [String]
     */
    @TypeConverter
    fun fromWeatherDtoList(list: List<NetworkWeatherDescription?>?): String {// From Weather Database to List
        return gson.toJson(list, type)
    }

    /**
     * Converts a [String] to a listOf[NetworkWeatherDescription]
     */
    @TypeConverter
    fun toWeatherDtoList(json: String?): List<NetworkWeatherDescription> {// Converting raw string to list of NetworkWeatherDescription
        return gson.fromJson(json, type)
    }
}