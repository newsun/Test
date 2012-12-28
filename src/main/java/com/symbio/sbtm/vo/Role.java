package com.symbio.sbtm.vo;

import javax.persistence.*;

@Entity
public class Role {
	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
