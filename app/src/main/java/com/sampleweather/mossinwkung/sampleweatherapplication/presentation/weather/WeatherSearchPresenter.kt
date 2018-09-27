package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.extensions.addTo
import com.sampleweather.mossinwkung.sampleweatherapplication.extensions.checkOneDay
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherSearchPresenter(
        private val view: WeatherSearchContract.View?,
        private val weatherCollectionUseCase: WeatherCollectionUseCaseImpl
) : WeatherSearchContract.Presenter {

    private val disposeBag = CompositeDisposable()

    override fun getCurrentWeather(city: String, degree: String) {
        weatherCollectionUseCase.getWeatherListbyCity(city, degree)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.hideError()
                    view?.showOutput(it)
                }, {
                    view?.showError("City not found..")
                })
                .addTo(disposeBag)
    }

}