package com.sampleweather.mossinwkung.sampleweatherapplication.api

import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.*

interface APIInterface {

    @GET("/data/2.5/weather")
    fun getWeatherByCity(
            @Query("q") q: String,
            @Query("units") units: String,
            @Query("appid") appId: String
    ): Observable<WeatherResponse>

    @GET("/data/2.5/forecast")
    fun getWeatherListByCity(
            @Query("q") q: String,
            @Query("units") units: String,
            @Query("appid") appId: String
    ): Observable<WeatherListResponse>
}