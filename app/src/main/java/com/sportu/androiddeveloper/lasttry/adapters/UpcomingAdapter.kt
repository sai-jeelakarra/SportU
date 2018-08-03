package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Upcomings

class UpcomingAdapter (val mCtx : Context, val layoutId:Int, val employeeList:List<Upcomings>)
    : ArrayAdapter<Upcomings>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val title = view.findViewById<TextView>(R.id.tabtitle)
        val date = view.findViewById<TextView>(R.id.tabteam1)


        val employee = employeeList[position]

        title.text = employee.Title
        date.text = employee.Date


        return view
    }




}