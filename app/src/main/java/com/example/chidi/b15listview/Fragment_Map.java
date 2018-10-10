package com.example.chidi.b15listview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class Fragment_Map extends Fragment {

    ImageView imagecountry;
    String[] countries = {"India","China","Japan","USA","England","Nepal",
            "India","China","Japan","USA","England","Nepal"};
    int[] image_ids = {R.drawable.india,R.drawable.china,R.drawable.japan,R.drawable.usa,
            R.drawable.uk,R.drawable.nepal,R.drawable.india,R.drawable.china,R.drawable.japan,
            R.drawable.usa,R.drawable.uk,R.drawable.nepal};
    //The container parameter passed to onCreateVIew is the parent ViewGroup from the Activity's layout.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);
        Bundle bb = getArguments();
        int position = bb.getInt("key1");

        imagecountry = view.findViewById(R.id.imageViewCountry);

        imagecountry.setImageResource(image_ids[position]);
        return view;
    }



}
