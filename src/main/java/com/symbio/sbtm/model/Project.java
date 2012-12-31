package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

//@Entity
public class Project implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private int id;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "description", length = 250)
	private String description;
	
	private Date date;
	private User creator;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(id);
	}

}
