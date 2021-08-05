package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Song> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;



    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);
        ImageView ivNew=rowView.findViewById(R.id.imageViewNew);

        // Obtain the UI components and do the necessary binding
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvSingers = rowView.findViewById(R.id.tvSingers);
        //TextView tvStar = rowView.findViewById(R.id.tvStar);
        RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);


        // Obtain the Android Version information based on the position
        Song currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYearReleased()+"");
        tvSingers.setText(currentVersion.getSingers());


        int star=currentVersion.getStars();
        String stars="";
        for(int i=0; i<star; i++){
            stars+="*";
        }
        //tvStar.setText(stars);
        ratingBar.setNumStars(currentVersion.getStars());

        if (currentVersion.getYearReleased()>=2019){
            ivNew.setImageResource(R.drawable.newsong);
        } else {
            ivNew.setVisibility(View.INVISIBLE);
        }

//                ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
//            public void onRatingChanged(RatingBar ratingBar, float rating,
//                                        boolean fromUser) {
//
//                txtRatingValue.setText(String.valueOf(rating));
//
//            }


        return rowView;
    }


}