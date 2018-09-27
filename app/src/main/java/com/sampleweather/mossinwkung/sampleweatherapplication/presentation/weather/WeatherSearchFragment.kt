package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import android.support.v4.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.sampleweather.mossinwkung.sampleweatherapplication.R
import com.sampleweather.mossinwkung.sampleweatherapplication.api.WeatherApi
import com.sampleweather.mossinwkung.sampleweatherapplication.extensions.checkOneDay
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListData
import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherListResponse
import kotlinx.android.synthetic.main.fragment_weather_search.*

class WeatherSearchFragment : Fragment(), WeatherSearchContract.View {

    private var adapter: WeatherListAdapter? = null
    private lateinit var presenter: WeatherSearchContract.Presenter
    private var degree: String = "imperial"
    private var filterListData: MutableList<WeatherListData> = arrayListOf()

    companion object {
        fun newInstance(): WeatherSearchFragment {

            return WeatherSearchFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val weatherCollectionUseCase = WeatherCollectionUseCaseImpl(WeatherProviderImpl(WeatherApi))

        presenter = WeatherSearchPresenter(this, weatherCollectionUseCase)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_weather_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchSwitch.setOnClickListener {
            degree = if (searchSwitch.isChecked) {
                "metric"
            } else {
                "imperial"
            }
            if (searchText.text.length >= 3) {
                presenter.getCurrentWeather(searchText.text.toString(), degree)
            }
        }


        searchText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                s?.let {
                    if (it.length >= 3) {
                        presenter.getCurrentWeather(searchText.text.toString(), degree)
                    } else {
                        list_view.adapter = null
                    }
                }
            }

        })
    }

    private fun filterListData(dataList: List<WeatherListData>) {
        filterListData = ArrayList()
        dataList.forEach {
            if (it.dtTxt!!.checkOneDay()) {
                filterListData.add(it)
            }
        }
    }


    override fun showOutput(response: WeatherListResponse) {
        response.list?.let { dataList ->
            filterListData(dataList)
        }

        adapter = context?.let { context ->
            response.city?.name?.let { city ->
                WeatherListAdapter(context, filterListData, city)

            }
        }
        list_view.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        errorTextView.text = message
        errorTextView.visibility = View.VISIBLE
        list_view.visibility = View.GONE
    }

    override fun hideError() {
        errorTextView.visibility = View.GONE
        list_view.visibility = View.VISIBLE
    }

}