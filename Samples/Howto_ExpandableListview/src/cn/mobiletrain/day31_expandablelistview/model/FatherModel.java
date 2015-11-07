package cn.mobiletrain.day31_expandablelistview.model;

import java.util.List;

/**
 * @author: xiongcong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-7 上午10:28:11
 * 
 */
public class FatherModel {
	
	private String name;
	private List<ChildModel> children;
	private int viewType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ChildModel> getChildren() {
		return children;
	}
	public void setChildren(List<ChildModel> children) {
		this.children = children;
	}
	public int getViewType() {
		return viewType;
	}
	public void setViewType(int viewType) {
		this.viewType = viewType;
	}
	@Override
	public String toString() {
		return "FatherModel [name=" + name + ", children=" + children + "]";
	}
	
}
