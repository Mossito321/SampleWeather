package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sampleweather.mossinwkung.sampleweatherapplication.R
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse

class WeatherSearchFragment : Fragment(), WeatherSearchContract.View {

    companion object {
        fun newInstance(): WeatherSearchFragment {
            return WeatherSearchFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_weather_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun showOutput(response: WeatherResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}