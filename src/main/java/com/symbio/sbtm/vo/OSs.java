package com.symbio.sbtm.vo;

public class OSs {
	private int id;
	private Charter charter;
	private OS os;

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

	public OS getOs() {
		return os;
	}

	public void setOs(OS os) {
		this.os = os;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.id);
	}

}
