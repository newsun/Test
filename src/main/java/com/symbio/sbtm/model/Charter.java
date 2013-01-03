package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Charter implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 4, max = 50, message = "Charter name must be between 4-50")
	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "description", length = 255)
	private String description;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Charter_Area", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "areaId"))
	private Set<Area> areas = new HashSet<Area>();

	@Column(name = "starttime")
	private Date starttime;

	@Column(name = "endtime")
	private Date endtime;

	@ManyToOne
	@JoinColumn(name = "testerId")
	private User tester;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "durationId")
	private Duration duration;

	@Column(name = "designAndExectution")
	private int designAndExectution;

	@Column(name = "bugIvestigationAndReporting")
	private int bugIvestigationAndReporting;

	@Column(name = "sesstionSetup")
	private int sesstionSetup;

	@Column(name = "chartervsopp")
	private String chartervsopp;

	@Column(name = "note")
	private String note;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Charter_OS", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "osId"))
	private Set<OS> oss = new HashSet<OS>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Charter_Strategy", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "strategyId"))
	private Set<Strategy> strategies = new HashSet<Strategy>();

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	private Set<Bug> bugs;

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	private Set<Issue> issues;

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	private Set<DataFile> datafiles;

	public Charter() {
	}

	public Charter(String name, Set<Area> areas, User tester) {
		this.name = name;
		this.areas = areas;
		this.tester = tester;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Area> getArea() {
		return areas;
	}

	public void setArea(Set<Area> areas) {
		this.areas = areas;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public User getTester() {
		return tester;
	}

	public void setTester(User tester) {
		this.tester = tester;
	}

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public int getDesignAndExectution() {
		return designAndExectution;
	}

	public void setDesignAndExectution(int designAndExectution) {
		this.designAndExectution = designAndExectution;
	}

	public int getBugIvestigationAndReporting() {
		return bugIvestigationAndReporting;
	}

	public void setBugIvestigationAndReporting(int bugIvestigationAndReporting) {
		this.bugIvestigationAndReporting = bugIvestigationAndReporting;
	}

	public int getSesstionSetup() {
		return sesstionSetup;
	}

	public void setSesstionSetup(int sesstionSetup) {
		this.sesstionSetup = sesstionSetup;
	}

	public String getChartervsopp() {
		return chartervsopp;
	}

	public void setChartervsopp(String chartervsopp) {
		this.chartervsopp = chartervsopp;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<OS> getOss() {
		return oss;
	}

	public void setOss(Set<OS> oss) {
		this.oss = oss;
	}

	public Set<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(Set<Strategy> strategies) {
		this.strategies = strategies;
	}

	public Set<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(Set<Bug> bugs) {
		this.bugs = bugs;
	}

	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

	public Set<DataFile> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(Set<DataFile> datafiles) {
		this.datafiles = datafiles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		// result = prime * result + ((area == null) ? 0 : area.hashCode());
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

		Charter other = (Charter) obj;
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

		// if (area == null) {
		// if (other.area != null)
		// return false;
		// } else if (!area.equals(other.area))
		// return false;

		return true;
	}
}
