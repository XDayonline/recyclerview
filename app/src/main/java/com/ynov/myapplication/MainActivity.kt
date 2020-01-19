package com.ynov.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.ynov.myapplication.model.ForecastResult
import com.ynov.myapplication.network.ApiError
import com.ynov.myapplication.network.ApiHelpers
import com.ynov.myapplication.network.ApiRequestCallback
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),OnClickListener  {

    val foods: ArrayList<String> = ArrayList()
    val forecastList: ArrayList<String> = ArrayList()
    val apiHelpers = ApiHelpers(this)

    /*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Creates a vertical Layout Manager
        rv_list.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
        rv_list.adapter = WeatherAdapter(foods, this)

        // Loads animals into the ArrayList
        addFoods()
    }
    // Adds animals to the empty animals ArrayList
    fun addFoods() {
        foods.add("Hamburger")
        foods.add("Poulet")
        foods.add("Chien")
        foods.add("Nem")
        foods.add("Samoussa")
        foods.add("Couscous")
        foods.add("Lasagne")
        foods.add("Pomme")
        foods.add("Gateau")
        foods.add("Poire")
        foods.add("Céréales")
        foods.add("Pitch")

//        rv_list.adapter.notifyDataSetChanged()
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiHelpers.getCityByIdAsync("5368361",
            object : ApiRequestCallback<ForecastResult>() {
                override fun onSuccess(result: ForecastResult?) {
                    super.onSuccess(result)
                    runOnUiThread {
                        //API
                        val list = result!!.forecastList
                        for (item in list) {
                            addItem(item.weather[0].main)
                            rv_list.adapter!!.notifyDataSetChanged()
                        }
                    }
                }

                override fun onError(error: ApiError) {
                    super.onError(error)
                    Log.d(
                        MainActivity::class.java.canonicalName,
                        "onError() called with: error.code  = [" + error.code
                            .toString() + " & error.message" + error.message + "]"
                    )
                }
            }
        )
        // Creates a vertical Layout Manager
        rv_list.layoutManager = LinearLayoutManager(this)

        // Access the RecyclerView Adapter and load the data into it
//        rv_list.adapter = WeatherAdapter(foods, this)
        rv_list.adapter = WeatherAdapter(forecastList, this,this)

        // Loads animals into the ArrayList
//        addFoods()
    }
    fun addItem(res : String){
        forecastList.add(res)
        Log.d("REPONSE",res)
    }

    override fun onItemClick(item: ForecastResult, position: Int) {
        Toast.makeText(this, item.city.toString(), Toast.LENGTH_SHORT).show()
        Log.d("REPONSE",item.city.toString())
    }

}
