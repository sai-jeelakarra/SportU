package com.sportu.androiddeveloper.lasttry.adapters

import android.content.Context
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.ui.Overs

class OversAdapter(val mCtx : Context, val layoutId:Int, val employeeList:List<Overs>)
    : ArrayAdapter<Overs>(mCtx,layoutId,employeeList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater : LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(layoutId,null)

        val overstext = view.findViewById<TextView>(R.id.overstext)
        val first = view.findViewById<TextView>(R.id.first)
        val second = view.findViewById<TextView>(R.id.second)
        val third = view.findViewById<TextView>(R.id.third)
        val fourth = view.findViewById<TextView>(R.id.fourth)
        val fifth = view.findViewById<TextView>(R.id.fifth)
        val sixth = view.findViewById<TextView>(R.id.sixth)
        val seventh = view.findViewById<TextView>(R.id.seventh)
        val eigth = view.findViewById<TextView>(R.id.eigth)
        val nineth = view.findViewById<TextView>(R.id.nineth)
        val tenth = view.findViewById<TextView>(R.id.tenth)
        val runscount = view.findViewById<TextView>(R.id.runscount)


        val scorecardlayout = view.findViewById<ConstraintLayout>(R.id.overslayout)

        if (position%2==0){

            scorecardlayout.setBackgroundResource(R.drawable.background_blur_square)

        }

        val employee = employeeList[position]

        overstext.text = employee.Overstext
        first.text = employee.First
        second.text = employee.Second
        third.text = employee.Third
        fourth.text = employee.Fourth
        fifth.text = employee.Fifth
        sixth.text = employee.Sixth
        seventh.text = employee.Seventh
        eigth.text = employee.Eighth
        nineth.text = employee.Nineth
        tenth.text = employee.Tenth
        runscount.text = employee.Runscount



        if (first.text !=""){
            if (first.text.length>1){
                first.textSize = 10f
            }
            first.visibility = View.VISIBLE
        }else first.visibility = View.INVISIBLE
        if (second.text !=""){
            if (second.text.length>1){
                second.textSize = 10f
            }
            second.visibility = View.VISIBLE
        }else second.visibility = View.INVISIBLE
        if (third.text !=""){
            if (third.text.length>1){
                third.textSize = 10f
            }
            third.visibility = View.VISIBLE
        }else third.visibility = View.INVISIBLE
        if (fourth.text !=""){
            if (fourth.text.length>1){
                fourth.textSize = 10f
            }
            fourth.visibility = View.VISIBLE
        }else fourth.visibility = View.INVISIBLE
        if (fifth.text !=""){
            if (fifth.text.length>1){
                fifth.textSize = 10f
            }
            fifth.visibility = View.VISIBLE
        }else fifth.visibility = View.INVISIBLE
        if (sixth.text !=""){
            if (sixth.text.length>1){
                sixth.textSize = 10f
            }
            sixth.visibility = View.VISIBLE
        }else sixth.visibility = View.INVISIBLE
        if (seventh.text !=""){
            if (seventh.text.length>1){
                seventh.textSize = 10f
            }
            seventh.visibility = View.VISIBLE
        }else seventh.visibility = View.INVISIBLE
        if (eigth.text !=""){
            if (eigth.text.length>1){
                eigth.textSize = 10f
            }
            eigth.visibility = View.VISIBLE
        }else eigth.visibility = View.INVISIBLE
        if (nineth.text !=""){
            if (nineth.text.length>1){
                nineth.textSize = 10f
            }
            nineth.visibility = View.VISIBLE
        }else nineth.visibility = View.INVISIBLE
        if (tenth.text !=""){
            if (tenth.text.length>1){
                tenth.textSize = 10f
            }
            tenth.visibility = View.VISIBLE
        }else tenth.visibility = View.INVISIBLE


        if (overstext.text !=""){
            overstext.visibility = View.VISIBLE
            runscount.visibility = View.VISIBLE
        }else {
            overstext.visibility = View.INVISIBLE
            runscount.visibility = View.INVISIBLE
        }


        if (first.text=="W"){
            first.setTextColor(Color.WHITE)
            first.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (first.text=="4"||first.text=="6"){
            first.setTextColor(Color.BLACK)
            first.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            first.setTextColor(Color.BLACK)
            first.setBackgroundResource(R.drawable.button_round_white)
        }

        if (second.text=="W"){
            second.setTextColor(Color.WHITE)
            second.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (second.text=="4"||second.text=="6"){
            second.setTextColor(Color.BLACK)
            second.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            second.setTextColor(Color.BLACK)
            second.setBackgroundResource(R.drawable.button_round_white)
        }
        if (third.text=="W"){
            third.setTextColor(Color.WHITE)
            third.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (third.text=="4"||third.text=="6"){
            third.setTextColor(Color.BLACK)
            third.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            third.setTextColor(Color.BLACK)
            third.setBackgroundResource(R.drawable.button_round_white)
        }
        if (fourth.text=="W"){
            fourth.setTextColor(Color.WHITE)
            fourth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (fourth.text=="4"||fourth.text=="6"){
            fourth.setTextColor(Color.BLACK)
            fourth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            fourth.setTextColor(Color.BLACK)
            fourth.setBackgroundResource(R.drawable.button_round_white)
        }
        if (fifth.text=="W"){
            fifth.setTextColor(Color.WHITE)
            fifth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (fifth.text=="4"||fifth.text=="6"){
            fifth.setTextColor(Color.BLACK)
            fifth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            fifth.setTextColor(Color.BLACK)
            fifth.setBackgroundResource(R.drawable.button_round_white)
        }

        if (sixth.text=="W"){
            sixth.setTextColor(Color.WHITE)
            sixth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (sixth.text=="4"||sixth.text=="6"){
            sixth.setTextColor(Color.BLACK)
            sixth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            sixth.setTextColor(Color.BLACK)
            sixth.setBackgroundResource(R.drawable.button_round_white)
        }
        if (seventh.text=="W"){
            seventh.setTextColor(Color.WHITE)
            seventh.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (seventh.text=="4"||seventh.text=="6"){
            seventh.setTextColor(Color.BLACK)
            seventh.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            seventh.setTextColor(Color.BLACK)
            seventh.setBackgroundResource(R.drawable.button_round_white)
        }

        if (eigth.text=="W"){
            eigth.setTextColor(Color.WHITE)
            eigth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (eigth.text=="4"||eigth.text=="6"){
            eigth.setTextColor(Color.BLACK)
            eigth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            eigth.setTextColor(Color.BLACK)
            eigth.setBackgroundResource(R.drawable.button_round_white)
        }
        if (nineth.text=="W"){
            nineth.setTextColor(Color.WHITE)
            nineth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (nineth.text=="4"||nineth.text=="6"){
            nineth.setTextColor(Color.BLACK)
            nineth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            nineth.setTextColor(Color.BLACK)
            nineth.setBackgroundResource(R.drawable.button_round_white)
        }

        if (tenth.text=="W"){
            tenth.setTextColor(Color.WHITE)
            tenth.setBackgroundResource(R.drawable.button_round_red)
        }
        else if (tenth.text=="4"||tenth.text=="6"){
            tenth.setTextColor(Color.BLACK)
            tenth.setBackgroundResource(R.drawable.button_round_green)
        }
        else{
            tenth.setTextColor(Color.BLACK)
            tenth.setBackgroundResource(R.drawable.button_round_white)
        }




        return view
    }




}