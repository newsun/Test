package com.symbio.sbtm.ui.action.charter;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.dao.impl.proxy.AreaProxy;
import com.symbio.sbtm.dao.impl.proxy.AreasProxy;
import com.symbio.sbtm.dao.impl.proxy.BugProxy;
import com.symbio.sbtm.dao.impl.proxy.CharterProxy;
import com.symbio.sbtm.dao.impl.proxy.IssueProxy;
import com.symbio.sbtm.dao.impl.proxy.OSProxy;
import com.symbio.sbtm.dao.impl.proxy.OSsProxy;
import com.symbio.sbtm.dao.impl.proxy.StrategiesProxy;
import com.symbio.sbtm.dao.impl.proxy.StrategyProxy;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Area;
import com.symbio.sbtm.model.Bug;
import com.symbio.sbtm.model.Charter;
import com.symbio.sbtm.model.Charter_Area;
import com.symbio.sbtm.model.Duration;
import com.symbio.sbtm.model.Issue;
import com.symbio.sbtm.model.OS;
import com.symbio.sbtm.model.OSs;
import com.symbio.sbtm.model.Strategies;
import com.symbio.sbtm.model.Strategy;
import com.symbio.sbtm.model.User;

public class CharterAction extends ActionSupport {
	private Charter charter;
	private ArrayList<Duration> durationList;

	public Charter getCharter() {
		return charter;
	}

	public void setCharter(Charter charter) {
		this.charter = charter;
	}

	@Override
	public String execute() throws Exception {
		ArrayList<Charter> charterArray = DAOFactory.getCharterDAO()
				.getCharter(charter);
		if (null == charterArray || charterArray.size() == 0)
			return this.ERROR;
		for (int i = 0; i < charterArray.size(); i++) {
			charter = charterArray.get(i);
			CharterProxy chp = new CharterProxy();
			ArrayList<Area> areas = chp.getAreas(charter);
			ArrayList<OS> oss = chp.getOSs(charter);
			ArrayList<Strategy> strategies = chp.getStrategy(charter);
			ArrayList<Bug> bugs = chp.getBugs(charter);
			ArrayList<Issue> issues = chp.getIssues(charter);
			if (areas != null)
				charter.setAreas(areas);
			if (oss != null)
				charter.setOss(oss);
			if (bugs != null)
				charter.setBugs(bugs);
			if (issues != null)
				charter.setIssues(issues);
			if (strategies != null)
				charter.setStrategies(strategies);
		}
		try {
			durationList = DAOFactory.getDurationProxy().getAllDurations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SUCCESS;
	}

	public ArrayList<Duration> getDurationList() {
		return durationList;
	}

	public void setDurationList(ArrayList<Duration> durationList) {
		this.durationList = durationList;
	}
}
