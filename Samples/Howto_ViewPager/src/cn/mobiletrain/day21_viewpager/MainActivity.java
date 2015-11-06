package cn.mobiletrain.day21_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	/*
	 * 我们需要：
	 * 一个ViewPager，存放View
	 * 一个整形数组int[] images，存放图片资源
	 * 一个列表List<ImageView> imageList，存放ImageView
	 * 还需要适配器PagerAdapter
	 */
	private ViewPager mViewPager;
	private int[] images;
	private List<ImageView> imageList;
	private PagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initData();
		initView();
	}

	private void initData() {
		images = new int[]{
				R.drawable.lolpic001, R.drawable.lolpic002, R.drawable.lolpic003, 
				R.drawable.lolpic004, R.drawable.lolpic005, R.drawable.lolpic006, 
				R.drawable.lolpic007, R.drawable.lolpic008, R.drawable.lolpic009, 
				R.drawable.lolpic010
		};
		imageList = new ArrayList<ImageView>();
		for (int i = 0; i < images.length; i++) {
			ImageView iv = new ImageView(this);
			iv.setImageResource(images[i]);
			imageList.add(iv);
		}
		adapter = new PagerAdapter() {
			
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
//				super.destroyItem(container, position, object);
				container.removeView(imageList.get(position));
			}
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				container.addView(imageList.get(position));
				return imageList.get(position);
			}
			
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}
			
			@Override
			public int getCount() {
				return imageList.size();
			}
		};
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.image_vp);
		mViewPager.setAdapter(adapter);
	}

}
