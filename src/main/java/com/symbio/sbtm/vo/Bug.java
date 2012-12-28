package com.symbio.sbtm.vo;

public class Bug {
	private String id;
	private String summary;
	private String description;
	private Charter charter;
	private String result;

	public Charter getCharter() {
		return charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.id);
	}
}
