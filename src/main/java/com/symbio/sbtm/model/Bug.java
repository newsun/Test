package com.symbio.sbtm.model;

import java.io.Serializable;

import javax.persistence.*;

//@Entity
public class Bug implements Serializable{

	/**
     * 
     */
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private long id;

	@Column(name = "summary", length = 50)
	private String summary;

	@Column(name = "precedure", length = 250)
	private String precedure;

	@Column(name = "description", length = 250)
	private String description;

	@Column(name = "charterId", length = 20)
	private Charter charter;

	public Bug() {
	}

	public Bug(String summary, Charter charter) {
		this.summary = summary;
		this.charter = charter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getPrecedure() {
		return precedure;
	}

	public void setPrecedure(String precedure) {
		this.precedure = precedure;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Charter getCharter() {
		return charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	@Override
	public String toString() {
		return this.summary;
	}
}
