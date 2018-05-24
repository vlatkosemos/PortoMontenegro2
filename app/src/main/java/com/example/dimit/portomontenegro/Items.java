package com.example.dimit.portomontenegro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.GridView;
import android.widget.ListView;

import com.example.dimit.portomontenegro.adapters.CustomGridView3;
import com.example.dimit.portomontenegro.adapters.Item;
import com.example.dimit.portomontenegro.adapters.ListEventAdapter;
import com.example.dimit.portomontenegro.adapters.ListItemAdapter;
import com.example.dimit.portomontenegro.objects.UHelper;
import com.example.dimit.portomontenegro.objects.UModuleRequest;
import com.example.dimit.portomontenegro.objects.UModuleResponse;
import com.example.dimit.portomontenegro.objects.ZEvents;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Items extends Activity {

    Context context;
    public CustomGridView3 customGridAdapter;
    ArrayList<Item> gridArray = new ArrayList<Item>();

    ListItemAdapter customAdapter;
    List<ZEvents> lstEvenets = new ArrayList<>();
    GridView lstData;

    UModuleResponse res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        context=this;

        Start();
    }

    public void Start() {

        UModuleRequest req = new UModuleRequest();
        req.metod="GetItems";
        req.username="test";
        req.type="test";
        req.token="test";
        req.p1="0";
        req.p2="0";
        req.p3="0";
        startDialog(req);
    }

    private void startDialog(final UModuleRequest req) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                UHelper p = new UHelper(context);
                res=p.GetPodatoci2(req);
                handler.sendEmptyMessage(1);
            }
        }).start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                try {
                    JSONObject obj= new JSONObject(res.podatoci);
                    JSONArray sources=obj.getJSONArray("Items");
                    for(int i =0; sources.length()>i;i++)
                    {
                        JSONObject source = sources.getJSONObject(i);
                        String Title = source.getString("Title");
                        String ImageSrc=source.getString("ImageSrc");
                        lstEvenets.add(new ZEvents(Title, ImageSrc,"Concert"));
                        //.lstMyNews.add(new ZMyNews(Title,ImageSrc,Site,PublishDate,Link));
                    }
                }
                catch (JSONException ex)
                {

                }
                BindData();
            }
        }
    };

    public void BindData()
    {
        lstData = (GridView) findViewById(R.id.gridview);

        //lstEvenets.add(new ZEvents("Sting", "http://demo8.semos.com.mk/imagesPort/sting.jpg","Concert"));
        //lstEvenets.add(new ZEvents("Hamlet","http://demo8.semos.com.mk/imagesPort/hamlet.jpg","Theatre Show"));
        //lstEvenets.add(new ZEvents("Star Wars: The Last Jedi","http://demo8.semos.com.mk/imagesPort/wars.jpeg","Movie"));
        //lstEvenets.add(new ZEvents("2 Pac", "http://demo8.semos.com.mk/imagesPort/pac.jpg","Concert"));
        //lstEvenets.add(new ZEvents("Arctic Monkeys", "http://demo8.semos.com.mk/imagesPort/monkeys.jpg","Concert"));

        customAdapter = new ListItemAdapter(context,R.layout.concert_layout, lstEvenets);
        lstData.setAdapter(customAdapter);

    }

}
