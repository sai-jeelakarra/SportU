package com.sportu.androiddeveloper.lasttry.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.sportu.androiddeveloper.lasttry.R
import kotlinx.android.synthetic.main.activity_news.*
import android.support.design.widget.CollapsingToolbarLayout
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_team_rankings.*
import kotlinx.android.synthetic.main.content_news.*
import kotlinx.android.synthetic.main.trending_news.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import com.google.android.gms.ads.*
import java.util.*


class NewsActivity : AppCompatActivity() {


    lateinit var ref : DatabaseReference
     var imagelink:String = ""

    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"



    private lateinit var interstitial: InterstitialAd



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        setSupportActionBar(toolbar)

        MobileAds.initialize(this,myAppId)

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


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




        ref = FirebaseDatabase.getInstance().getReference("Trendingnews")

        val position:String = intent.getStringExtra("position")
        //       Toast.makeText(this,position,Toast.LENGTH_SHORT).show()

//        if (content.text==null){
//            loader
//        }


        val toolbarLayout = findViewById<View>(R.id.toolbar_layout) as CollapsingToolbarLayout

        toolbarLayout.title = "Top Stories"

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try{
                    newstitle.text = p0.child(position).child("Title").getValue().toString()
                    content.text = p0.child(position).child("Content").getValue().toString()
                    imagelink = p0.child(position).child("Image").getValue().toString()
                    newsdate.text = p0.child(position).child("Date").getValue().toString()

                    }catch (e:Exception){
                        e.printStackTrace()
                    }

                    try{
                    Glide.with(this@NewsActivity).load(imagelink).into(newsimage)
                    }catch (e:Exception){
                        e.printStackTrace()
                    }

                }
            }

        })




        fab.setOnClickListener { view ->
            val shareBody =  "\n\nHurry!!!!!\n" +
                    "Here's the fastest SCORE update app. Download SportU app and BE the First to know the Cricket score updates.\n" +
                    "The best sports app for live updates and info,News related to Cricket,Football & many more...\nclick Below...\n https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry"
            try {

            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,shareBody)
            //  sendIntent.putExtra(Intent.EXTRA_TEXT,appdetails)
            sendIntent.type = "text/plain"
            sendIntent.`package` = "com.whatsapp"
            startActivity(sendIntent)

        }catch (e:Exception){
            e.printStackTrace()
            Toast.makeText(this,"Either you don't have whatsapp installed or Whatsapp is not respoding.",Toast.LENGTH_LONG).show()
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
