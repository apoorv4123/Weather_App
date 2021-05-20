package com.example.weatherapp.utils

sealed class Result<out R> { // using out keyword, you can typecast subclasses to super classes, covariance & contravariance

    data class Success<T>(val data: T?) : Result<T>()
    // Typecasted Success of type T class to super class of Result into T class. If it is
    // a success, we want this class(Success) to be a super type of the Result class itself.
    // Here, I've typecasted subclass Success of type T class to a superclass of Result. This is
    // achieved using out keyword in Result class. Read about covariance & contravariance.

    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String { // This is for using print statements
        return when (this ){
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            is Loading -> "Loading"
        }
    }


}
