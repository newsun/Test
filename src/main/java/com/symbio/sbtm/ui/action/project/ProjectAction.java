package com.symbio.sbtm.ui.action.project;


import com.opensymphony.xwork2.ActionSupport;
import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.vo.Project;

public class ProjectAction extends ActionSupport {
	private Project project;

	public Project getProject() {
		return this.project;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			this.project = DAOFactory.getProjectDAO().getProject(project)
					.get(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.SUCCESS;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
