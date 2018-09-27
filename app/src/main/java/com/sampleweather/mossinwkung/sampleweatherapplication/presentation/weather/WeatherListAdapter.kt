package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sampleweather.mossinwkung.sampleweatherapplication.R
import com.sampleweather.mossinwkung.sampleweatherapplication.extensions.changeFormatDate
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListData

class WeatherListAdapter(private val context: Context,
                         private val data: List<WeatherListData>,
                         private val city: String) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val weatherRowView = inflater.inflate(R.layout.listview_weather_row, parent, false)

        val listData = data[position]

        val cityTimeTextView = weatherRowView.findViewById(R.id.cityTimeTextView) as TextView
        val degreeTextView = weatherRowView.findViewById(R.id.degreeTextView) as TextView
        val imageWeather = weatherRowView.findViewById(R.id.imageWeather) as ImageView

        var degree = listData.main?.temp
        var imageSource = "http://openweathermap.org/img/w/${listData.weather?.get(0)?.icon}.png"
        var time = listData.dtTxt
        var pressure = listData.main?.pressure
        var humidity = listData.main?.humidity

        cityTimeTextView.text = "${city} , Time : ${time?.changeFormatDate()}"

        degreeTextView.text = "${(String.format("%.2f", degree) + "°")} , Pressure: ${pressure}hPa, Humidity: ${humidity}%"
        Glide.with(context)
                .load(imageSource)
                .crossFade()
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageWeather)

        return weatherRowView
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.size
    }

}