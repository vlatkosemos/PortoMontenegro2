package com.example.dimit.portomontenegro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.dimit.portomontenegro.adapters.ListFacilitiesAdapter;
import com.example.dimit.portomontenegro.objects.ZEvents;
import com.example.dimit.portomontenegro.objects.ZFacilities;

import java.util.ArrayList;
import java.util.List;

public class Facilities extends AppCompatActivity {
    Context context;
    ListFacilitiesAdapter adapter;
    ListFacilitiesAdapter adapter1;

    List<ZFacilities> lstResAndBar= new ArrayList<>();
    List<ZFacilities> lstActivitys = new ArrayList<>();
    ListView lstData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facilities);

        Listners();

        Start();

        BindData();
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
        ListView grvNews = (ListView) findViewById(R.id.grvNews);
        adapter = new ListFacilitiesAdapter(context, R.layout.facilities_item, lstResAndBar);
        ViewGroup.LayoutParams layoutParams = grvNews.getLayoutParams();
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, (int)(5*60), getResources().getDisplayMetrics());
        layoutParams.height = height;
        grvNews.setLayoutParams(layoutParams);
        grvNews.setAdapter(adapter);


        ListView grvFun = (ListView) findViewById(R.id.grvFun);
        adapter1 = new ListFacilitiesAdapter(context, R.layout.facilities_item, lstActivitys);
        ViewGroup.LayoutParams layoutParams1 = grvFun.getLayoutParams();
        int height1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, (int)(5*60), getResources().getDisplayMetrics());
        layoutParams.height = height1;
        grvFun.setLayoutParams(layoutParams);
        grvFun.setAdapter(adapter1);
    }

    public void Start()
    {
        lstResAndBar.add(new ZFacilities("Al Posto Giusto","http://demo8.semos.com.mk/imagesPort/pizza.png",1));
        lstResAndBar.add(new ZFacilities("Gallardo","http://demo8.semos.com.mk/imagesPort/steak.png",1));
        lstResAndBar.add(new ZFacilities("Crush Wine Station","http://demo8.semos.com.mk/imagesPort/wine.png",1));
        lstResAndBar.add(new ZFacilities("Sumosan","http://demo8.semos.com.mk/imagesPort/sushi.png",1));
        lstResAndBar.add(new ZFacilities("De Gustibus","http://demo8.semos.com.mk/imagesPort/fish.png",1));

        lstActivitys.add(new ZFacilities("Berth","http://demo8.semos.com.mk/imagesPort/berth.png",2));
        lstActivitys.add(new ZFacilities("Pool","http://demo8.semos.com.mk/imagesPort/pool.png",2));
        lstActivitys.add(new ZFacilities("Massage","http://demo8.semos.com.mk/imagesPort/massage.png",2));
        lstActivitys.add(new ZFacilities("Sauna","http://demo8.semos.com.mk/imagesPort/sauna.png",2));
        lstActivitys.add(new ZFacilities("Gym","http://demo8.semos.com.mk/imagesPort/gym.png",2));



    }

}
