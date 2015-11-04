package cn.mobiletrain.sampleasynctaskjson;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import cn.mobiletrain.sampleasynctaskjson.callback.JsonCallback;
import cn.mobiletrain.sampleasynctaskjson.utils.JsonTask;

public class MainActivity extends Activity {
	
	private static final String JSON_URL = "http://sns.maimaicha.com/api?apikey=b4f4ee31a8b9acc866ef2afb754c33e6&format=json&method=news.getListByType&page=0&row=15&type=52";
	private Spinner spinner;
	public static JsonCallback jsonCallback;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		spinner = (Spinner) findViewById(R.id.spinner1);
		
		jsonCallback = new JsonCallback() {
			
			@Override
			public void setSpinnerData(List<String> datas) {
				// TODO Auto-generated method stub
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						getApplicationContext(),
						R.layout.spinner_item,
						datas);
				spinner.setAdapter(adapter);
			}
		};
		
	}
	
	public void downloadJson(View view) {
		// TODO Auto-generated method stub
		JsonTask task = new JsonTask();
		task.execute(JSON_URL);
	}

}
