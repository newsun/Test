package com.symbio.sbtm.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Bug implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id", length = 20)
	private Long id;

	@Column(name = "summary", length = 255)
	private String summary;

	@Column(name = "precedure", length = 5000)
	private String precedure;

	@Column(name = "description", length = 5000)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "charterId")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		// result = prime * result + ((project == null) ? 0 : project.hashCode());
		// result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Bug other = (Bug) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;


		return true;
	}
}
