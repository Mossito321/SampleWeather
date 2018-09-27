package com.sampleweather.mossinwkung.sampleweatherapplication.response

import com.google.gson.annotations.SerializedName


open class WeatherListResponse {

    @SerializedName("cod")
    val cod: String? = null

    @SerializedName("message")
    val message: Double? = null

    @SerializedName("cnt")
    val cnt: Int? = null

    @SerializedName("list")
    val list: List<WeatherListData>? = null

    @SerializedName("city")
    val city: WeatherCity? = null
}

class WeatherListData {

    @SerializedName("dt")
    val dt: Int? = null

    @SerializedName("main")
    val main: Main? = null

    @SerializedName("weather")
    val weather: List<Weather>? = null

    @SerializedName("dt_txt")
    val dtTxt: String? = null
}

class WeatherCity {
    @SerializedName("id")
    val id: Int? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("coord")
    val coord: WeatherCoord? = null

    @SerializedName("country")
    val country: String? = null

    @SerializedName("population")
    val population: Int? = null
}

class WeatherCoord {
    @SerializedName("lat")
    val lat: Double? = null

    @SerializedName("lon")
    val lon: Double? = null
}