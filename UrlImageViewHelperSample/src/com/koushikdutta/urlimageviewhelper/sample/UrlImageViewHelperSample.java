 package com.koushikdutta.urlimageviewhelper.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.*;
import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

public class UrlImageViewHelperSample extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem clear = menu.add("Clear Cache");
        clear.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                UrlImageViewHelper.cleanup(UrlImageViewHelperSample.this, 0);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        
        final Button search = (Button)findViewById(R.id.search);
        final EditText searchText = (EditText)findViewById(R.id.search_text);
        
//        mListView = (ListView)findViewById(R.id.results);
//        mAdapter = new MyAdapter(this);
//        MyGridAdapter a = new MyGridAdapter(mAdapter);
//        mListView.setAdapter(a);
//      
        ImageView  iv1 = (ImageView)findViewById(R.id.imageView1);
        UrlImageViewHelper.setUrlDrawable(iv1, "http://upload.wikimedia.org/wikipedia/commons/4/47/PNG_transparency_demonstration_1.png");
        

    } 
}