package com.sportu.androiddeveloper.lasttry.Fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.facebook.share.model.ShareLinkContent
import com.facebook.share.widget.ShareDialog
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener
import com.google.firebase.database.*
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton
import com.sportu.androiddeveloper.lasttry.R
import kotlinx.android.synthetic.main.live_match.*
import kotlinx.android.synthetic.main.records.*

class LiveMatchFragment : Fragment(),RewardedVideoAdListener {

    lateinit var ref : DatabaseReference
    lateinit var oversref : DatabaseReference
    lateinit var team1string:String
    lateinit var team2string:String
    lateinit var progressbar:String
    lateinit var listview: ListView
    var finaloverstable:String="0"
    var sessionstable:String="0"
    var livescoreshare:String=""

    var playingteam:String ="0"
    var overnumber:Int =0

    var crrvalue:Double=0.00
    var rrrvalue:Double=0.00


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"


    lateinit var mRewardedVideoAd: RewardedVideoAd

    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView
    private lateinit var mAdView3: AdView
    private lateinit var mAdView4: AdView

    var livenumber:String?="0"
    var applink:String?="https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry"
    var appdetails: String?= "Hurry!!!!!\n" +
            "Here's the fastest SCORE update app. Download SportU app and BE the First to know the Cricket score updates.\n" +
            "The best sports app for live updates and info,News related to Cricket,Football & many more...\n";


    var sharinglink:String?= "Hurry!!!!!\n" +
            "Here's the fastest SCORE update app. Download SportU app and BE the First to know the Cricket score updates.\n" +
            "The best sports app for live updates and info,News related to Cricket,Football & many more...\nclick Below...\n https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry";


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.live_match, container, false)

        livenumber = activity!!.intent.getStringExtra("livenumber")



        MobileAds.initialize(context, "ca-app-pub-9979219184162247/1705576606")

        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(context)
        mRewardedVideoAd.rewardedVideoAdListener = this



        loadRewardedVideoAd()



        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        mAdView2 = view.findViewById(R.id.adView2)
        mAdView3 = view.findViewById(R.id.adView3)
        mAdView4 = view.findViewById(R.id.adView4)

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView2.loadAd(adRequest)
        mAdView3.loadAd(adRequest)
        mAdView4.loadAd(adRequest)


        ref = FirebaseDatabase.getInstance().getReference("Livematch")

        ref.child(livenumber).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }
            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()) {

                    try {

                        team1.text = p0.child("Team1").getValue().toString()
                        team2.text = p0.child("Team2").getValue().toString()
                        score1.text = p0.child("Score1").getValue().toString()
                        score2.text = p0.child("Score2").getValue().toString()

                        playingteam = p0.child("PlayingTeam").getValue().toString()
                        if (playingteam == "1") {
                            team1.text = p0.child("Team1").getValue().toString() + "*"
                            score1.text = p0.child("Score1").getValue().toString() + "*"
                        } else if (playingteam == "2") {
                            team2.text = p0.child("Team2").getValue().toString() + "*"
                            score2.text = p0.child("Score2").getValue().toString() + "*"
                        }

                        finaloverstable = p0.child("FinalOversTable").getValue().toString()

                        sessionstable = p0.child("Sessionstable").getValue().toString()

                        session1.text = p0.child("Session1").getValue().toString()
                        session2.text = p0.child("Session2").getValue().toString()
                        session3.text = p0.child("Session3").getValue().toString()
                        session4.text = p0.child("Session4").getValue().toString()
                        session5.text = p0.child("Session5").getValue().toString()
                        session6.text = p0.child("Session6").getValue().toString()


                        title.text = p0.child("Title").getValue().toString()

                        team1string = p0.child("Team1pic").getValue().toString()
                        team2string = p0.child("Team2pic").getValue().toString()
                        leaguenumber.text = p0.child("Testnumber").getValue().toString()
                        matchtype.text = p0.child("Matchtype").getValue().toString()

                        result.text = p0.child("Result").getValue().toString()

                        overnumber = p0.child("Loadvideoad").getValue().toString().toInt()


                        if (overnumber==1){
                            displayAd()
                            loadRewardedVideoAd()
                        }




                        requiredruns.text = p0.child("Requiredruns").getValue().toString()
                        ballsleft.text = p0.child("Ballsleft").getValue().toString()



                        patnership.text = "Partnership ( " + p0.child("Partnership").getValue().toString() + "/"+ p0.child("Partnershipballs").getValue().toString()+" )"


                        batsman1.text = p0.child("Batsman1").getValue().toString() + "*"
                        batsman2.text = p0.child("Batsman2").getValue().toString()

                        batsman1runs.text = p0.child("Batsman1runs").getValue().toString()
                        batsman2runs.text = p0.child("Batsman2runs").getValue().toString()

                        batsman1balls.text = p0.child("Batsman1balls").getValue().toString()
                        batsman2balls.text = p0.child("Batsman2balls").getValue().toString()

                        batsman14s.text = p0.child("Batsman14s").getValue().toString()
                        batsman24s.text = p0.child("Batsman24s").getValue().toString()

                        batsman16s.text = p0.child("Batsman16s").getValue().toString()
                        batsman26s.text = p0.child("Batsman26s").getValue().toString()

                        batsman1sr.text = p0.child("Batsman1sr").getValue().toString()
                        batsman2sr.text = p0.child("Batsman2sr").getValue().toString()

                        overs.text = "Overs (" + p0.child("Overs").getValue().toString() + ")"

                        bowler1.text = p0.child("Bowler1").getValue().toString() + "*"

                        bowler1overs.text = p0.child("Bowler1overs").getValue().toString()

                        bowler1maidens.text = p0.child("Bowler1maidens").getValue().toString()

                        bowler1runs.text = p0.child("Bowler1runs").getValue().toString()

                        bowler1wickets.text = p0.child("Bowler1wickets").getValue().toString()

                        bowler1eco.text = p0.child("Bowler1eco").getValue().toString()

                        if (bowler1overs.text=="null")
                            bowler1overs.text="0"
                        if (bowler1maidens.text=="null")
                            bowler1maidens.text="0"
                        if (bowler1runs.text=="null")
                            bowler1runs.text="0"
                        if (bowler1wickets.text=="null")
                            bowler1wickets.text="0"
                        if (bowler1eco.text=="null")
                            bowler1eco.text="0"


                        Glide.with(context).load(team1string).into(team1pic)
                        Glide.with(context).load(team2string).into(team2pic)



                        crr.text = "CRR: "+p0.child("Crr").getValue().toString()
                        rrr.text = "RRR: "+p0.child("Rrr").getValue().toString()

                        crrvalue = p0.child("Crr").getValue().toString().toDouble()
                        rrrvalue = p0.child("Rrr").getValue().toString().toDouble()

                        if (crrvalue<rrrvalue){
                            crr.setBackgroundResource(R.drawable.border_red)
                            rrr.setBackgroundResource(R.drawable.border_green)
                        }else{
                            crr.setBackgroundResource(R.drawable.border_green)
                            rrr.setBackgroundResource(R.drawable.border_red)
                        }



                        first.text = p0.child("ThisFirst").getValue().toString()
                        second.text = p0.child("ThisSecond").getValue().toString()
                        third.text = p0.child("ThisThird").getValue().toString()
                        fourth.text = p0.child("ThisFourth").getValue().toString()
                        fifth.text = p0.child("ThisFifth").getValue().toString()
                        sixth.text = p0.child("ThisSixth").getValue().toString()
                        seventh.text = p0.child("ThisSeventh").getValue().toString()
                        eigth.text = p0.child("ThisEigth").getValue().toString()
                        nineth.text = p0.child("ThisNineth").getValue().toString()
                        tenth.text = p0.child("ThisTenth").getValue().toString()

                        recentfirst.text = p0.child("RecentFirst").getValue().toString()
                        recentsecond.text = p0.child("RecentSecond").getValue().toString()
                        recentthird.text = p0.child("RecentThird").getValue().toString()
                        recentfourth.text = p0.child("RecentFourth").getValue().toString()
                        recentfifth.text = p0.child("RecentFifth").getValue().toString()
                        recentsixth.text = p0.child("RecentSixth").getValue().toString()
                        recentseventh.text = p0.child("RecentSeventh").getValue().toString()
                        recenteigth.text = p0.child("RecentEigth").getValue().toString()
                        recentnineth.text = p0.child("RecentNineth").getValue().toString()
                        recenttenth.text = p0.child("RecentTenth").getValue().toString()




                        if (first.text != "") {
                            if (first.text.length > 1) {
                                first.textSize = 10f
                            }
                            first.visibility = View.VISIBLE
                        } else first.visibility = View.INVISIBLE
                        if (second.text != "") {
                            if (second.text.length > 1) {
                                second.textSize = 10f
                            }
                            second.visibility = View.VISIBLE
                        } else second.visibility = View.INVISIBLE
                        if (third.text != "") {
                            if (third.text.length > 1) {
                                third.textSize = 10f
                            }
                            third.visibility = View.VISIBLE
                        } else third.visibility = View.INVISIBLE
                        if (fourth.text != "") {
                            if (fourth.text.length > 1) {
                                fourth.textSize = 10f
                            }
                            fourth.visibility = View.VISIBLE
                        } else fourth.visibility = View.INVISIBLE
                        if (fifth.text != "") {
                            if (fifth.text.length > 1) {
                                fifth.textSize = 10f
                            }
                            fifth.visibility = View.VISIBLE
                        } else fifth.visibility = View.INVISIBLE
                        if (sixth.text != "") {
                            if (sixth.text.length > 1) {
                                sixth.textSize = 10f
                            }
                            sixth.visibility = View.VISIBLE
                        } else sixth.visibility = View.INVISIBLE
                        if (seventh.text != "") {
                            if (seventh.text.length > 1) {
                                seventh.textSize = 10f
                            }
                            seventh.visibility = View.VISIBLE
                        } else seventh.visibility = View.INVISIBLE
                        if (eigth.text != "") {
                            if (eigth.text.length > 1) {
                                eigth.textSize = 10f
                            }
                            eigth.visibility = View.VISIBLE
                        } else eigth.visibility = View.INVISIBLE
                        if (nineth.text != "") {
                            if (nineth.text.length > 1) {
                                nineth.textSize = 10f
                            }
                            nineth.visibility = View.VISIBLE
                        } else nineth.visibility = View.INVISIBLE
                        if (tenth.text != "") {
                            if (tenth.text.length > 1) {
                                tenth.textSize = 10f
                            }
                            tenth.visibility = View.VISIBLE
                        } else tenth.visibility = View.INVISIBLE


                        if (first.text == "W") {
                            first.setTextColor(Color.WHITE)
                            first.setBackgroundResource(R.drawable.button_round_red)
                        } else if (first.text == "4" || first.text == "6") {
                            first.setTextColor(Color.BLACK)
                            first.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            first.setTextColor(Color.BLACK)
                            first.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (second.text == "W") {
                            second.setTextColor(Color.WHITE)
                            second.setBackgroundResource(R.drawable.button_round_red)
                        } else if (second.text == "4" || second.text == "6") {
                            second.setTextColor(Color.BLACK)
                            second.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            second.setTextColor(Color.BLACK)
                            second.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (third.text == "W") {
                            third.setTextColor(Color.WHITE)
                            third.setBackgroundResource(R.drawable.button_round_red)
                        } else if (third.text == "4" || third.text == "6") {
                            third.setTextColor(Color.BLACK)
                            third.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            third.setTextColor(Color.BLACK)
                            third.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (fourth.text == "W") {
                            fourth.setTextColor(Color.WHITE)
                            fourth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (fourth.text == "4" || fourth.text == "6") {
                            fourth.setTextColor(Color.BLACK)
                            fourth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            fourth.setTextColor(Color.BLACK)
                            fourth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (fifth.text == "W") {
                            fifth.setTextColor(Color.WHITE)
                            fifth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (fifth.text == "4" || fifth.text == "6") {
                            fifth.setTextColor(Color.BLACK)
                            fifth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            fifth.setTextColor(Color.BLACK)
                            fifth.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (sixth.text == "W") {
                            sixth.setTextColor(Color.WHITE)
                            sixth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (sixth.text == "4" || sixth.text == "6") {
                            sixth.setTextColor(Color.BLACK)
                            sixth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            sixth.setTextColor(Color.BLACK)
                            sixth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (seventh.text == "W") {
                            seventh.setTextColor(Color.WHITE)
                            seventh.setBackgroundResource(R.drawable.button_round_red)
                        } else if (seventh.text == "4" || seventh.text == "6") {
                            seventh.setTextColor(Color.BLACK)
                            seventh.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            seventh.setTextColor(Color.BLACK)
                            seventh.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (eigth.text == "W") {
                            eigth.setTextColor(Color.WHITE)
                            eigth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (eigth.text == "4" || eigth.text == "6") {
                            eigth.setTextColor(Color.BLACK)
                            eigth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            eigth.setTextColor(Color.BLACK)
                            eigth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (nineth.text == "W") {
                            nineth.setTextColor(Color.WHITE)
                            nineth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (nineth.text == "4" || nineth.text == "6") {
                            nineth.setTextColor(Color.BLACK)
                            nineth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            nineth.setTextColor(Color.BLACK)
                            nineth.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (tenth.text == "W") {
                            tenth.setTextColor(Color.WHITE)
                            tenth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (tenth.text == "4" || tenth.text == "6") {
                            tenth.setTextColor(Color.BLACK)
                            tenth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            tenth.setTextColor(Color.BLACK)
                            tenth.setBackgroundResource(R.drawable.button_round_white)
                        }





                        if (recentfirst.text != "") {
                            if (recentfirst.text.length > 1) {
                                recentfirst.textSize = 10f
                            }
                            recentfirst.visibility = View.VISIBLE
                        } else recentfirst.visibility = View.INVISIBLE
                        if (recentsecond.text != "") {
                            if (recentsecond.text.length > 1) {
                                recentsecond.textSize = 10f
                            }
                            recentsecond.visibility = View.VISIBLE
                        } else recentsecond.visibility = View.INVISIBLE
                        if (recentthird.text != "") {
                            if (recentthird.text.length > 1) {
                                recentthird.textSize = 10f
                            }
                            recentthird.visibility = View.VISIBLE
                        } else recentthird.visibility = View.INVISIBLE
                        if (recentfourth.text != "") {
                            if (recentfourth.text.length > 1) {
                                recentfourth.textSize = 10f
                            }
                            recentfourth.visibility = View.VISIBLE
                        } else recentfourth.visibility = View.INVISIBLE
                        if (recentfifth.text != "") {
                            if (recentfifth.text.length > 1) {
                                recentfifth.textSize = 10f
                            }
                            recentfifth.visibility = View.VISIBLE
                        } else recentfifth.visibility = View.INVISIBLE
                        if (recentsixth.text != "") {
                            if (recentsixth.text.length > 1) {
                                recentsixth.textSize = 10f
                            }
                            recentsixth.visibility = View.VISIBLE
                        } else recentsixth.visibility = View.INVISIBLE
                        if (recentseventh.text != "") {
                            if (recentseventh.text.length > 1) {
                                recentseventh.textSize = 10f
                            }
                            recentseventh.visibility = View.VISIBLE
                        } else recentseventh.visibility = View.INVISIBLE
                        if (recenteigth.text != "") {
                            if (recenteigth.text.length > 1) {
                                recenteigth.textSize = 10f
                            }
                            recenteigth.visibility = View.VISIBLE
                        } else recenteigth.visibility = View.INVISIBLE
                        if (recentnineth.text != "") {
                            if (recentnineth.text.length > 1) {
                                recentnineth.textSize = 10f
                            }
                            recentnineth.visibility = View.VISIBLE
                        } else recentnineth.visibility = View.INVISIBLE
                        if (recenttenth.text != "") {
                            if (recenttenth.text.length > 1) {
                                recenttenth.textSize = 10f
                            }
                            recenttenth.visibility = View.VISIBLE
                        } else recenttenth.visibility = View.INVISIBLE


                        if (recentfirst.text == "W") {
                            recentfirst.setTextColor(Color.WHITE)
                            recentfirst.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentfirst.text == "4" || recentfirst.text == "6") {
                            recentfirst.setTextColor(Color.BLACK)
                            recentfirst.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentfirst.setTextColor(Color.BLACK)
                            recentfirst.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (recentsecond.text == "W") {
                            recentsecond.setTextColor(Color.WHITE)
                            recentsecond.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentsecond.text == "4" || recentsecond.text == "6") {
                            recentsecond.setTextColor(Color.BLACK)
                            recentsecond.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentsecond.setTextColor(Color.BLACK)
                            recentsecond.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (recentthird.text == "W") {
                            recentthird.setTextColor(Color.WHITE)
                            recentthird.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentthird.text == "4" || recentthird.text == "6") {
                            recentthird.setTextColor(Color.BLACK)
                            recentthird.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentthird.setTextColor(Color.BLACK)
                            recentthird.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (recentfourth.text == "W") {
                            recentfourth.setTextColor(Color.WHITE)
                            recentfourth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentfourth.text == "4" || recentfourth.text == "6") {
                            recentfourth.setTextColor(Color.BLACK)
                            recentfourth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentfourth.setTextColor(Color.BLACK)
                            recentfourth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (recentfifth.text == "W") {
                            recentfifth.setTextColor(Color.WHITE)
                            recentfifth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentfifth.text == "4" || recentfifth.text == "6") {
                            recentfifth.setTextColor(Color.BLACK)
                            recentfifth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentfifth.setTextColor(Color.BLACK)
                            recentfifth.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (recentsixth.text == "W") {
                            recentsixth.setTextColor(Color.WHITE)
                            recentsixth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentsixth.text == "4" || recentsixth.text == "6") {
                            recentsixth.setTextColor(Color.BLACK)
                            recentsixth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentsixth.setTextColor(Color.BLACK)
                            recentsixth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (recentseventh.text == "W") {
                            recentseventh.setTextColor(Color.WHITE)
                            recentseventh.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentseventh.text == "4" || recentseventh.text == "6") {
                            recentseventh.setTextColor(Color.BLACK)
                            recentseventh.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentseventh.setTextColor(Color.BLACK)
                            recentseventh.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (recenteigth.text == "W") {
                            recenteigth.setTextColor(Color.WHITE)
                            recenteigth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recenteigth.text == "4" || recenteigth.text == "6") {
                            recenteigth.setTextColor(Color.BLACK)
                            recenteigth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recenteigth.setTextColor(Color.BLACK)
                            recenteigth.setBackgroundResource(R.drawable.button_round_white)
                        }
                        if (recentnineth.text == "W") {
                            recentnineth.setTextColor(Color.WHITE)
                            recentnineth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recentnineth.text == "4" || recentnineth.text == "6") {
                            recentnineth.setTextColor(Color.BLACK)
                            recentnineth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recentnineth.setTextColor(Color.BLACK)
                            recentnineth.setBackgroundResource(R.drawable.button_round_white)
                        }

                        if (recenttenth.text == "W") {
                            recenttenth.setTextColor(Color.WHITE)
                            recenttenth.setBackgroundResource(R.drawable.button_round_red)
                        } else if (recenttenth.text == "4" || recenttenth.text == "6") {
                            recenttenth.setTextColor(Color.BLACK)
                            recenttenth.setBackgroundResource(R.drawable.button_round_green)
                        } else {
                            recenttenth.setTextColor(Color.BLACK)
                            recenttenth.setBackgroundResource(R.drawable.button_round_white)
                        }





                        livescoreshare = title.text.toString() + "\n" + team1.text.toString() + " : " + score1.text.toString() + "\n" + team2.text.toString() + " : " + score2.text.toString() + "\n\n"




                        if (finaloverstable == "1") {
                            required.visibility = View.VISIBLE
                            oversessions.visibility = View.INVISIBLE
                        } else {
                            required.visibility = View.INVISIBLE
                        }

                        if (sessionstable == "1") {
                            oversessions.visibility = View.VISIBLE
                            required.visibility = View.INVISIBLE
                        } else {
                            oversessions.visibility = View.INVISIBLE
                        }


                    } catch (e: Exception) {
                        e.printStackTrace()

                    }
                }
            }
        })







        val icon = ImageView(context)
        icon.setImageResource(R.drawable.send)

        val actionButton = FloatingActionButton.Builder(activity)
                .setContentView(icon)
                .build()
        val itemBuilder = SubActionButton.Builder(activity)
        // repeat many times:
        val itemIcon1 = ImageView(context)
        itemIcon1.setImageResource(R.drawable.whatsapp)

        val itemIcon2 = ImageView(context)
        itemIcon2.setImageResource(R.drawable.fb)

        val itemIcon3 = ImageView(context)
        itemIcon3.setImageResource(R.drawable.more)

        val button1 = itemBuilder.setContentView(itemIcon1).build()
        val button2 = itemBuilder.setContentView(itemIcon2).build()
        val button3 = itemBuilder.setContentView(itemIcon3).build()

        //attach the sub buttons to the main button
        val actionMenu = FloatingActionMenu.Builder(activity)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .attachTo(actionButton)
                .build()

        button1.setOnClickListener {
            try {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT,livescoreshare+sharinglink)
                //  sendIntent.putExtra(Intent.EXTRA_TEXT,appdetails)
                sendIntent.type = "text/plain"
                sendIntent.`package` = "com.whatsapp"
                startActivity(sendIntent)

            }catch (e:Exception){
                e.printStackTrace()
                Toast.makeText(context,"Either you don't have whatsapp installed or Whatsapp is not respoding.",Toast.LENGTH_LONG).show()
            }

        }


        button2.setOnClickListener {
            var shareDialog = ShareDialog (this)
            if (ShareDialog.canShow(ShareLinkContent::class.java)) {
                val linkContent = ShareLinkContent.Builder()
                        .setContentTitle("SportU")
                        .setContentDescription(livescoreshare+sharinglink)
                        .setImageUrl(Uri.parse("https://firebasestorage.googleapis.com/v0/b/sportu-8c3b6.appspot.com/o/ad%201.png?alt=media&token=8fe0f1a3-4deb-47c0-9168-2b4b9bc183fb"))
                        .setContentUrl(Uri.parse(" https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry"))
                        .build()
                shareDialog.show(linkContent)


            }
        }

        button3.setOnClickListener {
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT,livenumber+sharinglink)
            sendIntent.type = "text/plain"
            startActivity(sendIntent)


        }








        return view
    }











    fun displayAd(){
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

        loadRewardedVideoAd()
        ref.child("0").child("Loadvideoad").setValue("0")
    }

    override fun onRewardedVideoCompleted() {


    }










}