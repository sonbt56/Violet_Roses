package com.maple.scheduleraw.View;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.maple.scheduleraw.R;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

public class ScheduleFragment extends Fragment {

    ScrollView      mScroll;

    ViewPager       mViewPager;
    PagerTitleStrip mPagerTitle;
    int             focusedPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.time_table_layout, container, false);

        mViewPager = (ViewPager) view.findViewById(R.id.dayPager);
        mPagerTitle = (PagerTitleStrip) view.findViewById(R.id.pager_title_strip);
        mPagerTitle.setBackgroundColor(Color.parseColor("#872343"));
        mViewPager.setAdapter(new DayViewPagerAdapter(getFragmentManager()));
//        mViewPager.setPageTransformer(false, new CustomTransfomer());
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                focusedPage = arg0;
                if ((focusedPage == 6) || (focusedPage == 7))
                    mPagerTitle.setBackgroundColor(Color.parseColor("#872343"));
                else
                    mPagerTitle.setBackgroundColor(Color.parseColor("#337595"));
                mScroll.scrollTo(0, mScroll.getTop());
                Log.d(this.toString(), "MSCROLL_GETTED_TOP " + String.valueOf(mScroll.getTop()));
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
                mViewPager.getParent().getParent().requestDisallowInterceptTouchEvent(true);

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub\
                if (focusedPage == 0)
                    mViewPager.setCurrentItem(8, false);
                if (focusedPage == 9)
                    mViewPager.setCurrentItem(1, false);
                mScroll.scrollTo(0, mScroll.getTop());
            }
        });

        mScroll = (ScrollView) view.findViewById(R.id.main_scroll);
        mScroll.post(new Runnable() {
            public void run() {
                Log.d(this.toString(), "MSCROLL_GETTED_TOP " + String.valueOf(mScroll.getTop()));
                mScroll.scrollTo(0, mScroll.getTop());
            }
        });

        return view;
    }

}

class CustomTransfomer implements PageTransformer {

    private static float MIN_SCALE = 0.85f;
    private static float MIN_ALPHA = 0.5f;

    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        int pageHeight = view.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            
            view.setRotationY(0);
            view.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            view.setAlpha(1);
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                
                view.setTranslationX(pageWidth*-position);
                view.setPivotX(0);
                view.setPivotY(400);
                view.setCameraDistance(10000);
                view.setRotationY(180*position);
            } else {
                view.setTranslationX(pageWidth*-position);
            }

            // Scale the page down (between MIN_SCALE and 1)
//            view.setScaleX(scaleFactor);
//            view.setScaleY(scaleFactor);
            
            // Fade the page relative to its size.
//            view.setAlpha(MIN_ALPHA +
//                    (scaleFactor - MIN_SCALE) /
//                    (1 - MIN_SCALE) * (1 - MIN_ALPHA));

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setRotationY(0);
            view.setAlpha(0);
        }
    }

}
