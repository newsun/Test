package com.symbio.sbtm.model;

public class Duration {
	private String name;
	private int timespan;
	private String description;

	public int getTimespan() {
		return timespan;
	}

	public void setTimespan(int timespan) {
		this.timespan = timespan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
