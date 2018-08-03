package com.sportu.androiddeveloper.lasttry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_foot_ball.*

class FootBallActivity : AppCompatActivity() {

    lateinit var type: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foot_ball)

        type = intent.getStringExtra("type")

        try {
            if (type=="football"){
                comingLayout.setBackgroundResource(R.drawable.football_coming_soon)
            }else if(type=="kabaddi"){
                comingLayout.setBackgroundResource(R.drawable.kabaddi_comin_soon)
            }
            else if(type=="horse"){
                comingLayout.setBackgroundResource(R.drawable.horse_coming_soon)
            }

        }
        catch (e:Exception){
            e.printStackTrace()
        }



    }
}
