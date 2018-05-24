package com.example.dimit.portomontenegro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.dimit.portomontenegro.adapters.CustomGridView3;
import com.example.dimit.portomontenegro.adapters.Item;

import java.util.ArrayList;

public class Items extends Activity {

    public CustomGridView3 customGridAdapter;
    ArrayList<Item> gridArray = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        GridView gridView = (GridView) findViewById(R.id.gridview);

        Item i1 = new Item("http://demo6.semos.com.mk/assets/images/logonov.png");
        i1.ImageUrl="http://demo6.semos.com.mk/assets/images/logonov.png";
        gridArray.add(i1);
        gridArray.add(i1);
        gridArray.add(i1);

        customGridAdapter = new CustomGridView3(this, R.layout.row_gird_readingdigital, gridArray);
        gridView.setAdapter(customGridAdapter);
    }
}
