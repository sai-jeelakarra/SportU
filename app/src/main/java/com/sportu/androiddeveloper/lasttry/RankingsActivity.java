package com.sportu.androiddeveloper.lasttry;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.sportu.androiddeveloper.lasttry.Fragments.AllRounderFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.BatsmanFragment;
import com.sportu.androiddeveloper.lasttry.Fragments.BowlerFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RankingsActivity extends AppCompatActivity{


    private InterstitialAd interstitial;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        setTitle("ICC Ranking");

        //String ranktype = getIntent().getStringExtra("type");

        // Create the interstitial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-2636513564663257/3522964462");
        loadinterstitial();

        // Listener for Ad
        interstitial.setAdListener(new AdListener()
        {
            // When Closed Ad, Load new Ad
            @Override
            public void onAdClosed()
            {
                super.onAdClosed();
                loadinterstitial();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
//        setupTabIcons();
    }
//    private void setupTabIcons() {
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new BatsmanFragment(), "BATTING");
        adapter.addFrag(new BowlerFragment(), "BOWLING");
        adapter.addFrag(new AllRounderFragment(), "ALL ROUNDER");

        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        viewPager.setPageTransformer(true, new ForegroundToBackgroundTransformer());
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
    public void onBackPressed()
    {
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
}
