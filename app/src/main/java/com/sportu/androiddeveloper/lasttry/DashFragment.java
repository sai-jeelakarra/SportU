package com.sportu.androiddeveloper.lasttry;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.sportu.androiddeveloper.lasttry.activities.PointsTableActivity;
import com.sportu.androiddeveloper.lasttry.activities.RankingTypeActivity;
import com.sportu.androiddeveloper.lasttry.activities.RecentMatchesActivity;
import com.sportu.androiddeveloper.lasttry.activities.UpcomingActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashFragment extends Fragment  implements View.OnClickListener{

    //implements View.OnClickListener

    private AdView mAdView;


    private String myAppId = "ca-app-pub-9979219184162247~3543479873";


    public DashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dash, container, false);

        ImageView records = v.findViewById(R.id.records);
        ImageView ranking = v.findViewById(R.id.rankings);
        ImageView recent = v.findViewById(R.id.recent);
        ImageView schedule = v.findViewById(R.id.schedule);
        ImageView share = v.findViewById(R.id.share);
        ImageView rateus = v.findViewById(R.id.rateus);
        ImageView facebookpage = v.findViewById(R.id.facebookpage);
        ImageView pointstable = v.findViewById(R.id.pointstable);
        Button checkforupdates = v.findViewById(R.id.checkforupdates);

        records.setOnClickListener(this);
        ranking.setOnClickListener(this);
        recent.setOnClickListener(this);
        schedule.setOnClickListener(this);
        share.setOnClickListener(this);
        rateus.setOnClickListener(this);
        pointstable.setOnClickListener(this);
        facebookpage.setOnClickListener(this);
        checkforupdates.setOnClickListener(this);


        MobileAds.initialize(getContext(),myAppId);

        mAdView = v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recent:
                Intent in = new Intent(getContext(), RecentMatchesActivity.class);
                startActivity(in);
                break;
            case R.id.schedule:
                Intent inte = new Intent(getContext(), UpcomingActivity.class);
                startActivity(inte);
                break;
            case R.id.records:
                Intent i = new Intent(getContext(), IconTextTabsActivity.class);
                startActivity(i);
                break;
            case R.id.rankings:
                try {
                    Intent intent = new Intent(getContext(), RankingTypeActivity.class);
                    startActivity(intent);
                }catch(Exception e){
                    e.printStackTrace();
                    }

                break;
            case R.id.share:
                try{
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Hurry!!!!!\n" +
                        "Here's the fastest SCORE update app. Download SportU app and BE the First to know the Cricket score updates.\n" +
                        "The best sports app for live updates and info,News related to Cricket,Football & many more...\nclick Below...\n https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry";

                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "SportU");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share SportU via"));
                }catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case R.id.rateus:
                try {
               // Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getContext().getPackageName()));
                Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry"));
                startActivity(rateIntent);
                break;
        }catch(Exception e){
            e.printStackTrace();
        }

            case R.id.pointstable:
                try{
                // Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getContext().getPackageName()));
                Intent pointstableIntent = new Intent(getContext(),PointsTableActivity.class);
                startActivity(pointstableIntent);
                break;
                }catch(Exception e){
                    e.printStackTrace();
                }

            case R.id.facebookpage:
                try{

                Intent fbIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SportUInc"));
                startActivity(fbIntent);
                break;
                }catch(Exception e){
                    e.printStackTrace();
                }
            case R.id.checkforupdates:
                try {
                    // Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getContext().getPackageName()));
                    Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.sportu.androiddeveloper.lasttry"));
                    startActivity(rateIntent);
                    break;
                }catch(Exception e){
                    e.printStackTrace();
                }

        }
    }
}
