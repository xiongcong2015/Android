package cn.mobiletrain.asynctask;

import cn.mobiletrain.asynctask.util.ImageTask;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button button;
	private ImageView imageview;
	
//	private String URL = "http://photocdn.sohu.com/20111123/Img326603573.jpg";
	private String URL = "http://ff.topit.me/f/85/d8/11254028163d7d885fo.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		button = (Button) findViewById(R.id.button1);
		imageview = (ImageView) findViewById(R.id.imageView1);
		
		button.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			ImageTask imgTask = new ImageTask(imageview);
			imgTask.execute(URL);
			break;

		default:
			break;
		}
		
	}

}
