package com.example.weatherapp

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    val CITY: String = "dublin,ie"
    val API: String = "8118ed6ee68db2debfaaa5a44c832918"
    val WEATHERURL: String = "https://api.openweathermap.org/data/2.5/weather?q=$CITY&units=metric&appid=$API"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val intent = Intent(this, SecondActivity::class.java)
     //   startActivity(intent)

    }

    inner class weatherTask() : AsyncTask<String, Void, String>() {

        override fun doInBackground(vararg params: String?): String? {
            var response:String?


            try {
                response = URL(WEATHERURL).readText( Charsets.UTF_8)

                Log.i("JSON", response)
            } catch(e: Exception) {
                response = null
            }

            return response
        }

        override fun onPreExecute() {
            super.onPreExecute()

            address.text = "123" //  address
            updated_at.text =  "123" //updatedAtText
            findViewById<TextView>(R.id.status).text = "weather desc" //weatherDescription.capitalize()
            temp.text = "123" // temp
            temp_min.text = "123" // tempMin
            temp_max.text = "123" // tempMax
            sunrise.text = "123" // SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunrise*1000))
            sunset.text = "123" // SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(sunset*1000))
            wind.text = "123" // windSpeed
            pressure.text = "123" //
            humidity.text = "123"


        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

    }
}
