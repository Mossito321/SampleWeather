package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sampleweather.mossinwkung.sampleweatherapplication.R

class WeatherMainFragment : Fragment(), WeatherMainContract.View {

    companion object {


        fun newInstance(): WeatherMainFragment {

            return WeatherMainFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showOutput() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}