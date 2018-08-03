package com.sportu.androiddeveloper.lasttry.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.ads.*
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.RecordsAdapter
import com.sportu.androiddeveloper.lasttry.ui.Records
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_records.*
import java.util.*

class RecordsActivity : AppCompatActivity(),RewardedVideoAdListener {


    private lateinit var mAdView: AdView
    private lateinit var interstitial: InterstitialAd

    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<Records>
    lateinit var listview: ListView

    lateinit var type : String
    lateinit var gender : String
    lateinit var tree:String


    lateinit var mRewardedVideoAd: RewardedVideoAd


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_records)


        //reward video
        MobileAds.initialize(this, "ca-app-pub-2636513564663257/5415464782")

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        mRewardedVideoAd.rewardedVideoAdListener = this



        loadRewardedVideoAd()












        MobileAds.initialize(this,myAppId)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)




        type = intent.getStringExtra("type")
        gender = intent.getStringExtra("gender")


        if (type=="Highestruns"){
            titletext.text = "Highest Runs"
                    four.text = "Avg"

        }else if(type=="Battingaverage"){
            titletext.text = "Batting Average"
                    four.text ="Avg"
        }
        else if(type=="Beststrikerate"){
            titletext.text ="Best StrikeRate"
                    four.text ="SR"
        }
        else if(type=="Mosthundreds"){
            titletext.text ="Most Hundreds"
                    four.text ="100s"
        }
        else if(type=="Mostfifties"){
            titletext.text ="Most Fifties"
                    four.text ="50s"
        }
        else if(type=="Mostfours"){
            titletext.text = "Most Fours"
                    four.text ="4s"
        }else if(type=="Mostsixes"){
            titletext.text ="Most Sixes"
                    four.text ="6s"
        }
        else if(type=="Highestscore"){
            titletext.text ="Highest Score"
                    four.text ="Vs"
        }
        else if(type=="Bestbowlingaverage"){
            titletext.text ="Best Bowling Average"
                    two.text = "O"
            three.text = "W"
            four.text ="Avg"
        }else if(type=="Most5wickethauls"){
            titletext.text ="Most 5 Wicket Hauls"
                    two.text = "O"
            three.text = "W"
            four.text ="5wkts"
        }else if(type=="Besteconomy"){
            titletext.text ="Best Economy"
                    two.text = "O"
            three.text = "W"
            four.text ="Eco"
        }
        else if(type=="Bestbowlingstrikerate"){
            titletext.text ="Best Bowling StrikeRate"
                    two.text = "O"
            three.text = "W"
            four.text ="SR"
        }else if(type=="Bestbowling"){
            titletext.text ="Best Bowling"
                    one.text=""
            two.text = "Vs"
            three.text = "BBI"
            four.text =""
        }





        Toast.makeText(this, type, Toast.LENGTH_SHORT).show()


        employeeList = mutableListOf()
        listview = findViewById(R.id.listview1)
        ref = FirebaseDatabase.getInstance().getReference("Records")


        val loader : ProgressBar = findViewById(R.id.loader)

        listview.emptyView = loader



        ref.child(gender).child(type).child("Test").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()) {
                        employeeList.clear()
                        for (e in p0.children) {
                            val employee = e.getValue(Records::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = RecordsAdapter(this@RecordsActivity, R.layout.records, employeeList)
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


        test.setOnClickListener{

            test.setBackgroundResource(R.drawable.buttons_background_color)
            odi.setBackgroundResource(R.drawable.button_round_gray)
            t20.setBackgroundResource(R.drawable.button_round_gray)

            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Records")

            ref.child(gender).child(type).child("Test").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Records::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = RecordsAdapter(this@RecordsActivity,R.layout.records,employeeList)
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
            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Records")

            ref.child(gender).child(type).child("Odi").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Records::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = RecordsAdapter(this@RecordsActivity,R.layout.records,employeeList)
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
            employeeList.clear()

            employeeList = mutableListOf()
            ref = FirebaseDatabase.getInstance().getReference("Records")

            ref.child(gender).child(type).child("T20").addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError?) {
                }

                override fun onDataChange(p0: DataSnapshot?) {
                    if (p0!!.exists()){
                        employeeList.clear()
                        for (e in p0.children){
                            val employee = e.getValue(Records::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = RecordsAdapter(this@RecordsActivity,R.layout.records,employeeList)
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

//        // Make rand
//        val rnd = Random()
//
//        // Omikuji
//        val Omikuji = rnd.nextInt(1)
//        if (Omikuji == 0) {
//            // Go to Show Interstitial Ad
//            showInterstitialAd()
//        }


        if (mRewardedVideoAd.isLoaded) {
            mRewardedVideoAd.show()
        }



    }


    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-2636513564663257/5415464782",
                AdRequest.Builder().build())
    }

    override fun onRewarded(reward: RewardItem) {

    }

    override fun onRewardedVideoAdLeftApplication() {
    }

    override fun onRewardedVideoAdClosed() {
    }

    override fun onRewardedVideoAdFailedToLoad(errorCode: Int) {
    }

    override fun onRewardedVideoAdLoaded() {
    }

    override fun onRewardedVideoAdOpened() {
    }

    override fun onRewardedVideoStarted() {
    }

    override fun onRewardedVideoCompleted() {
    }



}
