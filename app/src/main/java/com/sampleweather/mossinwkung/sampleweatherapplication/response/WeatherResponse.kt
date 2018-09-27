package com.sampleweather.mossinwkung.sampleweatherapplication.response

import com.google.gson.annotations.SerializedName


open class WeatherResponse {
    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("weather")
    var weather: List<Weather>? = null

    @SerializedName("base")
    val base: String? = null

    @SerializedName("main")
    val main: Main? = null

    @SerializedName("visibility")
    val visibility: Int? = null

    @SerializedName("wind")
    val wind: Wind? = null

    @SerializedName("clouds")
    val clouds: Clouds? = null

    @SerializedName("dt")
    val dt: Int? = null

    @SerializedName("sys")
    val sys: Sys? = null

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("name")
    val name: String? = null

    @SerializedName("cod")
    val cod: Int? = null
}

class Main {

    @SerializedName("temp")
    var temp: Double? = null

    @SerializedName("pressure")
    var pressure: Double? = null

    @SerializedName("humidity")
    var humidity: Int? = null

    @SerializedName("temp_min")
    var tempMin: Double? = null

    @SerializedName("temp_max")
    var tempMax: Double? = null
}

class Wind {

    @SerializedName("speed")
    val speed: Double? = null

    @SerializedName("deg")
    val deg: Int? = null
}

class Weather {

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("main")
    val main: String? = null

    @SerializedName("description")
    val description: String? = null

    @SerializedName("icon")
    val icon: String? = null
}

class Coord {

    @SerializedName("lon")
    val lon: Double? = null

    @SerializedName("lat")
    val lat: Double? = null
}

class Sys {

    @SerializedName("type")
    val type: Int? = null

    @SerializedName("id")
    val id: Int? = null

    @SerializedName("message")
    val message: Double? = null

    @SerializedName("country")
    val country: String? = null

    @SerializedName("sunrise")
    val sunRise: Int? = null

    @SerializedName("sunset")
    val sunSet: Int? = null
}

class Clouds {

    @SerializedName("all")
    val all: Int? = null
}