package com.example.dimit.portomontenegro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dimit.portomontenegro.adapters.ListEventAdapter;
import com.example.dimit.portomontenegro.objects.ZEvents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class EventFragment extends Fragment {

    public int PageNum=1;
    public int ItemCount=10;
    public boolean loading=false;
    View v = null;
    Context context;
    ListEventAdapter customAdapter;
    List<ZEvents> lstEvenets = new ArrayList<>();
    ListView lstData;

    public EventFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = container.getContext();

        //View rootView = inflater.inflate(R.layout.articles_page, container, false);
        v = inflater.inflate(R.layout.activity_sliding_menu, container, false);

        Init(v);

        BindListData();

        if (lstEvenets.size()==0) Start();


        return v;
    }


    public void Start()
    {
        lstEvenets.add(new ZEvents("Sting", "http://demo8.semos.com.mk/imagesPort/sting.jpg","Concert"));
        lstEvenets.add(new ZEvents("Hamlet","http://demo8.semos.com.mk/imagesPort/hamlet.jpg","Theatre Show"));
        lstEvenets.add(new ZEvents("Star Wars: The Last Jedi","http://demo8.semos.com.mk/imagesPort/wars.jpeg","Movie"));
        lstEvenets.add(new ZEvents("2 Pac", "http://demo8.semos.com.mk/imagesPort/pac.jpg","Concert"));
        lstEvenets.add(new ZEvents("Arctic Monkeys", "http://demo8.semos.com.mk/imagesPort/monkeys.jpg","Concert"));


    }

    private void Init(View v)
    {
        RecyclerView recyclerView = v.findViewById(R.id.rvDays);
        recyclerView.setVisibility(View.GONE);
        lstData = (ListView)v.findViewById(R.id.lstData);
    }

    public void BindListData()
    {
        customAdapter = new ListEventAdapter(context,R.layout.concert_layout, lstEvenets);
        lstData.setAdapter(customAdapter);
    }
}
