package com.example.chidi.b15listview;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Fragment_ListView extends Fragment {

    String[] countries = {"India","China","Japan","USA","England","Nepal","India","China","Japan","USA","England","Nepal"};

    int[] image_ids = {R.drawable.india,R.drawable.china,R.drawable.japan,R.drawable.usa,
            R.drawable.uk,R.drawable.nepal,R.drawable.india,R.drawable.china,
            R.drawable.japan,R.drawable.usa,R.drawable.uk,R.drawable.nepal};
    ListView listView;

    MyCustomAdaptor myCustomAdaptor;
    //@androidx.annotation.Nullable
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, /*@androidx.annotation.Nullable*/ @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_listview, container,false);

        listView =  view.findViewById(R.id.mylistview);

        MyCustomAdaptor myCustomAdaptor = new MyCustomAdaptor(countries,image_ids,getActivity());

        listView.setAdapter(myCustomAdaptor);

        return view;


    }
}
