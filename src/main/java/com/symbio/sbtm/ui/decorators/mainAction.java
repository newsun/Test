package com.symbio.sbtm.ui.decorators;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
//import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Project;

public class mainAction extends ActionSupport {

	private Date now = new Date(System.currentTimeMillis());

	private ArrayList<Project> projectlist;

	public ArrayList<Project> getProjectlist() {
//		if (null == ServletActionContext.getPageContext().getSession()
//				.getAttribute("projectlist")) {
//			try {
//				projectlist = DAOFactory.getProjectDAO().getAllProjects();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				projectlist = new ArrayList<Project>();
//			}
//			ServletActionContext.getPageContext().getSession()
//					.setAttribute("projectlist", projectlist);
//		}
		return this.projectlist;
	}

	@TypeConversion(converter = "com.symbio.sbtm.DateConverter")
	public Date getDateNow() {
		return now;

	}

	public String execute() throws Exception {
		getProjectlist();
		now = new Date(System.currentTimeMillis());
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> arg0) {
	}
}
