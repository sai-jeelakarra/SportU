package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Teams

class TeamRankingsAdapter(val mCtx : Context, val layoutId:Int, val employeeList:List<Teams>)
    : ArrayAdapter<Teams>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val name = view.findViewById<TextView>(R.id.tabtitle)
        val field2 = view.findViewById<TextView>(R.id.tabscore1)
        val field3 = view.findViewById<TextView>(R.id.tabteam1)
        val field4 = view.findViewById<TextView>(R.id.time)



        val employee = employeeList[position]

        name.text = employee.Name
        field2.text = employee.field2
        field3.text = employee.field3
        field4.text = employee.field4


        return view
    }




}