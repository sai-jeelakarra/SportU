package com.sportu.androiddeveloper.lasttry.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*

import com.sportu.androiddeveloper.lasttry.R
import kotlinx.android.synthetic.main.fragment_stats.*


class StatsFragment : Fragment() {


    lateinit var ref : DatabaseReference
    var livenumber:String?="0"
    lateinit var team1string:String
    lateinit var team2string:String


    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView

    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_stats, container, false)

        livenumber = activity!!.intent.getStringExtra("livenumber")

        ref = FirebaseDatabase.getInstance().getReference("Stats")


        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView2 = view.findViewById(R.id.adView2)
        mAdView2.loadAd(adRequest)


        ref.child(livenumber).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){

                    try {

                        team1string = p0.child("Team1logo").getValue().toString()
                        team2string = p0.child("Team2logo").getValue().toString()

                        team1wins.text = p0.child("Team1wins").getValue().toString()
                        team2wins.text = p0.child("Team2wins").getValue().toString()
                        totalplayed.text = p0.child("Totalplayed").getValue().toString()
                        drawn.text = p0.child("Drawmatches").getValue().toString()



                        if (team1wins.text.toString()!=""&& team2wins.text.toString()!=""){

                            team1Progress.max = totalplayed.text.toString().toInt()-drawn.text.toString().toInt()
                            team2Progress.max = team1Progress.max


                            team2Progress.progress = (team2Progress.max-team1wins.text.toString().toInt())
                            team1Progress.progress = team2Progress.progress

                        }


                        keyplayers.text = p0.child("Keyplayers").getValue().toString()
                        predictedxi.text = p0.child("Predictedxi").getValue().toString()
                        pitchdetails.text = p0.child("Pitchdetails").getValue().toString()
                        teamnews.text = p0.child("Teamnews").getValue().toString()
                        others.text = p0.child("Others").getValue().toString()


                    }catch (e:Exception){
                        e.printStackTrace()

                    }

                    try {

                        Glide.with(context).load(team1string).into(team1logo)
                        Glide.with(context).load(team2string).into(team2logo)

                    }catch (e:Exception){
                        e.printStackTrace()

                    }


                }
            }

        })

        return view
    }
}
