package com.example.dimit.portomontenegro.adapters;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dimit.portomontenegro.R;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class CustomGridView3 extends ArrayAdapter<Item> {
	Context context;
	int layoutResourceId;
	ArrayList<Item> data = new ArrayList<Item>();

	public CustomGridView3(Context context, int layoutResourceId, ArrayList<Item> data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context; this.data = data;
	}

	@Override public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		RecordHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			row = inflater.inflate(layoutResourceId, parent, false);
			holder = new RecordHolder();
			holder.txtTitle = (TextView) row.findViewById(R.id.item_text);
			holder.imageItem = (ImageView) row.findViewById(R.id.item_image);
			holder.kng_brishi = (ImageView) row.findViewById(R.id.kng_brishi);
			holder.txtNaslov = (TextView) row.findViewById(R.id.naslov_kn_view);
			holder.txtAvtor = (TextView) row.findViewById(R.id.avtor_kn_view);
			holder.txtPrice = (TextView) row.findViewById(R.id.book_price);
			row.setTag(holder);
		}
		else
		{
			holder = (RecordHolder) row.getTag();
		}



		Item item = data.get(position);
		//holder.txtTitle.setText(item.getTitle());

		//holder.imageItem.setImageBitmap(item.getImage());
		if (holder.imageItem != null) {


				holder.txtTitle.setText(" ");
				holder.txtTitle.clearAnimation();
				holder.txtTitle.setVisibility(View.GONE);
				holder.kng_brishi.setVisibility(View.GONE);
				holder.kng_brishi.clearAnimation();


			if (data.get(position).image!=null){
				holder.imageItem.setImageBitmap(item.getImage());
			}
			else
			{
				//new BitmapWorkerTask(holder.imageItem,position).execute(data.get(position).title);

				String url = data.get(position).title;

				ImageLoader imageLoader = ImageLoader.getInstance();
				DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
						.cacheOnDisc(true).resetViewBeforeLoading(true)
						.showImageForEmptyUri(0)
						.showImageOnFail(0)
						.showImageOnLoading(0).build();

				//initialize image view
				//ImageView imageView = (ImageView) findViewById(R.id.imageView1)

				//download and display image from url
				imageLoader.displayImage(url, holder.imageItem, options);
			}

			holder.imageItem.setScaleType(ImageView.ScaleType.FIT_XY);
			holder.txtNaslov.setText(data.get(position).Name);
			holder.txtAvtor.setText(data.get(position).Author);



			Double Cena = data.get(position).Price;
			Double CenaSoPopust = data.get(position).DiscountPrice;

			Double CenaZaPlakanje = Cena;
			if (CenaSoPopust<Cena) CenaZaPlakanje=CenaSoPopust;

			if (CenaZaPlakanje>0)
			{
				holder.txtPrice.setText(String.format(Locale.GERMAN, "%1$,.0f", CenaZaPlakanje) + " " + "EUR");
			}

		}


		return row;
	}

	public static class RecordHolder {
		TextView txtTitle;
		ImageView imageItem;
		ImageView kng_brishi;
		TextView txtNaslov;
		TextView txtAvtor;
		TextView txtPrice;
	}


}


