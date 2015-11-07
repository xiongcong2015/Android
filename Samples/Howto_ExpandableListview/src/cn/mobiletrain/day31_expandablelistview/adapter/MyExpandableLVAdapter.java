package cn.mobiletrain.day31_expandablelistview.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import cn.mobiletrain.day31_expandablelistview.R;
import cn.mobiletrain.day31_expandablelistview.model.FatherModel;

/**
 * @author: xiong'cong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-7 上午10:24:57
 * 
 */
public class MyExpandableLVAdapter extends BaseExpandableListAdapter {

	private static final String TAG = MyExpandableLVAdapter.class.getSimpleName();

	private List<FatherModel> data;
	private LayoutInflater inflater;
	private Context context;

	public MyExpandableLVAdapter(List<FatherModel> data, Context context) {
		super();
		this.data = data;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getChildType(int groupPosition, int childPosition) {
		return data.get(groupPosition).getChildren().get(childPosition).getViewType();
	}

	@Override
	public int getChildTypeCount() {
		return 2;
	}

	@Override
	public int getGroupType(int groupPosition) {
		return data.get(groupPosition).getViewType();
	}

	@Override
	public int getGroupTypeCount() {
		return 2;
	}

	@Override
	public int getGroupCount() {
		Log.d(TAG, "getGroupCount, data.size() = " + data.size());
		return data != null ? data.size() : 0;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return data.get(groupPosition).getChildren().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return data.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return data.get(groupPosition).getChildren().get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		GroupViewHolder groupViewHolder = null;
		if (convertView == null) {
			groupViewHolder = new GroupViewHolder();
			convertView = inflater.inflate(R.layout.item_group, parent, false);
			groupViewHolder.textview = (TextView) convertView.findViewById(R.id.group_name);
			convertView.setTag(groupViewHolder);
		} else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}

		groupViewHolder.textview.setText(data.get(groupPosition).getName());

		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		/*
		 * 用两个ViewHolder
		 */
/*		switch (data.get(groupPosition).getChildren().get(childPosition).getViewType()) {
		case 0:
			ChildViewHolder2 childViewHolder2 = null;
			if (convertView == null) {
				childViewHolder2 = new ChildViewHolder2();
				convertView = inflater.inflate(R.layout.item_child2, parent, false);
				childViewHolder2.textview = (TextView) convertView.findViewById(R.id.child_name2);
				convertView.setTag(childViewHolder2);
			} else {
				childViewHolder2 = (ChildViewHolder2) convertView.getTag();
			}
			
			childViewHolder2.textview.setText(data.get(groupPosition).getChildren()
					.get(childPosition).getName());
			// 设置TextView中的图片显示
			Drawable img = context.getResources().getDrawable(R.drawable.ic_launcher);
			img.setAlpha(50);
			img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
			childViewHolder2.textview.setCompoundDrawables(null, null, img, null);
			
			break;
		case 1:
			ChildViewHolder childViewHolder = null;
			if (convertView == null) {
				childViewHolder = new ChildViewHolder();
				convertView = inflater.inflate(R.layout.item_child, parent, false);
				childViewHolder.textview = (TextView) convertView.findViewById(R.id.child_name);
				convertView.setTag(childViewHolder);
			} else {
				childViewHolder = (ChildViewHolder) convertView.getTag();
			}
			
			childViewHolder.textview.setText(data.get(groupPosition).getChildren()
					.get(childPosition).getName());
			
			break;

		default:
			break;
		}
*/
		/*
		 * 用一个ViewHolder
		 */
		ChildViewHolder childViewHolder = null;
		if (convertView == null) {
			childViewHolder = new ChildViewHolder();
			convertView = inflater.inflate(R.layout.item_child, parent, false);
			childViewHolder.textview = (TextView) convertView.findViewById(R.id.child_name);
			convertView.setTag(childViewHolder);
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();
		}
		
		childViewHolder.textview.setText(data.get(groupPosition).getChildren()
				.get(childPosition).getName());

		switch (data.get(groupPosition).getChildren().get(childPosition).getViewType()) {
		case 0:
			// 设置TextView中的图片显示
			Drawable img = context.getResources().getDrawable(R.drawable.ic_launcher);
			img.setAlpha(50);
			img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
			childViewHolder.textview.setCompoundDrawables(null, null, img, null);
			break;
		case 1:
			break;
		}
		
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	private static class GroupViewHolder {
		TextView textview;
	}
	private static class ChildViewHolder {
		TextView textview;
	}
/*	private static class ChildViewHolder2 {
		TextView textview;
	}*/

}
