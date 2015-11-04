package cn.mobiletrain.day27_listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;
import cn.mobiletrain.day27_listview.Model.Model;
import cn.mobiletrain.day27_listview.adapter.CheckAdapter;
import cn.mobiletrain.day27_listview.adapter.CheckAdapter.CallBack;

public class MainActivity extends Activity implements CallBack{
	
	private static final String TAG = MainActivity.class.getSimpleName();
	
	private ListView listview;
	List<Model> list;
	CheckAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		listview = (ListView) findViewById(R.id.listView);
		list = new ArrayList<Model>();
		for (int i = 0; i < 50; i++) {
			Model model = new Model(false, "stateLog:");
			list.add(model);
		}
		
		
		adapter = new CheckAdapter(getApplicationContext(), list);
		listview.setAdapter(adapter);
		adapter.setListener(this);
	}

	@Override
	public void onCheckChanged(int position) {
		// TODO Auto-generated method stub
		Log.d(TAG, adapter.getItem(position).getClass().toString());
		if (adapter.getItem(position) instanceof Model) {
			Model model = (Model) adapter.getItem(position);
			model.setChecked(!model.isChecked());
			model.setStateLog(model.getStateLog() + "|" + model.isChecked());
			Toast.makeText(
					getApplicationContext(), 
					"position: " + position + "--" + model.isChecked(), 
					Toast.LENGTH_SHORT
					).show();
		}
		adapter.notifyDataSetChanged();
	}

}
