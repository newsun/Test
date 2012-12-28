package com.symbio.sbtm.model;

import java.util.ArrayList;

public class Charter {
	private int id;
	private String name;
	private String description;
	private Project project;
	private Build build;
	private String starttime;
	private User tester;
	private Duration duration;
	private int designAndExectution;
	private int bugIvestigationAndReporting;
	private int sesstionSetup;
	private String chartervsopp;
	private ArrayList<String> datafiles;
	private String notes;

	private ArrayList<Area> areas;
	private ArrayList<OS> oss;
	private ArrayList<Strategy> strategies;
	private ArrayList<Bug> bugs;
	private ArrayList<Issue> issues;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
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

	public ArrayList<String> getDatafiles() {
		return datafiles;
	}

	public void setDatafiles(ArrayList<String> datafiles) {
		this.datafiles = datafiles;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ArrayList<Area> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<Area> areas) {
		this.areas = areas;
	}

	public ArrayList<OS> getOss() {
		return oss;
	}

	public void setOss(ArrayList<OS> oss) {
		this.oss = oss;
	}

	public ArrayList<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(ArrayList<Strategy> strategies) {
		this.strategies = strategies;
	}

	public ArrayList<Bug> getBugs() {
		return bugs;
	}

	public void setBugs(ArrayList<Bug> bugs) {
		this.bugs = bugs;
	}

	public ArrayList<Issue> getIssues() {
		return issues;
	}

	public void setIssues(ArrayList<Issue> issues) {
		this.issues = issues;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(this.id);
	}

}
