package com.sportu.androiddeveloper.lasttry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.sportu.androiddeveloper.lasttry.activities.RecordsActivity;


public class BattingFragment extends Fragment implements View.OnClickListener {

    private AdView mAdView;
    private AdView mAdView2;
    private AdView mAdView3;

    Button highestruns,battingaverage,beststrikerate,mosthundreds,mostfifties,mostfours,mostsixes,highestscore;
    View view;
    Intent typeintent;


    public BattingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_one, container, false);

        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = view.findViewById(R.id.adView);
        mAdView2 = view.findViewById(R.id.adView2);
        mAdView3 = view.findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
       mAdView2.loadAd(adRequest);
        mAdView3.loadAd(adRequest);


        typeintent  = new Intent(getActivity(),RecordsActivity.class);

        highestruns = view.findViewById(R.id.highestruns);
       battingaverage = view.findViewById(R.id.battingaverage);
       beststrikerate = view.findViewById(R.id.beststrikerate);
       mosthundreds = view.findViewById(R.id.mosthundreds);
        mostfifties = view.findViewById(R.id.mostfifties);
       mostfours = view.findViewById(R.id.mostfours);
       mostsixes = view.findViewById(R.id.mostsixes);
       highestscore = view.findViewById(R.id.highestscore);

        highestruns.setOnClickListener(this);
        battingaverage.setOnClickListener(this);
        beststrikerate.setOnClickListener(this);
        mosthundreds.setOnClickListener(this);
        mostfifties.setOnClickListener(this);
        mostfours.setOnClickListener(this);
        mostsixes.setOnClickListener(this);
        highestscore.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.highestruns:

               typeintent.putExtra("type","Highestruns");
               typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.battingaverage:
                typeintent.putExtra("type","Battingaverage");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.beststrikerate:
                typeintent.putExtra("type","Beststrikerate");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.mosthundreds:
                typeintent.putExtra("type","Mosthundreds");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.mostfifties:
                typeintent.putExtra("type","Mostfifties");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.mostfours:
                typeintent.putExtra("type","Mostfours");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.mostsixes:
                typeintent.putExtra("type","Mostsixes");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
            case R.id.highestscore:
                typeintent.putExtra("type","Highestscore");
                typeintent.putExtra("gender","Batting");
                startActivity(typeintent);
                break;
        }
    }
}
