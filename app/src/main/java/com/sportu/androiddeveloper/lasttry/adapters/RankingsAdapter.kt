package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Rankings

class RankingsAdapter (val mCtx : Context, val layoutId:Int, val employeeList:List<Rankings>)
    : ArrayAdapter<Rankings>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val firstname = view.findViewById<TextView>(R.id.tabtitle)
        val lastname = view.findViewById<TextView>(R.id.tabscore1)
        val address = view.findViewById<TextView>(R.id.tabteam1)
        val department = view.findViewById<TextView>(R.id.time)



        val employee = employeeList[position]

        firstname.text = employee.Position
        lastname.text = employee.Name
        address.text = employee.Country
        department.text = employee.Rating


        return view
    }




}