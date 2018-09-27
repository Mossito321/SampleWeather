package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse

interface WeatherSearchContract {
    interface View {
        fun showOutput(response: WeatherListResponse)
        fun showError(message: String)
        fun hideError()

    }

    interface Presenter {
        fun getCurrentWeather(city: String, degree: String)
    }
}