package com.ynov.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ynov.myapplication.model.ForecastList
import com.ynov.myapplication.model.ForecastResult
import com.ynov.myapplication.model.Weather
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.food_list_item.view.*

class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    // Holds the TextView that will add each animal to
    val one = itemView.one
    val title = itemView.title
    fun initialize(item:ForecastResult, action:OnClickListener){
        title.text = item.city.toString()
        itemView.setOnClickListener{action.onItemClick(item,adapterPosition)}
    }
}

class WeatherAdapter (val items : ArrayList<String>, val context: Context, val clickListener: OnClickListener) : RecyclerView.Adapter<ViewHolder>() {

    // Inflates the item views
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.food_list_item, p0, false))
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {
        holder.itemView.one.text = items.get(p1)
//        holder.initialize(items.get(p1),clickListener)
    }
}

interface OnClickListener{
    fun onItemClick(item: ForecastResult, position: Int)
}