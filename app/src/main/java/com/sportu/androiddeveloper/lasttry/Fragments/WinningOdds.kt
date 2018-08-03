package com.sportu.androiddeveloper.lasttry.Fragments

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*

import com.sportu.androiddeveloper.lasttry.R
import kotlinx.android.synthetic.main.fragment_winning_odds.*


class WinningOdds : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var oddsref : DatabaseReference
    lateinit var team1string:String
    lateinit var team2string:String
    lateinit var progressbar:String

    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView

    var livenumber:String?="0"


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_winning_odds, container, false)

        livenumber = activity!!.intent.getStringExtra("livenumber")

        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        mAdView2 = view.findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView2.loadAd(adRequest)



        oddsref = FirebaseDatabase.getInstance().getReference("Winningodds")

        oddsref.child(livenumber).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }
            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){

                    try {
                        team1odd.text = p0.child("Team1odd").getValue().toString()
                        team2odd.text = p0.child("Team2odd").getValue().toString()

                        team1percentage.text = p0.child("Team1percentage").getValue().toString()
                        progressbar = p0.child("Team1percentage").getValue().toString()

                        if(progressbar!=""||progressbar!="0") {
                            myProgress.progress = (progressbar.toFloat() * 100).toInt()
                            myProgress.secondaryProgress = 10000

                        }
                        if(progressbar!="")
                        team2percentage.text = (100 - progressbar.toFloat()).toString()
                        else
                            team2percentage.text = ""



                        one.text = p0.child("One").getValue().toString()
                        two.text = p0.child("Two").getValue().toString()
                        three.text = p0.child("Three").getValue().toString()
                        four.text = p0.child("Four").getValue().toString()
                        five.text = p0.child("Five").getValue().toString()

                        predictedWinner.text = p0.child("Predictedwinner").getValue().toString()



                        team1string = p0.child("Team1pic").getValue().toString()
                        team2string = p0.child("Team2pic").getValue().toString()


                        Glide.with(context).load(team1string).into(team1pic2)
                        Glide.with(context).load(team2string).into(team2pic2)

                    }catch (e:Exception){
                        e.printStackTrace()

                    }

                }
            }
        })


        return view
    }


}
