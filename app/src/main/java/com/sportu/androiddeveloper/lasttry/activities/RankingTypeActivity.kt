package com.sportu.androiddeveloper.lasttry.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.RankingsActivity
import kotlinx.android.synthetic.main.activity_ranking_type.*
import java.util.*

class RankingTypeActivity : AppCompatActivity() {


    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView

    private lateinit var interstitial: InterstitialAd

    internal var lstImages: MutableList<Int> = ArrayList()


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking_type)

        MobileAds.initialize(this,myAppId)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView2 = findViewById(R.id.adView2)
        mAdView2.loadAd(adRequest)


//        initData()
//
//        val pager = findViewById<View>(R.id.horizontal_cycle) as HorizontalInfiniteCycleViewPager
//        val adapter = RankingsTypeAdapter(lstImages, baseContext)
//        pager.adapter = adapter

        men.setOnClickListener{
            // Toast.makeText(context,"cricket", Toast.LENGTH_SHORT).show();
            val a = Intent(this, RankingsActivity::class.java)
            a.putExtra("type", "Men's Rankings")
            startActivity(a)
        }

        menimage.setOnClickListener{
            // Toast.makeText(context,"cricket", Toast.LENGTH_SHORT).show();
            val a = Intent(this, RankingsActivity::class.java)
            a.putExtra("type", "Men's Rankings")
            startActivity(a)
        }

        women.setOnClickListener{
            //Toast.makeText(context,"football", Toast.LENGTH_SHORT).show();
            val a = Intent(this, RankingsActivity::class.java)
            a.putExtra("type", "Women's Rankings")
           startActivity(a)
        }
        womenimage.setOnClickListener{
            //Toast.makeText(context,"football", Toast.LENGTH_SHORT).show();
            val a = Intent(this, RankingsActivity::class.java)
            a.putExtra("type", "Women's Rankings")
            startActivity(a)
        }
        team1odd.setOnClickListener{
            //Toast.makeText(context,"kabaddi", Toast.LENGTH_SHORT).show();
            val a = Intent(this, TeamRankingsActivity::class.java)
            startActivity(a)
        }
        teamimage.setOnClickListener{
            //Toast.makeText(context,"kabaddi", Toast.LENGTH_SHORT).show();
            val a = Intent(this, TeamRankingsActivity::class.java)
            startActivity(a)
        }


        // Create the interstitial.
        interstitial = InterstitialAd(this)
        interstitial.adUnitId = "ca-app-pub-9979219184162247/7149474978"
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