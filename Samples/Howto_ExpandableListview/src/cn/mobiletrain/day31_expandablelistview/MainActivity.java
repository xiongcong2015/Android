package cn.mobiletrain.day31_expandablelistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;
import android.widget.ExpandableListView.OnGroupClickListener;
import cn.mobiletrain.day31_expandablelistview.adapter.MyExpandableLVAdapter;
import cn.mobiletrain.day31_expandablelistview.model.ChildModel;
import cn.mobiletrain.day31_expandablelistview.model.FatherModel;

public class MainActivity extends Activity implements OnGroupClickListener, OnChildClickListener {
	
	private static final String TAG = MainActivity.class.getSimpleName();
	
	private ExpandableListView mExpandableListview;
	private List<FatherModel> fatherList;
	private MyExpandableLVAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	private List<FatherModel> getData() {
		
		fatherList = new ArrayList<FatherModel>();
		for (int i = 0; i < 8; i++) {
			FatherModel fatherModel = new FatherModel();
			fatherModel.setName("Group--->" + i);
			
			List<ChildModel> childList = new ArrayList<ChildModel>();
			for (int j = 0; j < 20; j++) {
				ChildModel childModel = new ChildModel();
				childModel.setName("CCCCCCCCChild--->" + j);
				childModel.setViewType(j%4 == 0 ? 0 : 1);
				childList.add(childModel);
			}
			fatherModel.setChildren(childList);
			Log.d(TAG, "childList: " + childList);
			Log.d(TAG, "fatherModel: " + fatherModel);
			Log.d(TAG, "fatherList(before add): " + fatherList);
			
			fatherList.add(fatherModel);
		}
		Log.d(TAG, "fatherList(after add): " + fatherList);
		return fatherList;
				
	
	}

	private void initView() {
		mExpandableListview = (ExpandableListView) findViewById(R.id.expandable_lv);
		adapter = new MyExpandableLVAdapter(getData(), getApplicationContext());
		mExpandableListview.setAdapter(adapter);
		mExpandableListview.setOnGroupClickListener(this);
		mExpandableListview.setOnChildClickListener(this);
	}

	@Override
	public boolean onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		Toast.makeText(getApplicationContext(), "onGroupClicked: GroupPosition" + groupPosition, Toast.LENGTH_SHORT).show();
		Log.d(TAG, "onGroupClicked: GroupPosition" + groupPosition);
		return false;
	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		Toast.makeText(getApplicationContext(), "onChildClick: ChildPosition" + childPosition, Toast.LENGTH_SHORT).show();
		Log.d(TAG, "onChildClick: ChildPosition" + childPosition);
		return false;
	}

}
