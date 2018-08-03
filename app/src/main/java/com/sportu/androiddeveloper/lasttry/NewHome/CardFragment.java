package com.sportu.androiddeveloper.lasttry.NewHome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sportu.androiddeveloper.lasttry.R;
import com.sportu.androiddeveloper.lasttry.activities.LiveScoreActivity;


public class CardFragment extends Fragment {





    Intent intent;

    TextView tabtitle;
    TextView matchnumber;
    TextView matchtype;
    TextView score1;
    TextView score2;
    TextView rr1;
    TextView rr2;
    TextView result;
    TextView team1odd;
    TextView team2odd;
    String team1string;
    String team2string;
    ImageView team1logo;
    ImageView team2logo;


    String string="0";

    private DatabaseReference ref;
    private DatabaseReference scoreref;










    private CardView cardView;

    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_viewpager, container, false);



        cardView = (CardView) view.findViewById(R.id.cardView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        intent = new Intent(getContext(), LiveScoreActivity.class);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                //    Toast.makeText(getActivity(),String.format("%d", getArguments().getInt("position")), Toast.LENGTH_SHORT).show();
                   intent.putExtra("livenumber",String.format("%d", getArguments().getInt("position")));
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getActivity(),"Error loading. Try someother time..", Toast.LENGTH_SHORT).show();
                //    intent.putExtra("livenumber","0");
                }

            }
        });






           tabtitle = view.findViewById(R.id.tabtitle);
            matchnumber = view.findViewById(R.id.tableaguenumber);
        matchtype = view.findViewById(R.id.tabmatchtype);
        result = view.findViewById(R.id.tabresult);
        score1 = view.findViewById(R.id.tabscore1);
        score2 = view.findViewById(R.id.tabscore2);
        rr1 = view.findViewById(R.id.tabteam1);
        rr2 = view.findViewById(R.id.tabteam2);
        team1logo = view.findViewById(R.id.team1picture);
        team2logo = view.findViewById(R.id.team2picture);

        team1odd = view.findViewById(R.id.team1odd);
        team2odd = view.findViewById(R.id.team2odd);



        ref = FirebaseDatabase.getInstance().getReference("Internationaltabs");

        ref.child(String.format("%d", getArguments().getInt("position"))).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {

                    try {
                        tabtitle.setText(dataSnapshot.child("Title").getValue().toString());
                        matchnumber.setText(dataSnapshot.child("Matchnumber").getValue().toString());
                        matchtype.setText(dataSnapshot.child("Matchtype").getValue().toString());
                        result.setText(dataSnapshot.child("Result").getValue().toString());
                        team1string = dataSnapshot.child("Team1pic").getValue().toString();
                        team2string = dataSnapshot.child("Team2pic").getValue().toString();
                        rr1.setText(dataSnapshot.child("RR1").getValue().toString());
                        rr2.setText(dataSnapshot.child("RR2").getValue().toString());
                        score1.setText(dataSnapshot.child("Score1").getValue().toString());
                        score2.setText(dataSnapshot.child("Score2").getValue().toString());

                        team1odd.setText(dataSnapshot.child("Team1odd").getValue().toString());
                        team2odd.setText(dataSnapshot.child("Team2odd").getValue().toString());

                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    try{

                        Glide.with(getContext()).load(team1string).into(team1logo);
                        Glide.with(getContext()).load(team2string).into(team2logo);

                    }catch (Exception e){
                        e.printStackTrace();

                    }




                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}
