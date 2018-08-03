package com.sportu.androiddeveloper.lasttry.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sportu.androiddeveloper.lasttry.R;
import com.sportu.androiddeveloper.lasttry.RankingsActivity;
import com.sportu.androiddeveloper.lasttry.activities.TeamRankingsActivity;

import java.util.List;

public class RankingsTypeAdapter extends PagerAdapter {

    List<Integer> lstImages;
    Context context;
    LayoutInflater layoutInflater;

    public RankingsTypeAdapter(List<Integer> lstImages, Context context) {
        this.lstImages = lstImages;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lstImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = layoutInflater.inflate(R.layout.card_item,container,false);
        final ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(lstImages.get(position));



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0)
                {
                    // Toast.makeText(context,"cricket", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context,RankingsActivity.class);
                    a.putExtra("type","Men's Rankings");
                    context.startActivity(a);
                }
                else if (position==1){
                    //Toast.makeText(context,"football", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context,RankingsActivity.class);
                    a.putExtra("type","Women's Rankings");
                    context.startActivity(a);
                }
                else if(position==2){
                    //Toast.makeText(context,"kabaddi", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context,TeamRankingsActivity.class);
                    context.startActivity(a);
                }
            }
        });


        container.addView(view);
        return view;
    }
}

