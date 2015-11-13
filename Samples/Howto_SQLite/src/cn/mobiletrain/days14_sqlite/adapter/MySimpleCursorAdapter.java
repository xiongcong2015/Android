package cn.mobiletrain.days14_sqlite.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import cn.mobiletrain.days14_sqlite.R;
import cn.mobiletrain.days14_sqlite.utils.DBUtils;

/**
 * @author: xiongcong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-13 上午10:50:40
 * 
 */
public class MySimpleCursorAdapter extends SimpleCursorAdapter {
	
	private Button btn1, btn2;
	
	private String tag = "MySimpleCursorAdapter";
	private DBUtils dbUtils;
	private Cursor c;

	/**
	 * 添加构造方法
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @param context
	* @param layout
	* @param c
	* @param from
	* @param to
	* @param flags
	 */
	public MySimpleCursorAdapter(Context context, int layout, Cursor c,
			String[] from, int[] to, int flags) {
		super(context, layout, c, from, to, flags);
		this.c = c;
		this.dbUtils = new DBUtils(context);
	}

	@Override
	public void bindView(final View view, final Context context, Cursor cursor) {
		super.bindView(view, context, cursor);

		btn1 = (Button) view.findViewById(R.id.button1);
		btn2 = (Button) view.findViewById(R.id.button2);
		TextView tv = (TextView) view.findViewById(R.id.textView1);
		TextView tv2 = (TextView) view.findViewById(R.id.textView2);
		final String id = tv.getText().toString();
		final String name = tv2.getText().toString();
		
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				
				builder.setTitle("修改工资金额");
				View view = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null, false);
				TextView tv = (TextView) view.findViewById(R.id.textView1);
				final EditText et = (EditText) view.findViewById(R.id.editText1);
				tv.setText(name);
				
				builder.setView(view);
				
				builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						String salary = et.getText().toString();
						dbUtils.update1(id, salary);
						c = dbUtils.query1();
						MySimpleCursorAdapter.this.swapCursor(c);
					}
				});
				builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				builder.show();
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.i(tag, "被点击id是：" + id);
				
				dbUtils.delete1(id);
				c = dbUtils.query1();
				MySimpleCursorAdapter.this.swapCursor(c);
			}
		});
	}

}
