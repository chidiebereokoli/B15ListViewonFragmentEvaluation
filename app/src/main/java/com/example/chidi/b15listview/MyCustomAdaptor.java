package com.example.chidi.b15listview;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomAdaptor extends BaseAdapter{

    String [] mycountries;
    int[] myImages;
    Context ctx;

    LayoutInflater inflater;
    Activity activity;

    public MyCustomAdaptor(String[] mycountries, int[] myImages, Context ctx) {
        this.mycountries = mycountries;
        this.myImages = myImages;
        this.ctx = ctx;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mycountries.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.item_layout,null);

        TextView tv = view.findViewById(R.id.textViewitem);

        ImageView iv = view.findViewById(R.id.imageView);
        ConstraintLayout constraintLayout =  view.findViewById(R.id.myconstrainItem);

        tv.setText(mycountries[position]);
        iv.setImageResource(myImages[position]);

       tv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Fragment_Text fragment_text = new Fragment_Text();
               Bundle bundle = new Bundle();
               bundle.putInt("key2",position);

               fragment_text.setArguments(bundle);
               Toast.makeText(ctx, "you clicked "+ mycountries[position], Toast.LENGTH_SHORT).show();

               ((MainActivity)ctx).getFragmentManager().beginTransaction().
                       add(R.id.layoutid,fragment_text).addToBackStack(null).commit();
           }
       });
       constraintLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(ctx, "your country is : " + mycountries[position], Toast.LENGTH_SHORT).show();
           }
       });
       iv.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Fragment_Map fragment =  new Fragment_Map();

               Bundle bundle = new Bundle();
               bundle.putInt("key1", position);
               fragment.setArguments(bundle);

               Toast.makeText(ctx, "you clicked an Image of " + mycountries[position], Toast.LENGTH_SHORT).show();

               ((MainActivity)ctx).getFragmentManager().beginTransaction().
                       add(R.id.layoutid,fragment).addToBackStack(null).commit();
           }
       });
        return view;
    }
}
