package com.sportu.androiddeveloper.lasttry.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar
import com.google.android.gms.ads.*
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.IplAdapter
import com.sportu.androiddeveloper.lasttry.adapters.UpcomingAdapter
import com.sportu.androiddeveloper.lasttry.ui.Ipl
import com.sportu.androiddeveloper.lasttry.ui.Upcomings
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_upcoming.*
import java.util.*

class UpcomingActivity : AppCompatActivity() {

    private lateinit var mAdView: AdView
    private lateinit var interstitial: InterstitialAd

    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<Upcomings>
    lateinit var listview: ListView
    lateinit var iplList:MutableList<Ipl>


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upcoming)

        MobileAds.initialize(this,myAppId)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        employeeList = mutableListOf()
        listview = findViewById(R.id.listview1)
        ref = FirebaseDatabase.getInstance().getReference("Upcomingmatches")



        val loader : ProgressBar = findViewById(R.id.loader)

        listview.emptyView = loader

        ref.child("International").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try {
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Upcomings::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = UpcomingAdapter(this@UpcomingActivity,R.layout.upcomings,employeeList)
                        listview.adapter = adapter
                    }catch (e:Exception){
                        e.printStackTrace()
                    }

                }
            }

        })

        international.setTextColor(Color.WHITE)
        t20leagues.setTextColor(Color.BLACK)
        domestic.setTextColor(Color.BLACK)
        women.setTextColor(Color.BLACK)

        international.setOnClickListener {


            international.setTextColor(Color.WHITE)
            t20leagues.setTextColor(Color.BLACK)
            domestic.setTextColor(Color.BLACK)
            women.setTextColor(Color.BLACK)


            employeeList.clear()
            employeeList = mutableListOf()
            listview = findViewById(R.id.listview1)
            ref = FirebaseDatabase.getInstance().getReference("Upcomingmatches")

            ref.child("International").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {
                            employeeList.clear()
                            for (e in p0.children){
                                val employee = e.getValue(Upcomings::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = UpcomingAdapter(this@UpcomingActivity,R.layout.upcomings,employeeList)
                            listview.adapter = adapter
                        }catch (e:Exception){
                            e.printStackTrace()
                        }

                    }
                }

            })

        }


        domestic.setOnClickListener {
            international.setTextColor(Color.BLACK)
            domestic.setTextColor(Color.WHITE)
            women.setTextColor(Color.BLACK)
            t20leagues.setTextColor(Color.BLACK)



            employeeList.clear()
            employeeList = mutableListOf()
            listview = findViewById(R.id.listview1)
            ref = FirebaseDatabase.getInstance().getReference("Upcomingmatches")

            ref.child("Domestic").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {
                            employeeList.clear()
                            for (e in p0.children){
                                val employee = e.getValue(Upcomings::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = UpcomingAdapter(this@UpcomingActivity,R.layout.upcomings,employeeList)
                            listview.adapter = adapter
                        }catch (e:Exception){
                            e.printStackTrace()
                        }


                    }
                }

            })

        }

        women.setOnClickListener {

            international.setTextColor(Color.BLACK)
            domestic.setTextColor(Color.BLACK)
            women.setTextColor(Color.WHITE)
            t20leagues.setTextColor(Color.BLACK)



            employeeList.clear()
            employeeList = mutableListOf()
            listview = findViewById(R.id.listview1)
            ref = FirebaseDatabase.getInstance().getReference("Upcomingmatches")

            ref.child("Women").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        try {
                            employeeList.clear()
                            for (e in p0.children){
                                val employee = e.getValue(Upcomings::class.java)
                                employeeList.add(employee!!)
                            }
                            val adapter = UpcomingAdapter(this@UpcomingActivity,R.layout.upcomings,employeeList)
                            listview.adapter = adapter
                        }catch (e:Exception){
                            e.printStackTrace()
                        }


                    }
                }

            })

        }





        t20leagues.setOnClickListener {
            employeeList.clear()

            iplList = mutableListOf()


            international.setTextColor(Color.BLACK)
            domestic.setTextColor(Color.BLACK)
            women.setTextColor(Color.BLACK)
            t20leagues.setTextColor(Color.WHITE)

            listview = findViewById(R.id.listview1)
            ref = FirebaseDatabase.getInstance().getReference("Upcomingmatches")

            ref.child("T20leagues").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){

                        try {
                            employeeList.clear()

                            for (e in p0.children){
                                val employee = e.getValue(Ipl::class.java)
                                iplList.add(employee!!)
                            }
                            val adapter = IplAdapter(this@UpcomingActivity,R.layout.ipl,iplList)
                            listview.adapter = adapter
                        }catch (e:Exception){
                            e.printStackTrace()
                        }



                    }
                }

            })

        }

        // Create the interstitial.
        interstitial = InterstitialAd(this)
        interstitial.adUnitId = "ca-app-pub-2636513564663257/3522964462"
        loadinterstitial()

        // Listener for Ad
        interstitial.adListener = object : AdListener() {
            // When Closed Ad, Load new Ad
            override fun onAdClosed() {
                super.onAdClosed()
                loadinterstitial()
            }
        }


    }

    private fun loadinterstitial() {
        // Create ad request.
        val adRequest = AdRequest.Builder().build()

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest)
    }

    // Show Interstitial Ad
    private fun showInterstitialAd() {
        // return, if Ad data is no loaded
        if (!interstitial.isLoaded) {
            return
        }

        // Show Ad
        interstitial.show()
    }

    // Back button
    override fun onBackPressed() {
        super.onBackPressed()

        // Make rand
        val rnd = Random()

        // Omikuji
        val Omikuji = rnd.nextInt(1)
        if (Omikuji == 0) {
            // Go to Show Interstitial Ad
            showInterstitialAd()
        }

    }

}

