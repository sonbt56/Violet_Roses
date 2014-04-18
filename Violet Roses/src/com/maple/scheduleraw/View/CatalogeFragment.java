package com.maple.scheduleraw.View;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.maple.scheduleraw.R;
import com.maple.scheduleraw.Models.GlobalVariable;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CatalogeFragment extends Fragment{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.cataloge_layout, container, false);
        final ImageView Img1 = (ImageView)view.findViewById(R.id.imagePeople);
        final ImageView Img2 = (ImageView)view.findViewById(R.id.imageAnimal);
        final ImageView Img3 = (ImageView)view.findViewById(R.id.imageLandcape);
        final ImageView Img4 = (ImageView)view.findViewById(R.id.imageFunny);
        
        UrlImageViewHelper.setUrlDrawable(Img1,
				GlobalVariable.ImageURL.ULR8, R.drawable.loading);
        UrlImageViewHelper.setUrlDrawable(Img2,
				GlobalVariable.ImageURL.ULR9, R.drawable.loading);
        UrlImageViewHelper.setUrlDrawable(Img3,
				GlobalVariable.ImageURL.ULR10, R.drawable.loading);
        UrlImageViewHelper.setUrlDrawable(Img4,
				GlobalVariable.ImageURL.ULR11, R.drawable.loading);
//        
		
        return view;
        
	} 

}
