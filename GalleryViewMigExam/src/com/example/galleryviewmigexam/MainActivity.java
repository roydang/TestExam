package com.example.galleryviewmigexam;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    PagerContainer mContainer;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        mContainer = (PagerContainer) findViewById(R.id.pager_container);
 
        ViewPager pager = mContainer.getViewPager();
        PagerAdapter adapter = new MyPagerAdapter();
        pager.setAdapter(adapter);
        //Necessary or the pager will only have one extra page to show
        // make this at least however many pages you can see
        pager.setOffscreenPageLimit(adapter.getCount());
        //A little space between pages
        pager.setPageMargin(15);
 
        //If hardware acceleration is enabled, you should also remove
        // clipping on the pager for its children.
        pager.setClipChildren(false);
    }
 
    //Nothing special about this adapter, just throwing up colored views for demo
    private class MyPagerAdapter extends PagerAdapter {
 
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            TextView view = new TextView(MainActivity.this);
//            view.setText("Item "+position);
//            view.setGravity(Gravity.CENTER);
//            view.setBackgroundColor(Color.argb(255, position * 50, position * 10, position * 50));
//            view.setTextColor(Color.WHITE);
        	ImageView imageView = new ImageView(MainActivity.this);
        	if (position==0) {
        		imageView.setBackgroundResource(R.drawable.a);
        	} else if (position==1){
        		imageView.setBackgroundResource(R.drawable.b);
        	} else if (position==2) {
        		imageView.setBackgroundResource(R.drawable.c);
        	}
            container.addView(imageView);
            return imageView;
        }
 
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
 
        @Override
        public int getCount() {
            return 3;
        }
 
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == object);
        }
    }

}
