package com.symbio.sbtm.ui.action.build;


import com.opensymphony.xwork2.ActionSupport;
//import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Build;

public class BuildAction extends ActionSupport {

	private Build build;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
//			build = DAOFactory.getBuildDAO().getBuild(build).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.SUCCESS;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

}
