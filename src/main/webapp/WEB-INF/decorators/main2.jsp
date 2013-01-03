<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title><decorator:title default="Struts Starter" /></title>
<link href="<s:url value='/styles/main.css'/>" rel="stylesheet"
	type="text/css" media="all" />
<link href="<s:url value='/struts/niftycorners/niftyCorners.css'/>"
	rel="stylesheet" type="text/css" />
<link href="<s:url value='/struts/niftycorners/niftyPrint.css'/>"
	rel="stylesheet" type="text/css" media="print" />
<script language="JavaScript" type="text/javascript"
	src="<s:url value='/struts/niftycorners/nifty.js'/>"></script>
<script language="JavaScript" type="text/javascript">
	window.onload = function() {
		if (!NiftyCheck()) {
			return;
		}
		// perform niftycorners rounding
		// eg.
		// Rounded("blockquote","tr bl","#ECF1F9","#CDFFAA","smooth border #88D84F");
	}
</script>
<script type="text/javascript" src="/SBTMWeb/dwr/util.js"></script>
<script type="text/javascript" src="/SBTMWeb/dwr/engine.js"></script>
<script type="text/javascript" src="/SBTMWeb/dwr/interface/service.js"></script>
<script type="text/javascript" src="/SBTMWeb/js/cookie.js"></script>
<script type="text/javascript">
document.onreadystatechange=function(){
	if(document.readyState == "complete"){
		console.log(document.readyState);
		//service.getProjectList(genprojectList);
	}
}
function genprojectList(projectList){
	projectListPub=projectList;
	DWRUtil.removeAllOptions("projectId");
	var arr_=[{'name':'--Select Project--','id':'--'}];
	console.log("projectList.length="+projectList.length);
	DWRUtil.addOptions('projectId',arr_,"id","name");
	DWRUtil.addOptions('projectId',projectList,"id","name");
	if (null!=getCookie("selectedProjectId")&&null!=getCookie("selectedProjectName")){
		console.log("selectedProjectId: "+getCookie("selectedProjectId"));
		console.log("selectedProjectName: "+getCookie("selectedProjectName"));
		DWRUtil.setValues('projectId',[getCookie("selectedProjectId"),getCookie("selectedProjectName")]);
	}else{
		console.log("Not set");
	}
}
function genAreaList(projectId){
	var project = service.getArea
	var list=document.getElementById("arealist");
	if(null==list) return;
	var navhtml="";

	for( var i=0;i<areaList.length;i++){
		console.log(navhtml);
		navhtml=navhtml+"<li><a href='charter.action?charterid="+areaList[i].id+"'>"+areaList[i].name+"</a></li>";
	}
	list.innerHTML=navhtml
}
function changeProject(){
	SelectedProjectId = DWRUtil.getValue("projectId");
	SelectedProjectName = DWRUtil.getText("projectId");
	if (null!=getCookie("selectedProjectId")){
		deleteCookie("selectedProjectId")
	}
	if(null!=getCookie("selectedProjectName")){
		deleteCookie("selectedProjectName");
	}
	setCookie("selectedProjectId",SelectedProjectId);
	setCookie("SelectedProjectName",SelectedProjectName);
	window.location.href="/SBTMWeb/project.action?projectId="+SelectedProjectId;		
}
function genArea(area){
	console.log("id: "+area.id);
	console.log("name: "+area.name);
}
</script>
<decorator:head />
</head>
<body id="page-home">
<div id="page">
<div id="header" class="clearfix">Symbio - SBTM
<hr />
</div>

<div id="content" class="clearfix">
<div id="main">
<div>&nbsp;</div>
<div>&nbsp;</div>
<div>&nbsp;</div>
<decorator:body />
<hr />
</div>

<div id="sub">
<h3>Sub Content</h3>
</div>

<div id="local">
<div id="extra2">&nbsp;</div>
<div id="extra2">&nbsp;</div>

<div>&nbsp;</div>
<%--<select name="projects" id="projectId" onchange="changeProject()"></select>
--%> <%--
 <s:select
	list="projectlist" headerKey="-"
	headerValue="--Select Poject--" listKey="id" listValue="name"
	name="selectedProject" />
 --%>
<div>&nbsp;</div>
<h3>Areas</h3>
<ul id="arealist">
	<%--
	<li><a href="#">Content page 1</a></li>
	<li><a href="#">Content page 2</a></li>
	<li><a href="#">Content page 3</a></li>
	<li><a href="#">Content page 4</a></li>
	<li><a href="#">Content page 5</a></li>
	<li><a href="#">Content page 6</a></li>
	 --%>
</ul>
</div>


<div id="nav">
<div class="wrapper">
<h3></h3>
<ul class="clearfix">
	<li><a href="#">Project</a></li>
	<li><a href="#">Configuration</a></li>
	<li class="last"><a href="/SBTMWeb/jsp/logout.jsp">Logout</a></li>
</ul>
</div>
<hr />
</div>
</div>

<div id="footer" class="clearfix">Footer</div>

</div>

<div id="extra1">&nbsp;</div>
<div id="extra2">&nbsp;</div>
</body>
</html>

