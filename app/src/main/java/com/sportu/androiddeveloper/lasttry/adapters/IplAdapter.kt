package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Ipl

class IplAdapter  (val mCtx : Context, val layoutId:Int, val employeeList:List<Ipl>)
    : ArrayAdapter<Ipl>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val team1string:String
        val team2string:String

        val date = view.findViewById<TextView>(R.id.date)
        val matchnumber = view.findViewById<TextView>(R.id.matchnumber)
        val title = view.findViewById<TextView>(R.id.tabtitle)
        val team2 = view.findViewById<TextView>(R.id.tabteam2)
        val team1 = view.findViewById<TextView>(R.id.tabteam1)
        val time = view.findViewById<TextView>(R.id.time)
        val place = view.findViewById<TextView>(R.id.place)
        val team1pic = view.findViewById<ImageView>(R.id.team1pic)
        val team2pic = view.findViewById<ImageView>(R.id.team2picture)



        val employee = employeeList[position]

        date.text = employee.Date
       matchnumber.text = "Match No. "+employee.Sno
        team1.text = employee.Team1
        team2.text = employee.Team2
        place.text = employee.Venue
        time.text = employee.Time

        team1string = employee.Team1pic
        team2string = employee.Team2pic

        Glide.with(context).load(team1string).into(team1pic)
        Glide.with(context).load(team2string).into(team2pic)

        return view
    }




}