package com.example.dimit.portomontenegro;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dimit.portomontenegro.adapters.ListFacilitiesAdapter;
import com.example.dimit.portomontenegro.adapters.ListServicesAdapter;
import com.example.dimit.portomontenegro.objects.ZFacilities;

import java.util.ArrayList;
import java.util.List;

public class YachtServices extends Activity { Context context;
    ListFacilitiesAdapter adapter;
    ListServicesAdapter adapter1;


    List<ZFacilities> lstResAndBar= new ArrayList<>();
    List<ZFacilities> lstActivitys = new ArrayList<>();
    ListView lstData;
    ListView grvFun;

    Uri petrolicon = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.petrolicon);
    Uri eletricityicon = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.eletricityicon);
    Uri watericon = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.watericon);
    Uri cleaningicon = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.cleaningicon);
    Uri crewicon1 = Uri.parse("android.resource://com.example.dimit.portomontenegro/" + R.drawable.crewicon1);

    String petroliconSTR = petrolicon.toString();
    String eletricityiconSTR = eletricityicon.toString();
    String watericonSTR = watericon.toString();
    String cleaningiconSTR = cleaningicon.toString();
    String crewicon1STR = crewicon1.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yacht_services);

        context = this;
        Listners();

        Start();

        BindData();




    }

    protected void popUpOrder(View v){


        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("Your order has been recived");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });



        AlertDialog alert11 = builder1.create();
        alert11.show();

    }

    public void Listners()
    {
        context= this;

        ImageButton imgBack = (ImageButton)findViewById(R.id.imgBack);
        if (imgBack!=null)
            imgBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

        ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
        if (imgClose!=null)
            imgClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
    }

    public void BindData()
    {

        grvFun = (ListView) findViewById(R.id.grvFun);
        adapter1 = new ListServicesAdapter(context, R.layout.services_item, lstResAndBar);
        ViewGroup.LayoutParams layoutParams1 = grvFun.getLayoutParams();
        int height1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, (int)(5*62), getResources().getDisplayMetrics());
        layoutParams1.height = height1;
        grvFun.setLayoutParams(layoutParams1);
        grvFun.setAdapter(adapter1);
    }

    public void Start()
    {
        lstResAndBar.add(new ZFacilities("OIL",petroliconSTR,1));
        lstResAndBar.add(new ZFacilities("ELECTRICITY",eletricityiconSTR,1));
        lstResAndBar.add(new ZFacilities("WATER",watericonSTR,1));
        lstResAndBar.add(new ZFacilities("CLEANING",cleaningiconSTR,1));
        lstResAndBar.add(new ZFacilities("CREWS",crewicon1STR,1));



    }

}
