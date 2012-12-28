package com.symbio.sbtm.vo;

public class Strategies {
	private int id;
	private Charter charter;
	private Strategy strategy;

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

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		return String.valueOf(this.id);
	}

}
