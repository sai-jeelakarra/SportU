package com.sportu.androiddeveloper.lasttry.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.ads.*
import com.sportu.androiddeveloper.lasttry.R
import com.google.firebase.database.*
import com.sportu.androiddeveloper.lasttry.adapters.TeamRankingsAdapter
import com.sportu.androiddeveloper.lasttry.ui.Teams
import kotlinx.android.synthetic.main.activity_team_rankings.*
import java.util.*

class TeamRankingsActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<Teams>
    lateinit var listview: ListView


    private lateinit var mAdView: AdView

    private lateinit var interstitial: InterstitialAd


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_rankings)


        MobileAds.initialize(this,myAppId)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        Toast.makeText(this, "Team Rankings", Toast.LENGTH_SHORT).show()

        employeeList = mutableListOf()
        listview = findViewById(R.id.listview1)
        val loader : ProgressBar = findViewById(R.id.loader)

        listview.emptyView = loader

        ref = FirebaseDatabase.getInstance().getReference("Rankings")

        ref.child("Team").child("Test").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    employeeList.clear()
                    for (e in p0.children){
                        val employee = e.getValue(Teams::class.java)
                        employeeList.add(employee!!)
                    }
                    val adapter = TeamRankingsAdapter(this@TeamRankingsActivity,R.layout.rankings,employeeList)
                    listview.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }

        })



        val test : Button = findViewById(R.id.test)
        val odi : Button = findViewById(R.id.odi)
        val t20 : Button = findViewById(R.id.t20)




        test.setBackgroundResource(R.drawable.buttons_background_color)
        odi.setBackgroundResource(R.drawable.button_round_gray)
        t20.setBackgroundResource(R.drawable.button_round_gray)
        women.setBackgroundResource(R.drawable.button_round_gray)


        test.setOnClickListener{


            test.setBackgroundResource(R.drawable.buttons_background_color)
            odi.setBackgroundResource(R.drawable.button_round_gray)
            t20.setBackgroundResource(R.drawable.button_round_gray)
            women.setBackgroundResource(R.drawable.button_round_gray)


            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Rankings")

            ref.child("Team").child("Test").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Teams::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = TeamRankingsAdapter(this@TeamRankingsActivity,R.layout.rankings,employeeList)
                        listview1.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }

            })
        }
        odi.setOnClickListener{

            odi.setBackgroundResource(R.drawable.buttons_background_color)
            test.setBackgroundResource(R.drawable.button_round_gray)
            t20.setBackgroundResource(R.drawable.button_round_gray)
            women.setBackgroundResource(R.drawable.button_round_gray)

            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Rankings")

            ref.child("Team").child("Odi").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Teams::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = TeamRankingsAdapter(this@TeamRankingsActivity,R.layout.rankings,employeeList)
                        listview1.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }

            })
        }
        t20.setOnClickListener{

            t20.setBackgroundResource(R.drawable.buttons_background_color)
            odi.setBackgroundResource(R.drawable.button_round_gray)
            test.setBackgroundResource(R.drawable.button_round_gray)
            women.setBackgroundResource(R.drawable.button_round_gray)

            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Rankings")

            ref.child("Team").child("T20").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Teams::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = TeamRankingsAdapter(this@TeamRankingsActivity,R.layout.rankings,employeeList)
                        listview1.adapter = adapter
                        adapter.notifyDataSetChanged()
                    }
                }

            })
        }

        women.setOnClickListener{

            women.setBackgroundResource(R.drawable.buttons_background_color)
            odi.setBackgroundResource(R.drawable.button_round_gray)
            t20.setBackgroundResource(R.drawable.button_round_gray)
            test.setBackgroundResource(R.drawable.button_round_gray)

            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Rankings")

            ref.child("Team").child("Women").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Teams::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = TeamRankingsAdapter(this@TeamRankingsActivity,R.layout.rankings,employeeList)
                        listview1.adapter = adapter
                        adapter.notifyDataSetChanged()
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
