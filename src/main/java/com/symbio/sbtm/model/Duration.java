package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Duration implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 4, max = 50, message = "Duration name must be between 4-50")
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "timespan", nullable = false)
	private String timespan;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "duration", fetch = FetchType.LAZY)
	private Set<Charter> charters = new HashSet<Charter>();

	public Duration() {
	}

	public Duration(String name, String timespan) {
		this.name = name;
		this.timespan = timespan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTimespan() {
		return timespan;
	}

	public void setTimespan(String timespan) {
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

	public Set<Charter> getCharters() {
		return charters;
	}

	public void setCharters(Set<Charter> charters) {
		this.charters = charters;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Duration other = (Duration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;

		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}
}
