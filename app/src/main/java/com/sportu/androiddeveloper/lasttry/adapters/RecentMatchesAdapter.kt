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
import com.sportu.androiddeveloper.lasttry.ui.Recents

class RecentMatchesAdapter(val mCtx : Context, val layoutId:Int, val employeeList:List<Recents>)
    : ArrayAdapter<Recents>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val team1string:String
        val team2string:String

        val score1 = view.findViewById<TextView>(R.id.tabscore1)
        val score2 = view.findViewById<TextView>(R.id.score2)
        val team2 = view.findViewById<TextView>(R.id.tabteam2)
        val team1 = view.findViewById<TextView>(R.id.tabteam1)
        val time = view.findViewById<TextView>(R.id.time)
        val place = view.findViewById<TextView>(R.id.place)
        val team1pic = view.findViewById<ImageView>(R.id.team1pic)
        val team2pic = view.findViewById<ImageView>(R.id.team2picture)

        val employee = employeeList[position]

        score1.text = employee.Score1
        score2.text = employee.Score2
        team1.text = employee.Team1
        team2.text = employee.Team2
        place.text = employee.Result
        time.text = employee.Date

        team1string = employee.Team1pic
        team2string = employee.Team2pic

        Glide.with(context).load(team1string).into(team1pic)
        Glide.with(context).load(team2string).into(team2pic)



        return view
    }




}