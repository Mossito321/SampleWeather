package com.sampleweather.mossinwkung.sampleweatherapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.Window
import com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather.WeatherMainFragment

class MainActivity : AppCompatActivity() {
    var fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()

        setContentView(R.layout.activity_main)

        var weatherFragment = WeatherMainFragment.Companion.newInstance()

        setupFragment(weatherFragment)

    }

    fun setupFragment(fragment: Fragment) {
        var fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contentFrame, fragment)
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (fragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

}
