package com.symbio.sbtm.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "Charter_Area", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "areaId"))
	private List<Area> areas;

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
	private String designAndExectution;

	@Column(name = "bugIvestigationAndReporting")
	private String bugIvestigationAndReporting;

	@Column(name = "sesstionSetup")
	private String sesstionSetup;

	@Column(name = "chartervsopp")
	private String chartervsopp;

	@Column(name = "note")
	private String note;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "Charter_OS", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "osId"))
	private List<OS> oss;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "Charter_Strategy", joinColumns = @JoinColumn(name = "charterId"), inverseJoinColumns = @JoinColumn(name = "strategyId"))
	private List<Strategy> strategies;

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Bug> bugs;

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Issue> issues;

	@OneToMany(mappedBy = "charter", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<DataFile> datafiles;

	public Charter() {
	}

	public Charter(String name, List<Area> areas, User tester) {
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

	public String getDesignAndExectution() {
		return designAndExectution;
	}

	public void setDesignAndExectution(String designAndExectution) {
		this.designAndExectution = designAndExectution;
	}

	public String getBugIvestigationAndReporting() {
		return bugIvestigationAndReporting;
	}

	public void setBugIvestigationAndReporting(String bugIvestigationAndReporting) {
		this.bugIvestigationAndReporting = bugIvestigationAndReporting;
	}

	public String getSesstionSetup() {
		return sesstionSetup;
	}

	public void setSesstionSetup(String sesstionSetup) {
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


	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<OS> getOss() {
		return oss;
	}

	public void setOss(List<OS> oss) {
		this.oss = oss;
	}

	public List<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(List<Strategy> strategies) {
		this.strategies = strategies;
	}

	public List<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

	public List<DataFile> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(List<DataFile> datafiles) {
		this.datafiles = datafiles;
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
