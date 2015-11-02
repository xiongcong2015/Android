package cn.mobiletrain.day27_listview.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import cn.mobiletrain.day27_listview.R;
import cn.mobiletrain.day27_listview.Model.Model;

public class CheckAdapter extends BaseAdapter implements OnClickListener {

	private static final String TAG = CheckAdapter.class.getSimpleName();

	private List<Model> data;
	private LayoutInflater inflater;
	private CallBack listener;

	public void setListener(CallBack listener) {
		this.listener = listener;
	}

	public CheckAdapter(Context context, List<Model> data) {
		super();
		this.data = data;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.layout_item, parent, false);
			holder.checkbox = (CheckBox) convertView
					.findViewById(R.id.checkBox);
			holder.textview = (TextView) convertView
					.findViewById(R.id.textView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.checkbox.setChecked(data.get(position).isChecked());
		holder.checkbox.setTag(position);

		holder.textview.setText(data.get(position).getStateLog());

		holder.checkbox.setOnClickListener(this);

		return convertView;
	}

	public class ViewHolder {
		CheckBox checkbox;
		TextView textview;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.checkBox:
			Log.d(TAG, v.getTag().toString());
			listener.onCheckChanged((int) v.getTag());
			break;

		default:
			break;
		}
	}

	public interface CallBack {
		void onCheckChanged(int position);
	}

}
