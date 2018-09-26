package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sampleweather.mossinwkung.sampleweatherapplication.MainActivity
import com.sampleweather.mossinwkung.sampleweatherapplication.R
import com.sampleweather.mossinwkung.sampleweatherapplication.api.WeatherApi
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse
import kotlinx.android.synthetic.main.fragment_weather.*
import java.util.*

class WeatherMainFragment : Fragment(), WeatherMainContract.View {

    private lateinit var presenter: WeatherMainContract.Presenter
    private var actualId: Int = 0
    private var sunrise: Int = 0
    private var sunset: Int = 0

    companion object {
        fun newInstance(): WeatherMainFragment {

            return WeatherMainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weatherCollectionUseCase = WeatherCollectionUseCaseImpl(WeatherProviderImpl(WeatherApi))

        presenter = WeatherMainPresenter(this, weatherCollectionUseCase)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getCurrentWeather("Bangkok", "imperial")
    }

    override fun showOutput(response: WeatherResponse) {
        var weatherSearchFragment = WeatherSearchFragment.Companion.newInstance()

        cityField.text = response.name?.toUpperCase(Locale.getDefault()) + "," + response.sys?.country
        detailsField.text = response.weather?.get(0)?.description?.toUpperCase(Locale.getDefault())
        currentTemperatureField.text = (String.format("%.2f", response.main?.temp) + "°")
        humidityField.text = "Humidity: ${response.main?.humidity}%"
        pressureField.text = "Pressure: ${response.main?.pressure}hPa"

        response.weather?.get(0)?.id?.let {
            actualId = it
        }

        response.sys?.sunRise?.let {
            sunrise = it
        }

        response.sys?.sunSet?.let {
            sunset = it
        }

        weather_icon.typeface = Typeface.createFromAsset(context?.assets, "fonts/weathericons-regular-webfont.ttf")
        weather_icon.text = Html.fromHtml(setWeatherIcon(actualId = actualId,
                sunrise = sunrise.toLong() * 1000,
                sunset = sunset.toLong() * 1000))

        defreeSwitch.setOnClickListener {
            if (defreeSwitch.isChecked) {
                presenter.getCurrentWeather("Bangkok", "metric")
            } else {
                presenter.getCurrentWeather("Bangkok", "imperial")
            }
        }

        searchImageView.setOnClickListener {
            (activity as MainActivity).setupFragment(weatherSearchFragment)
        }

    }

    override fun showLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loader.visibility = View.INVISIBLE
    }

    private fun setWeatherIcon(actualId: Int, sunrise: Long, sunset: Long): String {
        var id = actualId / 100
        var icon = ""

        if (actualId == 800) {
            var currentTime = Date().time
            if (currentTime in sunrise..(sunset - 1)) {
                icon = "&#xf00d"
            } else {
                icon = "&#xf02e"
            }
        } else {
            when (id) {
                2 -> icon = "&#xf01e;"
                3 -> icon = "&#xf01c;"
                7 -> icon = "&#xf014;"
                8 -> icon = "&#xf013;"
                6 -> icon = "&#xf01b;"
                5 -> icon = "&#xf019;"
            }
        }


        return icon
    }

}