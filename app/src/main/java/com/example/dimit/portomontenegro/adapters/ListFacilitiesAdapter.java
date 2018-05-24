package com.example.dimit.portomontenegro.adapters;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.dimit.portomontenegro.Facilities;
import com.example.dimit.portomontenegro.R;
import com.example.dimit.portomontenegro.objects.ZEvents;
import com.example.dimit.portomontenegro.objects.ZFacilities;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ListFacilitiesAdapter  extends ArrayAdapter<ZFacilities> {

    Typeface font;
    Dialog dialog = null;
    Dialog webView = null;
    EditText editDate;
    Calendar myCalendar = Calendar.getInstance();
    String dateFormat = "dd.MM.yyyy";
    DatePickerDialog.OnDateSetListener date;
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.GERMAN);

    public ListFacilitiesAdapter(Context context, int resource, List<ZFacilities> items) {


        super(context, resource, items);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

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
                final LinearLayout llOpenTehaterEvent=(LinearLayout) v.findViewById(R.id.llOpenTheaterEvent);
                TextView txtTitle=(TextView) v.findViewById(R.id.txtTitle);
                ImageView imgSrc = (ImageView) v.findViewById(R.id.imageSrc);

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
                           Calendar calendar  = Calendar.getInstance();
                           int year = calendar.get(Calendar.YEAR);
                           int month = calendar.get(Calendar.MONTH);
                           int day = calendar.get(Calendar.DAY_OF_MONTH);

                           DatePickerDialog dialog = new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Light_Dialog_MinWidth,date,year,month,day);
                           dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                           dialog.show();
                        }
                    });
                    date = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            llOpenTehaterEvent.setBackgroundResource(R.drawable.grayfaciselected);
                        }
                    };
                }
                
            }

        }

        return v;
    }

}