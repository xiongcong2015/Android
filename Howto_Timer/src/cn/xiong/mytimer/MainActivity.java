package cn.xiong.mytimer;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private TextView time;
	private int count;
	private final int MSG_WHAT = 1;
	private Timer timer;
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			switch (msg.what) {
			case MSG_WHAT:
				time.setText("" + count);
				if (count > 0) {
					count--;
				} else {
					timer.cancel();
					timer = null;
					Toast.makeText(MainActivity.this, "倒计时停止", Toast.LENGTH_SHORT).show();
				}
				break;

			default:
				break;
			}
		}
		
	};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		time = (TextView) findViewById(R.id.time_tv);
	}
	
	/*
	 * 按钮点击事件监听
	 */
	public void startTimer(View view) {
		// TODO Auto-generated method stub
		count = 10;
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.d("1511", "count : " + count);
				handler.sendEmptyMessage(MSG_WHAT);
				
			}
		}, 0, 1 * 1000);

	}

}
