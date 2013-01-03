function onload() {
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
function callbackProject(projects) {
	if (!getCookie("cookiedprojects")) {
		setCookie("cookiedprojects", JSON.stringify(projects));
		console.log("Set cookiedprojects=" + JSON.stringify(projects));
	}
	$('#arealist').empty();

	$('#buildOption').empty();
	$('#buildOption').append("<option value ='--'>--Select Build--</option>");

	$('#projectOption').empty();
	$('#projectOption').append(
			"<option value ='--'>--Select Project--</option>");

	$.each(projects.projectsMap, function(n, v) {
		$("#projectOption").append(
				"<option value ='" + n + "'>" + v + "</option>");
	});
	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		$("#projectOption").val(cookiedselectedProjectId);
	}
}
function onProjectChanged(projectId) {

	$('#arealist').empty();
	$('#buildOption').empty();
	$('#buildOption').append("<option value ='--'>--Select Build--</option>");

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
	console.log("Fetching area list from remote");
	jQuery.post('AjaxAreas.action', {
		'project.id' : projectId
	}, callbackArea, 'json');
}
function callbackBuild(builds) {
	if (!getCookie("cookiedbuilds")) {
		console.log("set cookiedbuilds=" + JSON.stringify(builds));
		setCookie("cookiedbuilds", JSON.stringify(builds));
	}
	$.each(builds.buildList, function(n, v) {
		$("#buildOption").append(
				"<option value ='" + n + "'>" + v + "</option>");
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
			window.location = "<s:url value='/project.action?project.id='/>"
					+ cookiedselectedProjectId;
		return;
	}
	window.location = "<s:url value='/build.action?build.id='/>" + buildId;
	// var cookiedAreas = getCookie("cookiedAreas");
	// if(!cookiedAreas){
	console.log("Fetching area list from remote");
	jQuery.post('AjaxAreas.action', {
		'build.id' : buildId
	}, callbackArea, 'json');
	// }else{
	// console.log("using cookiedAreas="+cookiedAreas);
	// callbackArea(JSON.parse(cookiedAreas));
	// }
}
function callbackArea(areas) {
	if (!getCookie("cookiedAreas")) {
		console.log("set cookiedAreas=" + JSON.stringify(areas));
		setCookie("cookiedAreas", JSON.stringify(areas));
	}
	$.each(areas.areaMap, function(id, name) {
		var link = "<s:url value='/charter.action?charter.id='/>";
		$("ul#arealist").append(
				"<li><a href='" + link + id + "'>" + name + "</a></li>");
		$("ul#arealist li:last").click(function() {
			fetchCharter(id, name);
		});
	});
}
function fetchCharter(charterId, charterName) {
	console.log(charterId + " " + charterName);
}