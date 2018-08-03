package com.sportu.androiddeveloper.lasttry.Fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.database.*
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.BatsmenScorecardAdapter
import com.sportu.androiddeveloper.lasttry.ui.BatsmenScorecard
import android.widget.*
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.sportu.androiddeveloper.lasttry.adapters.BowlerScorecardAdapter
import com.sportu.androiddeveloper.lasttry.ui.BowlerScorecard




class ScoreCard : Fragment() {


    lateinit var ref : DatabaseReference
    lateinit var teamref : DatabaseReference
    lateinit var batsmenemployeeList:MutableList<BatsmenScorecard>
    lateinit var bowlersemployeeList:MutableList<BowlerScorecard>
    lateinit var listview: ListView
    lateinit var listview2: ListView


    private lateinit var mAdView: AdView

    var livenumber:String?="0"


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.scorecard_fragment, container, false)


        livenumber = activity!!.intent.getStringExtra("livenumber")

        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val context: Context?

        context = container!!.context

        batsmenemployeeList = mutableListOf()
        bowlersemployeeList = mutableListOf()

        listview = view.findViewById(R.id.batsmenlist)
        listview2 = view.findViewById(R.id.bowlerlist)

       teamref = FirebaseDatabase.getInstance().getReference("Info")
        ref = FirebaseDatabase.getInstance().getReference("Scorecard")

        val nameofteam1 : Button = view.findViewById(R.id.nameofteam1)
        val nameofteam2 : Button = view.findViewById(R.id.nameofteam2)




        ref.child(livenumber).child("Team1").child("Batsmen").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try {
                    batsmenemployeeList.clear()
                    for (e in p0.children){
                        val employee = e.getValue(BatsmenScorecard::class.java)
                        batsmenemployeeList.add(employee!!)
                    }
                    val adapter =BatsmenScorecardAdapter(context,R.layout.scorecard,batsmenemployeeList)
                    listview.adapter = adapter
                }catch (e:Exception){
                    e.printStackTrace()
                        Toast.makeText(context, "Network Error!", Toast.LENGTH_SHORT).show()

                    }
                }
            }

        })

        ref.child(livenumber).child("Team1").child("Bowlers").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try {


                    bowlersemployeeList.clear()
                    for (e in p0.children){
                        val employee = e.getValue(BowlerScorecard::class.java)
                        bowlersemployeeList.add(employee!!)
                    }
                    val adapter =BowlerScorecardAdapter(context,R.layout.scorecard,bowlersemployeeList)
                    listview2.adapter = adapter
                    adapter.notifyDataSetChanged()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }

        })


        teamref.child(livenumber).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try{
                        nameofteam1.text = p0.child("Team1").getValue().toString()
                        nameofteam2.text = p0.child("Team2").getValue().toString()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }

        })



        nameofteam1.setBackgroundResource(R.drawable.buttons_background_color)
        nameofteam2.setBackgroundResource(R.drawable.button_round_gray)



        nameofteam1.setOnClickListener {


            nameofteam1.setBackgroundResource(R.drawable.buttons_background_color)
            nameofteam2.setBackgroundResource(R.drawable.button_round_gray)

            ref.child(livenumber).child("Team1").child("Batsmen").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {

                        batsmenemployeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(BatsmenScorecard::class.java)
                            batsmenemployeeList.add(employee!!)
                        }
                        val adapter =BatsmenScorecardAdapter(context,R.layout.scorecard,batsmenemployeeList)
                        listview.adapter = adapter
                        adapter.notifyDataSetChanged()
                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }
                }

            })

            ref.child(livenumber).child("Team1").child("Bowlers").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {


                       bowlersemployeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(BowlerScorecard::class.java)
                            bowlersemployeeList.add(employee!!)
                        }
                        val adapter =BowlerScorecardAdapter(context,R.layout.scorecard,bowlersemployeeList)
                        listview2.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                    }
                }

            })
        }

        nameofteam2.setOnClickListener {


            nameofteam2.setBackgroundResource(R.drawable.buttons_background_color)
            nameofteam1.setBackgroundResource(R.drawable.button_round_gray)

            ref.child(livenumber).child("Team2").child("Batsmen").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {


                        batsmenemployeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(BatsmenScorecard::class.java)
                            batsmenemployeeList.add(employee!!)
                        }
                        val adapter =BatsmenScorecardAdapter(context,R.layout.scorecard,batsmenemployeeList)
                        listview.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                    }
                }

            })

            ref.child(livenumber).child("Team2").child("Bowlers").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {


                        bowlersemployeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(BowlerScorecard::class.java)
                            bowlersemployeeList.add(employee!!)
                        }
                        val adapter =BowlerScorecardAdapter(context,R.layout.scorecard,bowlersemployeeList)
                        listview2.adapter = adapter
                        adapter.notifyDataSetChanged()
                        }catch (e:Exception){
                            e.printStackTrace()
                        }
                    }
                }

            })
        }



        return view
    }




}