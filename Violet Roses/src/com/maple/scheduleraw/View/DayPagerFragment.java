package com.maple.scheduleraw.View;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.maple.scheduleraw.R;
import com.maple.scheduleraw.Activities.DisplayCommentActivity;
import com.maple.scheduleraw.Models.GlobalVariable;

public class DayPagerFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "section_number";

	private QuickAccessView mQuickAccessView;
	private boolean quickViewFlag = false;
	int countNumber;

	public DayPagerFragment() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		final View rootView = inflater.inflate(R.layout.day_pager_layout,
				container, false);
		final ListView periodList = (ListView) rootView
				.findViewById(R.id.period_list_for_day);
		final ImageView img = (ImageView) rootView
				.findViewById(R.id.main_image_view);
		final ImageButton comentBtn = (ImageButton) rootView
				.findViewById(R.id.imageButtonComent);
		final ImageButton shareBtn = (ImageButton) rootView
				.findViewById(R.id.imageButtonShare);

		setIndexPeriod(periodList, rootView.getContext());
		mQuickAccessView = new QuickAccessView(rootView.getContext());
		rootView.setFocusable(false);

		periodList.setFocusable(true);

		Bundle arg = getArguments();

		comentBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						DisplayCommentActivity.class);
				startActivity(intent);

			}
		});

		shareBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!quickViewFlag) {
					mQuickAccessView.showAtLocation(v, 0, 200, 450);
				}

			}
		});

		// String htmlCode = String.valueOf("")

		// wv.loadData(data, mimeType, encoding)
		img.setBackgroundResource(R.drawable.btn_background);
		img.setImageResource(R.drawable.btn_dialod);
		switch (arg.getInt(ARG_SECTION_NUMBER)) {
//		case 0:
//			UrlImageViewHelper.setUrlDrawable(img,
//					GlobalVariable.ImageURL.ULR1, R.drawable.loading);
//			break;
		case 1:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR1, R.drawable.loading);
			break;
		case 2:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR3, R.drawable.loading);
			break;
		case 3:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR4, R.drawable.loading);
			break;
		case 4:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR5, R.drawable.loading);
			break;
		case 5:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR6, R.drawable.loading);
			break;
		case 6:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR7, R.drawable.loading);
			break;
		case 7:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR8, R.drawable.loading);
			break;
		case 8:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR9, R.drawable.loading);
			break;
		case 9:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR1, R.drawable.loading);
			break;
		default:
			UrlImageViewHelper.setUrlDrawable(img,
					GlobalVariable.ImageURL.ULR3, R.drawable.loading);
			break;
		}

		return rootView;
	}

	// public void OnButtonClick(View v) {
	// mQuickAccessView.show(v);
	// }
	private void setIndexPeriod(ListView LV, Context context) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list.add("Tiet " + String.valueOf(i));
		}
		LV.setAdapter(new IndexPeriodAdapter(context,
				android.R.layout.simple_list_item_1, list));
	}

}