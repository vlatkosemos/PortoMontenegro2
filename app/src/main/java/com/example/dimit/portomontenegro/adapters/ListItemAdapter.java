package com.example.dimit.portomontenegro.adapters;

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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dimit.portomontenegro.R;
import com.example.dimit.portomontenegro.objects.ZEvents;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListItemAdapter extends ArrayAdapter<ZEvents> {

    Typeface font;
    Dialog dialog = null;
    Dialog webView = null;

    public ListItemAdapter(Context context, int resource, List<ZEvents> items) {

        super(context, resource, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ZEvents p = getItem(position);

        int RLayout = R.layout.row_gird_readingdigital;


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

            if(RLayout == R.layout.row_gird_readingdigital)
            {
                final LinearLayout llOpenTehaterEvent=(LinearLayout) v.findViewById(R.id.llOpenTheaterEvent);
                TextView txtTitle=(TextView) v.findViewById(R.id.txtTitle);
                TextView txtPrice=(TextView) v.findViewById(R.id.txtPrice);
                ImageView imgSrc = (ImageView) v.findViewById(R.id.imgSrc);
                final ImageButton btnBack=(ImageButton) v.findViewById(R.id.imgClose);
                final ScrollView scrollViewTheatre=(ScrollView) v.findViewById(R.id.scrollViewTheatre);

                if(txtTitle!=null)
                {
                    txtTitle.setText(p.Title);
                }

                if(txtPrice!=null)
                {
                    txtPrice.setText(p.Type+" $");
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
                            Toast.makeText(getContext(),"Clicked: "+p.Title,Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }

        }

        return v;
    }

}
