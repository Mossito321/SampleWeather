package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.extensions.addTo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class WeatherMainPresenter(
        private val view: WeatherMainContract.View?,
        private val weatherCollectionUseCase: WeatherCollectionUseCase
) : WeatherMainContract.Presenter {

    private val disposeBag = CompositeDisposable()


    override fun getCurrentWeather(city: String, degree: String) {
        weatherCollectionUseCase.getWeatherbyCity(city, degree)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { view?.showLoading() }
                .doFinally { view?.hideLoading() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.showOutput(it)
                }, {

                })
                .addTo(disposeBag)

    }

}