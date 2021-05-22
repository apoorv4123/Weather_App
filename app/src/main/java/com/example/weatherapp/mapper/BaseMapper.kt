package com.example.weatherapp.mapper

interface BaseMapper<E, D> {

    fun transformToDomain(type: E): D // domain is the object you'd be using inside activity class

    fun transformToDto(type: D): E// dto is data transfer object. This function will convert D to E
}