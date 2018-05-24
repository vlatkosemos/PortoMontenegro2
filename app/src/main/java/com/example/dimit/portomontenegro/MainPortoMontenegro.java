package com.example.dimit.portomontenegro;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dimit.portomontenegro.adapters.ViewPagerAdapter;

public class MainPortoMontenegro extends FragmentActivity {

    Context context;
    ViewPager viewPager;
    ViewPager viewPager1;
    ViewPagerAdapter adapter;
    ViewPagerAdapter adapter1;
    Uri img111 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.w1);
    Uri img211 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.w2);
    Uri img311 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.w1);

    Uri img1 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.img2);
    Uri img2 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.img2);
    Uri img3 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.img3);
    private String[] images={
            img1.toString(),
    };
    private String[] images1={

            img111.toString(),
            img211.toString(),
            img311.toString(),

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_porto_montenegro);

        context=this;
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(MainPortoMontenegro.this,images);
        viewPager.setAdapter(adapter);

        viewPager1 = (ViewPager) findViewById(R.id.viewPager1);
        adapter1 = new ViewPagerAdapter(MainPortoMontenegro.this,images1);
        viewPager1.setAdapter(adapter1);
    }

    protected void openContact(View v){
        Intent myIntent = new Intent(context, contact.class);
        context.startActivity(myIntent);

    }

    protected void openEvents(View v){
        Intent myIntent = new Intent(context, Events.class);
        context.startActivity(myIntent);

    }

    protected void openMap(View v){
        Intent myIntent = new Intent(context, MapsActivity2.class);
        context.startActivity(myIntent);
    }

    protected void openFacilities(View v){
        Intent myIntent = new Intent(context, Facilities.class);
        context.startActivity(myIntent);
    }
}
