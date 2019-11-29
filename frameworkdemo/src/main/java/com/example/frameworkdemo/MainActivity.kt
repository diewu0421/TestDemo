package com.example.frameworkdemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val checkCallingOrSelfPermission =
                    checkCallingOrSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
                if (checkCallingOrSelfPermission) {

                    val location = getLocation()
                    Log.e("MainActivity", "location $location")

                } else {

                    Log.e("MainActivity", "没有权限")

                    requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION), 100)
                }

            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLocation(): Location? {
        getSystemService(Context.LOCATION_SERVICE)
            ?.run { this as LocationManager }
            ?.let {
                return it.getProviders(true)
                    .takeIf { it.isNotEmpty() }
                    ?.get(0)
                    ?.let { provider ->
                        it.getLastKnownLocation(provider)
                    }
            }

        return null
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty()) {

            getLocation()
        }
    }

}
