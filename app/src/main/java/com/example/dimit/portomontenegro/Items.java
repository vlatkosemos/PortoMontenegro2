package com.example.dimit.portomontenegro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.dimit.portomontenegro.adapters.CustomGridView3;
import com.example.dimit.portomontenegro.adapters.Item;
import com.example.dimit.portomontenegro.adapters.ListEventAdapter;
import com.example.dimit.portomontenegro.objects.ZEvents;

import java.util.ArrayList;
import java.util.List;

public class Items extends Activity {

    Context context;
    public CustomGridView3 customGridAdapter;
    ArrayList<Item> gridArray = new ArrayList<Item>();

    ListEventAdapter customAdapter;
    List<ZEvents> lstEvenets = new ArrayList<>();
    GridView lstData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        context=this;

        lstData = (GridView) findViewById(R.id.gridview);

        lstEvenets.add(new ZEvents("Sting", "http://demo8.semos.com.mk/imagesPort/sting.jpg","Concert"));
        lstEvenets.add(new ZEvents("Hamlet","http://demo8.semos.com.mk/imagesPort/hamlet.jpg","Theatre Show"));
        lstEvenets.add(new ZEvents("Star Wars: The Last Jedi","http://demo8.semos.com.mk/imagesPort/wars.jpeg","Movie"));
        lstEvenets.add(new ZEvents("2 Pac", "http://demo8.semos.com.mk/imagesPort/pac.jpg","Concert"));
        lstEvenets.add(new ZEvents("Arctic Monkeys", "http://demo8.semos.com.mk/imagesPort/monkeys.jpg","Concert"));

        customAdapter = new ListEventAdapter(context,R.layout.concert_layout, lstEvenets);
        lstData.setAdapter(customAdapter);

    }
}
