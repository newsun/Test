package com.symbio.sbtm.vo;

public class Charter_Area {
	private int id;
	private Charter charter;
	private Area area;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Charter getCharter() {
		return charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

}
