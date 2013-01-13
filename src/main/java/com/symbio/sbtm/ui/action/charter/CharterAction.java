package com.symbio.sbtm.ui.action.charter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.model.Area;
import com.symbio.sbtm.model.Bug;
import com.symbio.sbtm.model.Build;
import com.symbio.sbtm.model.Charter;
import com.symbio.sbtm.model.DataFile;
import com.symbio.sbtm.model.Duration;
import com.symbio.sbtm.model.Issue;
import com.symbio.sbtm.model.OS;
import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.Strategy;
import com.symbio.sbtm.model.User;
import com.symbio.sbtm.model.service.AreaService;
import com.symbio.sbtm.model.service.CharterService;
import com.symbio.sbtm.model.service.DurationService;

public class CharterAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Charter charter;
	private List<Duration> durationList;
	private List<String> areaList;
	private Project project;
	private Build build;
	private List<Area> areas;
	private List<Bug> bugList;
	private List<Issue> issueList;
	private List<DataFile> fileList;

	@Autowired
	private CharterService charterService;
	@Autowired
	private DurationService durationService;

	@Override
	public String execute() throws Exception {
		if (durationList == null)
			durationList = durationService.getAllDurations();
		if (charter != null)
			charter = charterService.getCharter(charter.getId());
		else
			return INPUT;
		areas = charter.getAreas();
		// if (null == charterArray || charterArray.size() == 0)
		// return this.ERROR;
		// for (int i = 0; i < charterArray.size(); i++) {
		// charter = charterArray.get(i);
		// CharterProxy chp = new CharterProxy();
		// ArrayList<Area> areas = chp.getAreas(charter);
		// ArrayList<OS> oss = chp.getOSs(charter);
		// ArrayList<Strategy> strategies = chp.getStrategy(charter);
		// ArrayList<Bug> bugs = chp.getBugs(charter);
		// ArrayList<Issue> issues = chp.getIssues(charter);
		// if (areas != null)
		// charter.setAreas(areas);
		// if (oss != null)
		// charter.setOss(oss);
		// if (bugs != null)
		// charter.setBugs(bugs);
		// if (issues != null)
		// charter.setIssues(issues);
		// if (strategies != null)
		// charter.setStrategies(strategies);
		// }
		// try {
		// durationList = DAOFactory.getDurationProxy().getAllDurations();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return SUCCESS;
	}

	public String update() {
		if (charter == null) {
			return INPUT;
		}
		if (charter.getDuration() != null) {
			Duration duration = durationService.getDurationByName(charter
					.getDuration().getName());
			charter.setDuration(duration);
		}
		if (areas == null) {
			Charter c2 = charterService.getCharter(charter.getId());
			areas = c2.getAreas();
		}
		charter.setAreas(areas);
		charterService.update(charter);
		return SUCCESS;
	}

	public Charter getCharter() {
		return this.charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	public List<Duration> getDurationList() {
		return durationList;
	}

	public List<String> getAreaList() {
		areaList = new ArrayList<String>();
		for (Iterator<Area> it = charter.getAreas().iterator(); it.hasNext();)
			areaList.add(it.next().toString());
		return areaList;
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

	public void setDurationList(List<Duration> durationList) {
		this.durationList = durationList;
	}

	public void setAreaList(List<String> areaList) {
		this.areaList = areaList;
	}

	public List<Area> getArea() {
		return areas;
	}

	public void setArea(List<Area> area) {
		this.areas = area;
	}

	public List<Bug> getBugList() {
		return bugList;
	}

	public void setBugList(List<Bug> bugList) {
		this.bugList = bugList;
	}

	public List<Issue> getIssueList() {
		return issueList;
	}

	public void setIssueList(List<Issue> issueList) {
		this.issueList = issueList;
	}

	public List<DataFile> getFileList() {
		return fileList;
	}

	public void setFileList(List<DataFile> fileList) {
		this.fileList = fileList;
	}

	@Override
	public void validate() {
	}
}
