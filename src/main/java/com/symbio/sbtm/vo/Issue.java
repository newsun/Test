package com.symbio.sbtm.vo;

public class Issue {
	private int id;
	private String summary;
	private String description;
	private Charter charter;

	public Charter getCharter() {
		return charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.id);
	}

}
