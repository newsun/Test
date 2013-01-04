package com.symbio.sbtm.ui.decorators;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.conversion.annotations.TypeConversion;
//import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.model.Project;
import com.symbio.sbtm.model.service.ProjectService;

public class mainAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date now = new Date(System.currentTimeMillis());

	@Autowired
	private transient ProjectService projectService;

	private List<Project> projectlist;

	public List<Project> getProjectlist() {
		if (null == ServletActionContext.getPageContext().getSession()
				.getAttribute("projectlist")) {
			projectlist = projectService.getAllProjects();
			ServletActionContext.getPageContext().getSession()
					.setAttribute("projectlist", projectlist);
		}
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
