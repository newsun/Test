package com.symbio.sbtm.dao.impl;

import java.util.ArrayList;
import java.util.Map;

import com.symbio.sbtm.dao.ICharter;
import com.symbio.sbtm.dao.impl.proxy.AreaProxy;
import com.symbio.sbtm.dao.impl.proxy.AreasProxy;
import com.symbio.sbtm.dao.impl.proxy.BugProxy;
import com.symbio.sbtm.dao.impl.proxy.BuildProxy;
import com.symbio.sbtm.dao.impl.proxy.DurationProxy;
import com.symbio.sbtm.dao.impl.proxy.IssueProxy;
import com.symbio.sbtm.dao.impl.proxy.OSProxy;
import com.symbio.sbtm.dao.impl.proxy.OSsProxy;
import com.symbio.sbtm.dao.impl.proxy.StrategiesProxy;
import com.symbio.sbtm.dao.impl.proxy.StrategyProxy;
import com.symbio.sbtm.dao.impl.proxy.UserProxy;
import com.symbio.sbtm.dbo.IDBO;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.utils.util;
import com.symbio.sbtm.vo.Area;
import com.symbio.sbtm.vo.Charter_Area;
import com.symbio.sbtm.vo.Bug;
import com.symbio.sbtm.vo.Build;
import com.symbio.sbtm.vo.Charter;
import com.symbio.sbtm.vo.Duration;
import com.symbio.sbtm.vo.Issue;
import com.symbio.sbtm.vo.OS;
import com.symbio.sbtm.vo.OSs;
import com.symbio.sbtm.vo.Project;
import com.symbio.sbtm.vo.Strategies;
import com.symbio.sbtm.vo.Strategy;
import com.symbio.sbtm.vo.User;

public class CharterImpl implements ICharter {
	private IDBO dbo = DAOFactory.getDataBaseOperator();

	public void doCreate(Charter charter) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doDelete(Charter charter) throws Exception {
		// TODO Auto-generated method stub

	}

	public void doUpdate(Charter charter) throws Exception {
		// TODO Auto-generated method stub

	}

	public ArrayList<Charter> getCharter(Charter charter) throws Exception {
		// TODO Auto-generated method stub
		return getAllCharters(Charter.class, charter);
	}

	public ArrayList<Charter> getAllCharters(Build build) throws Exception {
		// TODO Auto-generated method stub
		return getAllCharters(Build.class, build);
	}

	public ArrayList<Charter> getAllCharters(Project project) throws Exception {
		// TODO Auto-generated method stub
		return getAllCharters(Project.class, project);
	}

	public ArrayList<Charter> getAllCharters(Area area) throws Exception {
		// TODO Auto-generated method stub
		return getAllCharters(Area.class, area);
	}

	private ArrayList<Charter> getAllCharters(Class<?> cl, Object obj)
			throws Exception {
		if (null == obj)
			return null;
		String sqlcmd = "select id,name,description,projectId,buildId,starttime,testerId,durationName,"
				+ "designAndExectution,bugIvestigationAndReporting,sesstionSetup,chartervsopp,datafiles,notes"
				+ " from charter";
		String sqlcmd_ = "";
		if (obj instanceof Charter && ((Charter) obj).getId() > 0) {
			sqlcmd_ = " where id=" + ((Charter) obj).getId();
		} else {
			Map<String, String> map = util.getNonEmptyFields(cl, obj);
			sqlcmd_ = util.getAfterSqlCmd(map);
		}
		if (sqlcmd_.length() > 0)
			sqlcmd += sqlcmd_;
		else
			return null;
		ArrayList<Object> list = this.dbo.ExecuteReader(sqlcmd, null);
		return convert2Areas(list);
	}

	private ArrayList<Charter> convert2Areas(ArrayList<Object> list) {
		if (null == list)
			return null;
		ArrayList<Charter> charters = new ArrayList<Charter>();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (obj instanceof Object[]) {
				Object[] ob = (Object[]) obj;
				Charter charter = new Charter();
				charter.setId(Integer.valueOf(ob[0].toString()).intValue());
				charter.setName(ob[1].toString());
				charter.setDescription(ob[2].toString());
				Project project = new Project();
				project.setId(Integer.valueOf(ob[3].toString()).intValue());
				Build build = new Build();
				build.setId(Integer.valueOf(ob[4].toString()).intValue());
				try {
					build = new BuildProxy().getBuild(build).get(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				charter.setBuild(build);
				charter.setStarttime(ob[5].toString());
				User user = new User();
				user.setUserId(ob[6].toString());
				try {
					user = new UserProxy().getUser(user).get(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				charter.setTester(user);
				Duration duration = new Duration();
				duration.setName(ob[7].toString());
				try {
					duration = new DurationProxy().getDuration(duration).get(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				charter.setDuration(duration);
				charter.setDesignAndExectution(Integer
						.valueOf(ob[8].toString()).intValue());
				charter.setBugIvestigationAndReporting(Integer.valueOf(
						ob[9].toString()).intValue());
				charter.setSesstionSetup(Integer.valueOf(ob[10].toString())
						.intValue());
				charter.setChartervsopp(ob[11].toString());
				ArrayList<String> datafiles = new ArrayList<String>();
				String[] df = ob[12].toString().split(",");
				for (String str : df)
					datafiles.add(str);
				charter.setDatafiles(datafiles);
				charter.setNotes(ob[13].toString());
				charters.add(charter);
			}
		}
		return charters;
	}

	public ArrayList<Area> getAreas(Charter charter) {
		ArrayList<Area> areas = new ArrayList<Area>();
		try {
			ArrayList<Charter_Area> areas_ = DAOFactory.getAreasDAO().getAllAreas(
					charter);
			for (int i = 0; i < areas_.size(); i++) {
				Charter_Area ar = areas_.get(i);

				ar = DAOFactory.getAreasDAO().getAreas(ar).get(0);

				Area area = DAOFactory.getAreaDAO().getArea(ar.getArea())
						.get(0);
				areas.add(area);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areas;
	}

	public ArrayList<OS> getOSs(Charter charter) {
		ArrayList<OS> oss = new ArrayList<OS>();
		try {
			ArrayList<OSs> oss_ = new OSsProxy().getOSs(charter);
			for (int i = 0; i < oss_.size(); i++) {
				OS os = oss_.get(i).getOs();
				os = new OSProxy().getOS(os).get(0);
				oss.add(os);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oss;
	}

	public ArrayList<Strategy> getStrategy(Charter charter) {
		ArrayList<Strategy> strategies = new ArrayList<Strategy>();
		try {
			ArrayList<Strategies> strategies_ = new StrategiesProxy()
					.getStrategies(charter);
			for (int i = 0; i < strategies_.size(); i++) {
				Strategy strategy = strategies_.get(i).getStrategy();
				strategy = new StrategyProxy().getStrategies(strategy).get(0);
				strategies.add(strategy);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return strategies;
	}

	public ArrayList<Bug> getBugs(Charter charter) {
		ArrayList<Bug> bugs = new ArrayList<Bug>();
		try {
			bugs = new BugProxy().getAllBugs(charter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bugs;
	}

	public ArrayList<Issue> getIssues(Charter charter) {
		ArrayList<Issue> issues = new ArrayList<Issue>();
		try {
			issues = new IssueProxy().getAllIssues(charter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return issues;
	}

	public static void main(String[] args) {
		Build build = new Build();
		build.setId(1);
		Project project = new Project();
		project.setId(1);
		build.setProject(project);
		try {
			ArrayList<Charter> charters = new CharterImpl()
					.getAllCharters(build);
			System.out.println(charters.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
