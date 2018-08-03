package com.sportu.androiddeveloper.lasttry.Fragments


import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.database.*

import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.OversAdapter
import com.sportu.androiddeveloper.lasttry.ui.Overs


class OversFragment : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var teamref : DatabaseReference
    lateinit var employeeList:MutableList<Overs>
    lateinit var listview: ListView

    var livenumber:String?="0"

    private lateinit var mAdView: AdView


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view:View =inflater.inflate(R.layout.fragment_overs, container, false)

        livenumber = activity!!.intent.getStringExtra("livenumber")
        employeeList = mutableListOf()
        listview = view.findViewById(R.id.overslist)
        ref = FirebaseDatabase.getInstance().getReference("Overs")
        teamref = FirebaseDatabase.getInstance().getReference("Info")

        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        val nameofteam1 : Button = view.findViewById(R.id.nameofteam1)
        val nameofteam2 : Button = view.findViewById(R.id.nameofteam2)




        ref.child(livenumber).child("Team1").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){

                    try {
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Overs::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = OversAdapter(context!!,R.layout.overs_list,employeeList)
                        listview.adapter = adapter
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

            ref.child(livenumber).child("Team1").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){

                        try {
                            employeeList.clear()
                            for (e in p0.children){
                                val employee = e.getValue(Overs::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = OversAdapter(context!!,R.layout.overs_list,employeeList)
                            listview.adapter = adapter
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


            ref.child(livenumber).child("Team2").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){

                        try {
                            employeeList.clear()
                            for (e in p0.children){
                                val employee = e.getValue(Overs::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = OversAdapter(context!!,R.layout.overs_list,employeeList)
                            listview.adapter = adapter
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
