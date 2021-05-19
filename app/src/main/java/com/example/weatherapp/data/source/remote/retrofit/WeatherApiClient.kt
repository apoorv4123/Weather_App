package com.example.weatherapp.data.source.remote.retrofit

import com.example.weatherapp.data.source.remote.retrofit.ApiEndPoints.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Client API object. For making this we need to make all the end points first. So, make WeatherApiService interface first.
object WeatherApiClient {

    // create an object of retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: WeatherApiService by lazy{
        retrofit.create(WeatherApiService::class.java)
    }
}