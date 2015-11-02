package cn.mobiletrain.sampleasynctaskjson.beans;

import java.util.List;

public class TeaEntity {

	private String errorMessage;
	private List<DataEntity> data;
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<DataEntity> getData() {
		return data;
	}

	public void setData(List<DataEntity> data) {
		this.data = data;
	}

	public class DataEntity {
		private String id;
		private String title;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
	}
}
