package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.BowlerScorecard

class BowlerScorecardAdapter(val mCtx : Context, val layoutId:Int, val employeeList:List<BowlerScorecard>)
    : ArrayAdapter<BowlerScorecard>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val batsmen = view.findViewById<TextView>(R.id.batsmen)
        val one = view.findViewById<TextView>(R.id.totalruns)
        val two = view.findViewById<TextView>(R.id.totalballs)
        val three = view.findViewById<TextView>(R.id.fours)
        val four = view.findViewById<TextView>(R.id.sixes)
        val five = view.findViewById<TextView>(R.id.strikerate)
        val outbowler = view.findViewById<TextView>(R.id.outbybowler)

        val scorecardlayout = view.findViewById<ConstraintLayout>(R.id.scorecardlayout)

        if (position%2==0){

            scorecardlayout.setBackgroundResource(R.drawable.background_blur_square)

        }

        val employee = employeeList[position]


        batsmen.text = employee.Batsmen
        one.text = employee.Runs
        two.text = employee.Balls
        three.text = employee.Fours
        four.text = employee.Sixes
        five.text = employee.Strikerate
        outbowler.text = employee.Outbybowler

//        if (batsmen.text == "Batsmen" || batsmen.text == "Bowlers"){
//            scorecardlayout.setBackgroundResource(R.color.sai)
//            batsmen.setTextSize(TypedValue.COMPLEX_UNIT_PX,40f)
//            batsmen.setTextColor(Color.BLACK)
//        }


        return view
    }




}