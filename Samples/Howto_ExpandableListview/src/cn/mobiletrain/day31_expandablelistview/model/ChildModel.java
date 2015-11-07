package cn.mobiletrain.day31_expandablelistview.model;
/**
 * @author: xiongcong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-7 上午10:27:20
 * 
 */
public class ChildModel {
	private String name;
	private int viewType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getViewType() {
		return viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	@Override
	public String toString() {
		return "ChildModel [name=" + name + "]";
	}
	
}
