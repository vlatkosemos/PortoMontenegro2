package com.example.dimit.portomontenegro.adapters;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dimit.portomontenegro.R;
import com.example.dimit.portomontenegro.objects.ZEvents;
import com.example.dimit.portomontenegro.objects.ZFacilities;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListFacilitiesAdapter  extends ArrayAdapter<ZFacilities> {

    Typeface font;
    Dialog dialog = null;
    Dialog webView = null;

    public ListFacilitiesAdapter(Context context, int resource, List<ZFacilities> items) {

        super(context, resource, items);
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ZFacilities p = getItem(position);

        int RLayout = R.layout.facilities_item;


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

            if(RLayout == R.layout.facilities_item)
            {
                LinearLayout llOpenTehaterEvent=(LinearLayout) v.findViewById(R.id.llOpenTheaterEvent);
                TextView txtTitle=(TextView) v.findViewById(R.id.txtTitle);
                ImageView imgSrc = (ImageView) v.findViewById(R.id.imageSrc);
                final ImageView imgOrder = (ImageView) v.findViewById(R.id.ordericon);

                imgOrder.setVisibility(View.GONE);

                if(txtTitle!=null)
                {
                    txtTitle.setText(p.Title);
                }
                if(imgSrc!=null)
                {
                    Picasso.with(v.getContext()).load(p.ImageUrl).into(imgSrc);
                }


                if(llOpenTehaterEvent!=null)
                {
                    llOpenTehaterEvent.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(imgOrder.getVisibility() == View.GONE){

                                imgOrder.setVisibility(View.VISIBLE);
                            }else {
                                imgOrder.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }

        }

        return v;
    }

}