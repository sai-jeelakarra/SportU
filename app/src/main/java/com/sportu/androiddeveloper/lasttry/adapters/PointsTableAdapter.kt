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
import com.sportu.androiddeveloper.lasttry.ui.PointsTable

class PointsTableAdapter (val mCtx : Context, val layoutId:Int, val employeeList:List<PointsTable>)
    : ArrayAdapter<PointsTable>(mCtx,layoutId,employeeList){

    var imagelink : String =""

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val teamname = view.findViewById<TextView>(R.id.teamname)
        val matches = view.findViewById<TextView>(R.id.matches)
        val wins = view.findViewById<TextView>(R.id.wins)
        val lost = view.findViewById<TextView>(R.id.lost)
        val points = view.findViewById<TextView>(R.id.points)
        val nrr = view.findViewById<TextView>(R.id.nrr)
        val teamlogo = view.findViewById<ImageView>(R.id.teamlogo)



        val employee = employeeList[position]

        teamname.text = employee.Teamname
        matches.text = employee.Matches
        wins.text = employee.Wins
        lost.text = employee.Lost
        points.text = employee.Points
        nrr.text = employee.Nrr
        imagelink = employee.Teamlogo

        Glide.with(context).load(imagelink).into(teamlogo)


        return view
    }




}