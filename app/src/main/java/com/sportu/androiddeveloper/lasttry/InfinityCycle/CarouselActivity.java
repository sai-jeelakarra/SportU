package com.sportu.androiddeveloper.lasttry.InfinityCycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.ForegroundToBackgroundTransformer;
import com.sportu.androiddeveloper.lasttry.R;
import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class CarouselActivity extends AppCompatActivity {
    List<Integer> lstImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        initData();

        try{

            HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
            MyAdapter adapter = new MyAdapter(lstImages,getBaseContext());
            pager.setAdapter(adapter);

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    private void initData() {

        try{
            lstImages.add(R.drawable.crick);
            lstImages.add(R.drawable.football);
            lstImages.add(R.drawable.kabaddi);
            lstImages.add(R.drawable.horse);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
