package com.example.dimit.portomontenegro.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dimit.portomontenegro.R;
import com.example.dimit.portomontenegro.objects.ZEvents;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListEventAdapter extends ArrayAdapter<ZEvents> {

    Typeface font;
    Dialog dialog = null;
    Dialog webView = null;

    public ListEventAdapter(Context context, int resource, List<ZEvents> items) {

        super(context, resource, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ZEvents p = getItem(position);

        int RLayout = R.layout.concert_layout;


        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(RLayout, null);
        } else {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(RLayout, null);
        }

        if (p != null) {

            if(RLayout == R.layout.concert_layout)
            {
                LinearLayout llOpenTehaterEvent=(LinearLayout) v.findViewById(R.id.llOpenTheaterEvent);
                TextView txtTitle=(TextView) v.findViewById(R.id.txtTitle);
                TextView txtTypeEvent=(TextView) v.findViewById(R.id.txtTypeEvent);
                ImageView imgSrc = (ImageView) v.findViewById(R.id.imgSrc);
                final ImageButton btnBack=(ImageButton) v.findViewById(R.id.imgClose);
                final ScrollView scrollViewTheatre=(ScrollView) v.findViewById(R.id.scrollViewTheatre);

                if(txtTitle!=null)
                {
                    txtTitle.setText(p.Title);
                }
                if(txtTypeEvent!=null)
                {
                    txtTypeEvent.setText(p.Type);
                }

                if(imgSrc!=null)
                {
                        Picasso.with(v.getContext()).load(p.ImageUrl).into(imgSrc);
                }

                if(scrollViewTheatre!=null)
                {
                    scrollViewTheatre.setVisibility(View.GONE);
                }
                btnBack.setVisibility(View.GONE);
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scrollViewTheatre.setVisibility(View.GONE);
                        btnBack.setVisibility(View.GONE);
                    }
                });

                if(llOpenTehaterEvent!=null)
                {
                    llOpenTehaterEvent.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(scrollViewTheatre.getVisibility()==View.VISIBLE)
                            {
                                scrollViewTheatre.setVisibility(View.GONE);
                                btnBack.setVisibility(View.GONE);
                            }
                            else
                            {
                                btnBack.setVisibility(View.VISIBLE);
                                scrollViewTheatre.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }

        }

        return v;
    }

}