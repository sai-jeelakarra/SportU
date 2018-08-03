package com.sportu.androiddeveloper.lasttry.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.sportu.androiddeveloper.lasttry.R
import com.google.firebase.database.*
import com.sportu.androiddeveloper.lasttry.R.string.app_id
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment() {
    lateinit var ref : DatabaseReference
    lateinit var oddref : DatabaseReference


    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView

    lateinit var team1string:String
    lateinit var team2string:String

    var livenumber:String?="0"

    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_info, container, false)


        livenumber = activity!!.intent.getStringExtra("livenumber")


        val team1pic = view.findViewById<ImageView>(R.id.team1pic)
        val team2pic = view.findViewById<ImageView>(R.id.team2picture)

        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView2 = view.findViewById(R.id.adView2)
        mAdView2.loadAd(adRequest)

        ref = FirebaseDatabase.getInstance().getReference("Info")



            ref.child(livenumber).addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }
                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){


                        try {
                            tabteam1.text = p0.child("Team1").getValue().toString()
                            tabteam2.text = p0.child("Team2").getValue().toString()
                            team1name.text = p0.child("Team1fullname").getValue().toString()
                            team2name.text = p0.child("Team2fullname").getValue().toString()
                            series.text = p0.child("Series").getValue().toString()
                            match.text = p0.child("Match").getValue().toString()
                            date.text = p0.child("Date").getValue().toString()
                            venue.text = p0.child("Venue").getValue().toString()
                            toss.text = p0.child("Toss").getValue().toString()
                            umpire.text = p0.child("Umpire").getValue().toString()
                            thirdumpire.text = p0.child("Thirdumpire").getValue().toString()
                            team1playerslist.text = p0.child("Team1xi").getValue().toString()
                            team2playerslist.text = p0.child("Team2xi").getValue().toString()

                            team1odd.text = p0.child("Team1odd").getValue().toString()
                            team2odd.text = p0.child("Team2odd").getValue().toString()

                            team1string = p0.child("Team1pic").getValue().toString()
                            team2string = p0.child("Team2pic").getValue().toString()

                        }catch (e:Exception){
                            e.printStackTrace()

                        }

                        try {

                            Glide.with(context).load(team1string).into(team1pic)
                            Glide.with(context).load(team2string).into(team2pic)

                        }catch (e:Exception){
                            e.printStackTrace()

                        }








                    }
                    }
                })



        return view
    }


}
