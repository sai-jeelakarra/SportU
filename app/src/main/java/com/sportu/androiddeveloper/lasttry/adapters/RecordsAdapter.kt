package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Records

class RecordsAdapter (val mCtx : Context, val layoutId:Int, val employeeList:List<Records>)
    : ArrayAdapter<Records>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val name = view.findViewById<TextView>(R.id.name)
        val one = view.findViewById<TextView>(R.id.one)
        val two = view.findViewById<TextView>(R.id.two)
        val three = view.findViewById<TextView>(R.id.three)
        val four = view.findViewById<TextView>(R.id.four)






        val employee = employeeList[position]

        name.text = employee.Name
        one.text = employee.field2
        two.text = employee.field3
        three.text = employee.field4
        four.text = employee.field5



        return view
    }




}