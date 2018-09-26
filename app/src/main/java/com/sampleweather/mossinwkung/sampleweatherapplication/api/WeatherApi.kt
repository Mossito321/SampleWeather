package com.sampleweather.mossinwkung.sampleweatherapplication.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.facebook.stetho.okhttp3.StethoInterceptor

object WeatherApi : APIInterface by Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(OkHttpClient().newBuilder()
                .addNetworkInterceptor(StethoInterceptor())
                .readTimeout(30000.toLong(), TimeUnit.MILLISECONDS)
                .writeTimeout(30000.toLong(), TimeUnit.MILLISECONDS)
                .connectTimeout(30000.toLong(), TimeUnit.MILLISECONDS)
                .build())
        .baseUrl("https://api.openweathermap.org")
        .build()
        .create(APIInterface::class.java)