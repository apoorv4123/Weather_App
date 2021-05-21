package com.example.weatherapp.data.source.remote

import com.example.weatherapp.BuildConfig
import com.example.weatherapp.data.model.LocationModel
import com.example.weatherapp.data.model.NetworkWeather
import com.example.weatherapp.data.model.NetworkWeatherForecast
import com.example.weatherapp.data.source.remote.retrofit.WeatherApiClient
import com.example.weatherapp.data.source.remote.retrofit.WeatherApiService
import com.example.weatherapp.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class WeatherRemoteDataSourceImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,//Whenever you deal with networking
    // you need to work with asynchronous programming. In kotlin we use coroutines for that.
    // And for networking & database access, we use dispatchers.IO.
    private val retrofitClient: WeatherApiService = WeatherApiClient.retrofitService// Retrofit client
) : WeatherRemoteDataSource {

    override suspend fun getWeather(locationModel: LocationModel): Result<NetworkWeather> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = retrofitClient.getCurrentWeather(
                    locationModel.latitude, locationModel.longitude, BuildConfig.API_KEY
                )
                if (result.isSuccessful) {
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                } else {
                    Result.Success(null)// If unable to parse this correctly, pass null
                }
            } catch (exception: Exception) {// java.lang.Exception
                Result.Error(exception)
            }
        }

    override suspend fun getWeatherForecast(cityId: Int): Result<List<NetworkWeatherForecast>> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = retrofitClient.getWeatherForecast(
                    cityId, BuildConfig.API_KEY
                )
                if (result.isSuccessful) {
                    val networkWeatherForecast = result.body()?.weathers
                    Result.Success(networkWeatherForecast)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }

    override suspend fun getSearchWeather(query: String): Result<NetworkWeather> =
        withContext(ioDispatcher) {
            return@withContext try {
                val result = retrofitClient.getSpecificWeather(
                    query, BuildConfig.API_KEY
                )
                if (result.isSuccessful) {
                    val networkWeather = result.body()
                    Result.Success(networkWeather)
                } else {
                    Result.Success(null)
                }
            } catch (exception: Exception) {
                Result.Error(exception)
            }
        }
}
