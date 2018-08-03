package com.sportu.androiddeveloper.lasttry.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ProgressBar
import com.google.firebase.database.*

import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.activities.NewsActivity
import com.sportu.androiddeveloper.lasttry.adapters.NewsAdapter
import com.sportu.androiddeveloper.lasttry.ui.News
import com.facebook.FacebookSdk.getApplicationContext
import android.widget.AdapterView.OnItemClickListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds


class TrendingNewsFragment : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<News>
    lateinit var listview: ListView



    private lateinit var mAdView: AdView
    private lateinit var mAdView2: AdView


    var myAppId:String = "ca-app-pub-9979219184162247~3543479873"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_trending_news, container, false)



        MobileAds.initialize(context,myAppId)

        mAdView = view.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        employeeList = mutableListOf()
        listview = view.findViewById(R.id.listview1)
        ref = FirebaseDatabase.getInstance().getReference("Trendingnews")


        val loader : ProgressBar = view.findViewById(R.id.loader)

        listview.emptyView = loader



        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    try {

                        employeeList.clear()
                        for (e in p0.children) {
                            val employee = e.getValue(News::class.java)
                            employeeList.add(employee!!)
                        }
                        val adapter = NewsAdapter(view.context, R.layout.trending_news, employeeList)
                        listview.adapter = adapter

                        adapter.notifyDataSetChanged()
                    }catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }

        })



        listview.setOnItemClickListener(OnItemClickListener
        {
            parent, view, position, id ->
                val intent:Intent = Intent(getApplicationContext(),NewsActivity::class.java)
                intent.putExtra("position","$position")
            startActivity(intent)
        })

        return view
    }




}
