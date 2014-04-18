package com.maple.scheduleraw.View;

import java.util.ArrayList;
import java.util.List;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.MainActivity;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;
import com.maple.scheduleraw.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DayViewPagerAdapter extends FragmentStatePagerAdapter {
    
    private JazzyViewPager mJazzy;
    public DayViewPagerAdapter(FragmentManager fm) {
        super(fm);
//        mJazzy = jazzy;
//        mJazzy.setTransitionEffect(TransitionEffect.Accordion );
        // TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
        // TODO Auto-generated method stub
//        return new DayPagerFragment();
//    	switch (arg0) {
//        case 0:
//            // The first section of the app is the most interesting -- it offers
            // a launchpad into the other demonstrations in this example application.
//            return new LaunchpadSectionFragment();

//        default:
            // The other sections of the app are dummy placeholders.
            Fragment fragment = new DayPagerFragment();
            Bundle args = new Bundle();
            args.putInt(DayPagerFragment.ARG_SECTION_NUMBER, arg0+1);
            fragment.setArguments(args);
            return fragment;
    
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return 10;
    }
    
    
    
//    @Override
//    public Object instantiateItem(ViewGroup arg0,final int arg1) {
//        // TODO Auto-generated method stub
//        
//        Object obj = super.instantiateItem(arg0 , arg1);
//    
//        mJazzy.setObjectForPosition(obj, arg1);
//        return obj;
//    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("Dice");
            case 1:
                return ("Tree Vector");
            case 2:
                return ("Colorful Books");
            case 3:
                return ("Chair");
            case 4:
                return ("Very Beautiful Girl");
            case 5:
                return ("Troll Face");
            case 6:
                return ("Kael The Invoker");
            case 7:
                return ("Apple and the Rest");
            case 8:
                return ("Dice");
            default:
            	return ("Tree Vector");
        }
    }

}


