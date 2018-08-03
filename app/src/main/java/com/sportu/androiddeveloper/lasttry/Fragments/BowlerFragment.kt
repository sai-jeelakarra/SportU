package com.sportu.androiddeveloper.lasttry.Fragments


import android.content.Context
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

import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.RankingsAdapter
import com.sportu.androiddeveloper.lasttry.ui.Rankings
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_ranking.*


class BowlerFragment : Fragment(),View.OnClickListener {


    private lateinit var mAdView: AdView


    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<Rankings>
    lateinit var listview: ListView
    var ranktype:String?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view:View = inflater.inflate(R.layout.fragment_ranking, container, false)

        val context: Context?

        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713")

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        context = container!!.context
        ranktype = activity!!.intent.getStringExtra("type")

        employeeList = mutableListOf()
        // listview = view.findViewById(R.id.listview1)
        ref = FirebaseDatabase.getInstance().getReference("Rankings")

        if (ranktype=="Men's Rankings") {
         //   test.visibility= View.VISIBLE
            ref.child("Men").child("Bowler").child("Test").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }
                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()) {
                        try {
                            employeeList.clear()
                            for (e in p0.children) {
                                val employee = e.getValue(Rankings::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = RankingsAdapter(context, R.layout.player_rankings, employeeList)
                            listview1.adapter = adapter
                            adapter.notifyDataSetChanged()
                        }catch (e:Exception){
                            e.printStackTrace()

                        }

                    }
                }

            })
        }else if (ranktype=="Women's Rankings"){

          //  test.visibility= View.INVISIBLE

            ref.child("Women").child("Bowler").child("Test").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }
                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()) {
                        try {
                            employeeList.clear()
                            for (e in p0.children) {
                                val employee = e.getValue(Rankings::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = RankingsAdapter(context, R.layout.player_rankings, employeeList)
                            listview1.adapter = adapter
                            adapter.notifyDataSetChanged()
                        }catch (e:Exception){
                            e.printStackTrace()

                        }

                    }
                }

            })
        }

        val test : Button = view.findViewById(R.id.test)
        val odi : Button = view.findViewById(R.id.odi)
        val t20 : Button = view.findViewById(R.id.t20)

        test.setOnClickListener(this)
        odi.setOnClickListener(this)
        t20.setOnClickListener(this)


        test.setBackgroundResource(R.drawable.buttons_background_color)
        odi.setBackgroundResource(R.drawable.button_round_gray)
        t20.setBackgroundResource(R.drawable.button_round_gray)





        return view
    }
    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.test -> {


                test.setBackgroundResource(R.drawable.buttons_background_color)
                odi.setBackgroundResource(R.drawable.button_round_gray)
                t20.setBackgroundResource(R.drawable.button_round_gray)

                employeeList.clear()

                employeeList = mutableListOf()
                if (ranktype=="Men's Rankings") {
                    ref.child("Men").child("Bowler").child("Test").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }else if (ranktype=="Women's Rankings"){

                    ref.child("Women").child("Bowler").child("Test").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }
            }
            R.id.odi ->{

                odi.setBackgroundResource(R.drawable.buttons_background_color)
                test.setBackgroundResource(R.drawable.button_round_gray)
                t20.setBackgroundResource(R.drawable.button_round_gray)
                employeeList.clear()

                employeeList = mutableListOf()
                if (ranktype=="Men's Rankings") {
                    ref.child("Men").child("Bowler").child("Odi").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }else if (ranktype=="Women's Rankings"){

                    ref.child("Women").child("Bowler").child("Odi").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }
            }
            R.id.t20 ->{

                t20.setBackgroundResource(R.drawable.buttons_background_color)
                odi.setBackgroundResource(R.drawable.button_round_gray)
                test.setBackgroundResource(R.drawable.button_round_gray)

                employeeList.clear()

                employeeList = mutableListOf()
                if (ranktype=="Men's Rankings") {
                    ref.child("Men").child("Bowler").child("T20").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }else if (ranktype=="Women's Rankings"){

                    ref.child("Women").child("Bowler").child("T20").addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(p0: DatabaseError?) {
                        }
                        override fun onDataChange(p0: DataSnapshot?) {
                            if (p0!!.exists()) {
                                try {
                                    employeeList.clear()
                                    for (e in p0.children) {
                                        val employee = e.getValue(Rankings::class.java)
                                        employeeList.add(employee!!)
                                    }
                                    val adapter = RankingsAdapter(context!!, R.layout.player_rankings, employeeList)
                                    listview1.adapter = adapter
                                    adapter.notifyDataSetChanged()
                                }catch (e:Exception){
                                    e.printStackTrace()

                                }

                            }
                        }

                    })
                }
            }

            else -> {
            }

        }

    }

}
