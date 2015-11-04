package cn.mobiletrain.sampleasynctaskjson.utils;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;
import cn.mobiletrain.sampleasynctaskjson.MainActivity;
import cn.mobiletrain.sampleasynctaskjson.beans.TeaEntity;
import cn.mobiletrain.sampleasynctaskjson.beans.TeaEntity.DataEntity;

import com.google.gson.Gson;

public class JsonTask extends AsyncTask<String, Void, List<DataEntity>> {

	@Override
	protected List<DataEntity> doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = params[0];
		String json = HttpUtils.getJsonFromUrl(url);
		
		Gson gson = new Gson();
		TeaEntity teaEntity = gson.fromJson(json, TeaEntity.class);
		List<DataEntity> list  =teaEntity.getData();
		
		return list;
	}

	@Override
	protected void onPostExecute(List<DataEntity> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
		List<String> titles = new ArrayList<String>();
		for (DataEntity dataEntity : result) {
			String title = dataEntity.getTitle();
			String id = dataEntity.getId();
			
			titles.add(title);
			Log.d("1511", "id: " + id + ", title: " + title);
		}
		
		MainActivity.jsonCallback.setSpinnerData(titles);
	}

}
