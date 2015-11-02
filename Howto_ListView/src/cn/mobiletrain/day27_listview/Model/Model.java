package cn.mobiletrain.day27_listview.Model;

public class Model {

	private boolean isChecked;
	private String stateLog;
	
	public Model(boolean isChecked, String stateLog) {
		super();
		this.isChecked = isChecked;
		this.stateLog = stateLog;
	}
	
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getStateLog() {
		return stateLog;
	}
	public void setStateLog(String stateLog) {
		this.stateLog = stateLog;
	}
	
}
