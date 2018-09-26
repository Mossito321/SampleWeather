package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

class WeatherSearchPresenter(
        private val view: WeatherSearchContract.View?,
        private val weatherCollectionUseCase: WeatherCollectionUseCaseImpl
) : WeatherSearchContract.Presenter {
    override fun getCurrentWeather(city: String, degree: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}