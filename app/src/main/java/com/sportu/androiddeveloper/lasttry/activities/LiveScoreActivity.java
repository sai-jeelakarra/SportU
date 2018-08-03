package com.sportu.androiddeveloper.lasttry.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.sportu.androiddeveloper.lasttry.Fragments.InfoFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.LiveMatchFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.OversFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.ScoreCard;
import com.sportu.androiddeveloper.lasttry.Fragments.StatsFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.WinningOdds;
import com.sportu.androiddeveloper.lasttry.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LiveScoreActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_score);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);



        viewPager.setCurrentItem(3,true);

        viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());


        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-9979219184162247/5616901452");
        loadinterstitial();

        // Listener for Ad
        interstitial.setAdListener(new AdListener() {
            // When Closed Ad, Load new Ad
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadinterstitial();
            }
        });

    }


    private void loadinterstitial()
    {
        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
    }

    // Show Interstitial Ad
    private void showInterstitialAd()
    {
        // return, if Ad data is no loaded
        if (!interstitial.isLoaded()) {
            return;
        }

        // Show Ad
        interstitial.show();
    }

    // Back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // Make rand
        Random rnd = new Random();

        // Omikuji
        int Omikuji = rnd.nextInt(1);
        if (Omikuji == 0) {
            // Go to Show Interstitial Ad
            showInterstitialAd();
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new InfoFragment(), "Info");
        adapter.addFrag(new StatsFragment(), "Stats");
        adapter.addFrag(new WinningOdds(), "Winning Odds");
        adapter.addFrag(new LiveMatchFragment(), "LiveLine");
        adapter.addFrag(new OversFragment(), "Overs Card");
        adapter.addFrag(new ScoreCard(), "Score Card");


        viewPager.setOffscreenPageLimit(5);

        adapter.notifyDataSetChanged();

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
