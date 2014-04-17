package com.maple.scheduleraw.Activities;

import java.util.ArrayList;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.maple.scheduleraw.R;
import com.maple.scheduleraw.View.CatalogeFragment;
import com.maple.scheduleraw.View.QuickAccessView;
import com.maple.scheduleraw.View.ScheduleFragment;

import android.os.Bundle;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {
    
    
    
    
    ListFragment Lfr = new ListFragment();
    boolean flag= false;
    SlidingMenu menu;
    final ArrayList<Button> listOfButton = new ArrayList<Button>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("RAw");
        // set the content view
        setContentView(R.layout.content_view);

        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.setBehindWidthRes(R.dimen.behind_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        menu.setMenu(R.layout.activity_main);
        
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainfragment, new ScheduleFragment()).commit();
        
        
        listOfButton.add( (Button) findViewById(R.id.imageButton1));
        listOfButton.add( (Button) findViewById(R.id.imageButton2)); 
        listOfButton.add( (Button) findViewById(R.id.imageButton3)); 
        listOfButton.add( (Button) findViewById(R.id.imageButton4)); 
        
        listOfButton.get(0).setBackgroundResource(R.drawable.btn_background_2);
    
//        setUpQuickView();
    }
    
//    public void setUpQuickView() {
//        mQuickAccessView = new QuickAccessView(this);
//    }

    public void setMenuLayout(ViewGroup mViewGroup) {
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < 6; i++) {
            final boolean visibilityFlag = false;
            View v = inflater.inflate(R.layout.menu_item, null);
            final ImageView imgView = (ImageView) v.findViewById(R.id.item_indicator);
            imgView.setVisibility(imgView.GONE);
            v.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    imgView.setVisibility((imgView.getVisibility() == View.VISIBLE) ? View.GONE
                            : View.VISIBLE);
                }
            });
            mViewGroup.addView(v);
            
            
        }
    }
    
    public void OnItemClick(View v) {
        for(Button mb:listOfButton) {
            mb.setAlpha((float)1);
            mb.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_background));
        }
        v.setAlpha((float)1 );
        v.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_background_2));
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainfragment, new CatalogeFragment()).commit();
        menu.showContent(true);
        
    }
    public void OnFirstItemClick(View v) {
        for(Button mb:listOfButton) {
            mb.setAlpha((float)1);
            mb.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_background));
        }
        v.setAlpha((float)1 );
        v.setBackgroundDrawable(getResources().getDrawable(R.drawable.btn_background_2));
        getSupportFragmentManager().beginTransaction()
        .replace(R.id.mainfragment, new ScheduleFragment()).commit();
        menu.showContent(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
