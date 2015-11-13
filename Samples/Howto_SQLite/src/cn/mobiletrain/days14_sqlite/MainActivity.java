package cn.mobiletrain.days14_sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import cn.mobiletrain.days14_sqlite.adapter.MySimpleCursorAdapter;
import cn.mobiletrain.days14_sqlite.utils.DBUtils;
import cn.mobiletrain.days14_sqlite.utils.MySQLiteOpenHelper;

public class MainActivity extends Activity {
	
	private static final String tag = "MainActivity";
	private EditText et1, et2;
	private ListView listview;
	
	private String name;
	private String salary;
	private Cursor c;
	
	private SimpleCursorAdapter adapter;
	private DBUtils dbUtils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		// TODO 初始化控件
		et1 = (EditText) findViewById(R.id.id_et1);
		et2 = (EditText) findViewById(R.id.id_et2);
		listview = (ListView) findViewById(R.id.id_listview);
		dbUtils = new DBUtils(this);

		// 查询所有人的信息
		c = dbUtils.query1();
		String from[] = {"_id", "name", "salary"};
		int to[] = {R.id.textView1, R.id.textView2, R.id.textView3};
		//adapter = new SimpleCursorAdapter(this, R.layout.custom_item_layout, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		adapter = new MySimpleCursorAdapter(this, R.layout.custom_item_layout, c, from, to, SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		listview.setAdapter(adapter);
		
		// 给listview注册滚动监听器
		listview.setOnScrollListener(new OnScrollListener() {
			
			private boolean flag = false;
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				Log.i(tag, "scrollState: " + scrollState);
				if (scrollState == SCROLL_STATE_IDLE && flag) {
					int count = adapter.getCount();
					MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(MainActivity.this, "android.db", null, 1);
					SQLiteDatabase db = openHelper.getWritableDatabase();
					String sql = "SELECT id _id, name, salary FROM PERSON LIMIT ?, ?";
					c = db.rawQuery(sql, new String[]{"0", (count+10)+""});
					adapter.swapCursor(c);
				}
			}
			
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {
				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					flag = true;
				}
			}
		});
	}
	
	/**
	 * 
	 * @Title: commitData 
	 * @说       明: 当点击提交按钮后将用户输入的信息保存到数据库中
	 * @参       数: @param view   
	 * @return void    返回类型 
	 * @throws
	 */
	public void commitData(View view) {
		name = et1.getText().toString();
		salary = et2.getText().toString();
		
		dbUtils.insert2(name, salary);
		c = dbUtils.query2();
		// 刷新listview中的数据
		adapter.swapCursor(c);
	}


}

































