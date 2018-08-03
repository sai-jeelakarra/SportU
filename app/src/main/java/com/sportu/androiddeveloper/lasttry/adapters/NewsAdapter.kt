package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.activities.NewsActivity
import com.sportu.androiddeveloper.lasttry.ui.News

class NewsAdapter (val mCtx : Context, val layoutId:Int, val employeeList:List<News>)
    : ArrayAdapter<News>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val imagelink:String

        val date = view.findViewById<TextView>(R.id.date)
        val title = view.findViewById<TextView>(R.id.title)
        val image = view.findViewById<ImageView>(R.id.image)

        val employee = employeeList[position]

        date.text = employee.Date
        title.text = employee.Title

        imagelink = employee.Image

        Glide.with(context).load(imagelink).into(image)





        return view
    }
}