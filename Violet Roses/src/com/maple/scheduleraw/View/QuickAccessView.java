package com.maple.scheduleraw.View;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;
import com.maple.scheduleraw.R;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class QuickAccessView extends PopupWindow {

    private ViewGroup mFrame;
    private ViewGroup mContainer;
    private Animation fallAnimation;
    private Animation goUpAnimation;

    public static int mState;

    private Context   mContext;
    private int       mLocation[];
    private int       mScreenWidth;
    private int       mScreenHeigth;
    private int       downOffset;
    private int       leftOffset;
    private ImageView arrowUp;
    private ImageView arrowDown;
    private TextView mTextView;

    public QuickAccessView(Context context) {
        // TODO Auto-generted constructor stub
        super(context);
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        mContext = context;

        this.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        this.setBackgroundDrawable(new ColorDrawable());
        setContentView(R.layout.quick_access_layout);
        
        initStaticPart();
    }

    public void setContentView(int ResourceId) {
        setContentView(LayoutInflater.from(mContext).inflate(ResourceId, null));
    }

    public void initStaticPart() {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        WindowManager wdManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        wdManager.getDefaultDisplay().getMetrics(displaymetrics);
        mScreenWidth = displaymetrics.widthPixels;
        mScreenHeigth = displaymetrics.heightPixels;
        
        
        fallAnimation = AnimationUtils.loadAnimation(mContext, R.anim.quickview_animation_down );
        goUpAnimation =AnimationUtils.loadAnimation(mContext, R.anim.quickview_amin_up);
        
        mContainer = (ViewGroup) getContentView().findViewById(R.id.quick_access_background);
        arrowUp = (ImageView) getContentView().findViewById(R.id.arrow_up);
        arrowDown = (ImageView) getContentView().findViewById(R.id.arrow_down);
        
        arrowDown.setVisibility(View.GONE);
        arrowUp.setVisibility(View.GONE);
        
        leftOffset = 149; //detected by logcat.
        downOffset = 208; //detected by logcat.
        
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                // TODO Auto-generated method stub
            	mContainer.startAnimation(fallAnimation);
                
            }
        });
        
    }
    
    

    @Override
	public void showAtLocation(View parent, int gravity, int x, int y) {
		// TODO Auto-generated method stub
		super.showAtLocation(parent, gravity, x, y);
		mContainer.startAnimation(goUpAnimation);
	}

	public void show(View view) {
        
        
        final TextView tv;
        tv = (TextView) view.findViewById(R.id.tv_index_period);
        tv.setBackgroundResource(R.drawable.btn_background_3_chosen);
        mTextView=tv;
        
        Log.d("LEFT OFFSET", String.valueOf(leftOffset));
        Log.d("DOWN OFFSET", String.valueOf(downOffset));
        int loc[] = new int[10];
        view.getLocationOnScreen(loc);
//        view.setPivotX(view.getWidth()/2);
//        view.setPivotY(view.getHeight());
//        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(mContext,
//                R.animator.open_animator);
//            set.setTarget(view);
//            set.start();
        if (loc[1] < mScreenWidth *3 / 5) {
            arrowDown.setVisibility(View.GONE);
            arrowUp.setVisibility(View.VISIBLE);
            this.showAtLocation(view, Gravity.NO_GRAVITY,
                    loc[0] + view.getWidth() / 2 - leftOffset,
                    loc[1] + view.getHeight());
            mContainer.startAnimation(fallAnimation);
            arrowUp.startAnimation(fallAnimation);
        }
        else {
            arrowUp.setVisibility(View.GONE);
            arrowDown.setVisibility(View.VISIBLE);
            this.showAtLocation(
                    view,
                    Gravity.NO_GRAVITY,
                    loc[0] + view.getWidth() / 2 - leftOffset,
                    loc[1] +  - downOffset
                            - view.getHeight());
            mContainer.startAnimation(goUpAnimation);
            arrowDown.startAnimation(goUpAnimation);
        }
        
        
//        leftOffset = mContainer.getWidth() / 2 ;
//        downOffset = mContainer.getRootView().getHeight() +view.getHeight() +view.getHeight();
    }
}
