<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html lang="en">
<head>
<title><decorator:title default="Struts Starter" /></title>
<link href="<s:url value='/styles/main.css'/>" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript"
	src="<s:url value='/js/jquery-1.7.2.js'/>"></script>

<script type="text/javascript"
	src="<s:url value='/js/jquery.scrollLoading-min.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/cookie.js'/>"></script>
<script type="text/javascript" src="<s:url value='/js/json2.js'/>"></script>
<script type="text/javascript">
	$(".scrollLoading").scrollLoading();
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			console.log(document.readyState);
			var cookiedprojects = getCookie("cookiedprojects");
			if (!cookiedprojects) {
				console.log("Fetch projects from remote");
				jQuery.post('AjaxProjects.action', {}, callbackProject, 'json');
			} else {
				console.log("using cookied projects=" + cookiedprojects);
				callbackProject(JSON.parse(cookiedprojects));
			}
			var cookiedbuilds = getCookie("cookiedbuilds");
			if (cookiedbuilds) {
				console.log("using cookied builds=" + cookiedbuilds);
				callbackBuild(JSON.parse(cookiedbuilds));
			} else {
				return;
			}
			var cookiedAreas = getCookie("cookiedAreas");
			if (cookiedAreas) {
				console.log("using cookiedAreas=" + cookiedAreas);
				callbackArea(JSON.parse(cookiedAreas));
			}
		}
	}
	function callbackProject(projects) {
		if (!getCookie("cookiedprojects")) {
			setCookie("cookiedprojects", JSON.stringify(projects));
			console.log("Set cookiedprojects=" + JSON.stringify(projects));
		}
		$('#arealist').empty();

		$('#buildOption').empty();
		$('#buildOption').append(
				"<option value ='--'>--Select Build--</option>");

		$('#projectOption').empty();
		$('#projectOption').append(
				"<option value ='--'>--Select Project--</option>");

		$.each(projects.projectsMap, function(n, v) {
			$("#projectOption").append(
					"<option value ='"+n+"'>" + v + "</option>");
		});
		var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
		if (cookiedselectedProjectId) {
			$("#projectOption").val(cookiedselectedProjectId);
		}
	}
	function onProjectChanged(projectId) {

		$('#arealist').empty();
		$('#buildOption').empty();
		$('#buildOption').append(
				"<option value ='--'>--Select Build--</option>");

		setCookie("cookiedselectedProjectId", projectId);
		console.log("set cookie: cookiedselectedProjectId=" + projectId);
		deleteCookie("cookiedSelectedBuildId");
		console.log("remove cookie: cookiedSelectedBuildId");
		deleteCookie("cookiedbuilds");
		console.log("remove cookie: cookiedbuilds");
		deleteCookie("cookiedAreas");
		console.log("remove cookie: cookiedAreas");
		if (projectId == "--") {
			window.location = "<s:url value='/index.action'/>";
			return;
		}
		window.location = "<s:url value='/project.action?project.id='/>"
				+ projectId;
		var cookiedbuilds = getCookie("cookiedbuilds");
		if (!cookiedbuilds) {
			console.log("Fetching builds from remote");
			jQuery.post('AjaxBuilds.action', {
				'project.id' : projectId
			}, callbackBuild, 'json');
		} else {
			console.log("using cookied builds=" + cookiedbuilds);
			callbackBuild(JSON.parse(cookiedbuilds));
		}
	}
	function callbackBuild(builds) {
		if (!getCookie("cookiedbuilds")) {
			console.log("set cookiedbuilds=" + JSON.stringify(builds));
			setCookie("cookiedbuilds", JSON.stringify(builds));
		}
		$.each(builds.buildList, function(n, v) {
			$("#buildOption").append(
					"<option value ='"+n+"'>" + v + "</option>");
		});
		var cookiedSelectedBuildId = getCookie("cookiedSelectedBuildId");
		if (cookiedSelectedBuildId) {
			$("#buildOption").val(cookiedSelectedBuildId);
		}
	}
	function onBuildChanged(buildId) {
		$('#arealist').empty();
		setCookie("cookiedSelectedBuildId", buildId);
		console.log("Set cookiedSelectedBuildId=" + buildId);
		deleteCookie("cookiedAreas");
		console.log("Remove cookiedAreas");

		if (buildId == "--") {
			cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
			if (cookiedselectedProjectId)
				window.location = "<s:url value='/build.action?build.id='/>"
						+ buildId;
			return;
		}
		window.location = "<s:url value='/build.action?build.id='/>" + buildId;
		//var cookiedAreas = getCookie("cookiedAreas");
		//if(!cookiedAreas){
		console.log("Fetching area list from remote");
		jQuery.post('AjaxAreas.action', {
			'build.id' : buildId
		}, callbackArea, 'json');
		//}else{
		//	console.log("using cookiedAreas="+cookiedAreas);
		//		callbackArea(JSON.parse(cookiedAreas));
		//}
	}
	function callbackArea(areas) {
		if (!getCookie("cookiedAreas")) {
			console.log("set cookiedAreas=" + JSON.stringify(areas));
			setCookie("cookiedAreas", JSON.stringify(areas));
		}
		$.each(areas.areaMap, function(id, name) {
			var link = "<s:url value='/charter.action?charter.id='/>";
			$("ul#arealist").append(
					"<li><a href='"+link+id+"'>" + name + "</a></li>");
			$("ul#arealist li:last").click(function() {
				fetchCharter(id, name);
			});
		});
	}
	function fetchCharter(charterId, charterName) {
		console.log(charterId + " " + charterName);
	}
</script>
<decorator:head />
</head>

<body id="page-home">
	<div id="page">
		<div id="header" class="clearfix">
			Symbio - SBTM
			<hr />
		</div>
		<div id="sub">
			<h3>Sub Content</h3>

		</div>

		<div id="content" class="clearfix">
			<div id="main">
				<decorator:body />
				<hr />
			</div>

			<div id="local">
				<div id="extra2">&nbsp;</div>
				<div id="extra2">&nbsp;</div>
				<s:url action="index" var="createProjectLink">
					<s:param name="selectedProject">${selectedProject.id}</s:param>
				</s:url>
				<a href="${createProjectLink}">Create New Project</a>
				<table>
					<tbody>
						<tr>
							<td><select id="projectOption"
								onchange="onProjectChanged(this.value);"></select></td>
						</tr>
						<tr>
							<td><select id="buildOption"
								onchange="onBuildChanged(this.value);"></select></td>
						</tr>
						<tr>
							<td>
								<ul id="arealist">
								</ul>
							</td>
						</tr>
					</tbody>
				</table>
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