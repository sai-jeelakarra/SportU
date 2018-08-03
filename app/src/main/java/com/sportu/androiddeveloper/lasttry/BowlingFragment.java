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



public class BowlingFragment extends Fragment implements View.OnClickListener  {

    private AdView mAdView;
    private AdView mAdView2;
    private AdView mAdView3;


    Button mostwickets,bestbowlingaverage,most5wickethauls,besteconomy,bestbowlingstrikerate,bestbowling;
    View view;
    Intent intent;

    public BowlingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_two, container, false);


        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713");

        mAdView = view.findViewById(R.id.adView);
        mAdView2 = view.findViewById(R.id.adView2);
        mAdView3 = view.findViewById(R.id.adView3);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView2.loadAd(adRequest);
        mAdView3.loadAd(adRequest);


        intent= new Intent(getActivity(),RecordsActivity.class);

     //   mostwickets= view.findViewById(R.id.mostwickets);
        bestbowlingaverage= view.findViewById(R.id.bestbowlingaverage);
        most5wickethauls= view.findViewById(R.id.most5wickethauls);
        besteconomy= view.findViewById(R.id.besteconomy);
        bestbowlingstrikerate= view.findViewById(R.id.bestbowlingstrikerate);
        bestbowling= view.findViewById(R.id.bestbowling);

     //   mostwickets.setOnClickListener(this);
        bestbowlingaverage.setOnClickListener(this);
       most5wickethauls.setOnClickListener(this);
        besteconomy.setOnClickListener(this);
        bestbowlingstrikerate.setOnClickListener(this);
        bestbowling.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bestbowlingaverage:
                intent.putExtra("type","Bestbowlingaverage");
                intent.putExtra("gender","Bowling");
                startActivity(intent);
                break;
            case R.id.most5wickethauls:
                intent.putExtra("type","Most5wickethauls");
                intent.putExtra("gender","Bowling");
                startActivity(intent);
                break;
            case R.id.besteconomy:
                intent.putExtra("type","Besteconomy");
                intent.putExtra("gender","Bowling");
                startActivity(intent);
                break;
            case R.id.bestbowlingstrikerate:
                intent.putExtra("type","Bestbowlingstrikerate");
                intent.putExtra("gender","Bowling");
                startActivity(intent);
                break;
            case R.id.bestbowling:
                intent.putExtra("type","Bestbowling");
                intent.putExtra("gender","Bowling");
                startActivity(intent);
                break;

        }
    }
}
