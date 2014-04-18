package com.maple.scheduleraw.Activities;

import com.maple.scheduleraw.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;

public class DisplayCommentActivity extends Activity {
	
	WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comment_field_activities);
		wv = (WebView) findViewById(R.id.webViewComment);
		wv.loadUrl("http://www.prophoto.com/site/wp-content/uploads/2012/03/fb-coments.png");
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
