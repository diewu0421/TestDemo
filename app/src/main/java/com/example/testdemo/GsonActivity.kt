package com.example.testdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_gson.*
import kotlinx.coroutines.withContext

class GsonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gson)
//        Gson().fromJson<Person>()
        Fuel.get(REQUEST_URL).responseString { str ->
            kotlin.runCatching {

                runOnUiThread {

                    val json = str.get()

                    runCatching {
                        val person = Gson().fromJson<Person1>(json, Person1::class.java)
                        Log.e("GsonActivity","onCreate person = $person")
                    }.onFailure {
                        Log.e("GsonActivity","onCreate $it")

                    }


                    tv.text = json
                }
            }.onFailure {
                runOnUiThread {
                    Toast.makeText(this@GsonActivity, "异常", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    data class Person1(val name:String, val age:Int)


}

val REQUEST_URL = "http://d83f0fd5-0108-4c07-9336-43ed693c101d.mock.pstmn.io/testgson"

