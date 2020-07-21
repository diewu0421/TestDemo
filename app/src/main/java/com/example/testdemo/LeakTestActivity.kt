package com.example.testdemo

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.gyf.immersionbar.ImmersionBar
import java.util.concurrent.TimeUnit


/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   2020-04-17 14:49
 */
class LeakTestActivity : AppCompatActivity() ,  LocationListener{

//    companion object {
        var drawable: Drawable? = null
//    }


    private val handler = Handler()

    private var mManager : LocationManager? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        drawable = getDrawable(R.drawable.test)
//
//        setContentView(ImageView(this).apply {
//            setImageDrawable(drawable)
//        })

        setContentView(R.layout.activity_leak_test)

//        handler.postDelayed({
//            Log.e("LeakTestActivity","onCreate handler")
//        }, 100000)


//        thread {
//
//            Thread.sleep(1000000)
//            Log.e("LeakTestActivity","onCreate $this")
//        }

        mManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                100
            )
            return
        }


//        window.decorView.setBackgroundColor(Color.YELLOW)
//        val params: WindowManager.LayoutParams = window.getAttributes()
//        params.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE
//        window.setAttributes(params)

        ImmersionBar.with(this).navigationBarColor(R.color.red).init()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 100 && grantResults.isNotEmpty()) {
            Log.e("LeakTestActivity","onRequestPermissionsResult ")
            mManager?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,TimeUnit.MINUTES.toMillis(5), 100f, this)
        }
    }

    override fun finish() {
//        drawable?.toBitmap()
//        drawable = null
        super.finish()
        mManager?.removeUpdates(this)
    }


    override fun onLocationChanged(location: Location?) {

    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
    }

    override fun onProviderEnabled(provider: String?) {
    }

    override fun onProviderDisabled(provider: String?) {
    }
}