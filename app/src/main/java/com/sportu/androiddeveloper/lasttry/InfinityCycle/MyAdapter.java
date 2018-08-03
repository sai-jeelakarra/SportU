package com.sportu.androiddeveloper.lasttry.InfinityCycle;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.sportu.androiddeveloper.lasttry.CricketActivity;
import com.sportu.androiddeveloper.lasttry.FootBallActivity;
import com.sportu.androiddeveloper.lasttry.R;

import java.util.List;

public class MyAdapter extends PagerAdapter {

    List<Integer> lstImages;
    Context context;
    LayoutInflater layoutInflater;

    public MyAdapter(List<Integer> lstImages, Context context) {
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

        try{

        imageView.setImageResource(lstImages.get(position));

        }catch (Exception e){
            e.printStackTrace();
        }



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position==0)
                {
                   // Toast.makeText(context,"cricket", Toast.LENGTH_SHORT).show();
                    try {
                        Intent a = new Intent(context,CricketActivity.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(a);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                else if (position==1){
                    try {
                    //Toast.makeText(context,"football", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context,FootBallActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    a.putExtra("type","football");
                    context.startActivity(a);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if(position==2){
                        try {
                    //Toast.makeText(context,"kabaddi", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(context,FootBallActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    a.putExtra("type","kabaddi");
                    context.startActivity(a);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                }
                else if (position==3){
                            try {
                                // Toast.makeText(context,"Horse Racing", Toast.LENGTH_SHORT).show();

                    Intent a = new Intent(context,FootBallActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    a.putExtra("type","horse");
                    context.startActivity(a);
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                }
            }
        });


        container.addView(view);
        return view;
    }
}
