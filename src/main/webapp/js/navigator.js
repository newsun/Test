function onload() {
	var cookiedprojects = getCookie("cookiedprojects");
	if (cookiedprojects) {
		console.log("using cookied projects=" + cookiedprojects);
		onload_project(JSON.parse(cookiedprojects));
	} else {
		console.log("Fetch projects from remote");
		jQuery.post('AjaxProjects', {}, onload_project, 'json');
	}
	var cookiedbuilds = getCookie("cookiedbuilds");
	if (cookiedbuilds) {
		console.log("using cookied builds=" + cookiedbuilds);
		onload_build(JSON.parse(cookiedbuilds));
	} else {
		$('#buildOption').append(
				"<option value ='--'>--Select Build--</option>");
		/*
		 * When onload, if no builds list cookied, the area list should not be
		 * empty, but for project's area list锛�so will not return;
		 */
		// return;
	}
	var cookiedAreas = getCookie("cookiedAreas");
	if (cookiedAreas) {
		console.log("using cookiedAreas=" + cookiedAreas);
		onload_Area(JSON.parse(cookiedAreas));
	}
}
function onload_project(projects) {
	$('#projectOption').empty();

	if (!getCookie("cookiedprojects")) {
		setCookie("cookiedprojects", JSON.stringify(projects));
		console.log("Set cookiedprojects=" + JSON.stringify(projects));
	}
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
function onload_build(builds) {
	$('#buildOption').empty();
	if (!getCookie("cookiedbuilds")) {
		console.log("set cookiedbuilds=" + JSON.stringify(builds));
		setCookie("cookiedbuilds", JSON.stringify(builds));
	}
	$('#buildOption').append("<option value ='--'>--Select Build--</option>");
	$.each(builds.buildList, function(n, v) {
		$("#buildOption").append(
				"<option value ='" + n + "'>" + v + "</option>");
	});
	var cookiedSelectedBuildId = getCookie("cookiedSelectedBuildId");
	if (cookiedSelectedBuildId) {
		$("#buildOption").val(cookiedSelectedBuildId);
	}
}
function onload_Area(areas) {
	$('#arealist').empty();
	if (!getCookie("cookiedAreas")) {
		console.log("set cookiedAreas=" + JSON.stringify(areas));
		setCookie("cookiedAreas", JSON.stringify(areas));
	}
	var pb = "";
	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		pb += "&project.id=" + cookiedselectedProjectId;
	}
	var cookiedSelectedBuildId = getCookie("cookiedSelectedBuildId");
	if (cookiedSelectedBuildId) {
		pb += "&build.id=" + cookiedSelectedBuildId;
	}
	$.each(areas.areaMap, function(id, name) {
		$("ul#arealist").append(
				"<li><a href='Charter?charter.id=" + id + pb + "'>"
						+ name + "</a></li>");
		// $("ul#arealist").append("<li><a href='#'>" + name + "</a></li>");
			// $("ul#arealist li:last").click(function() {
			// fetchCharter(id, name);
			// });
		});
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
		console.log("page jumped");
		window.location = "/project/index.html";
		return;
	}
	console.log("Fetching builds from remote");
	jQuery.post('AjaxBuilds', {
		'project.id' : projectId
	}, onProjectChanged_callback_build, 'json');

}

function onProjectChanged_callback_build(builds) {

	// if (!getCookie("cookiedbuilds")) {
	console.log("set cookiedbuilds=" + JSON.stringify(builds));
	setCookie("cookiedbuilds", JSON.stringify(builds));
	// }
	$.each(builds.buildList, function(n, v) {
		$("#buildOption").append(
				"<option value ='" + n + "'>" + v + "</option>");
	});

	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		console.log("Fetching area list from remote");
		jQuery.post('AjaxAreas', {
			'project.id' : cookiedselectedProjectId
		}, onProjectChanged_callback_Area, 'json');
	} else
		alert("Emypt cookiedselectedProjectId when project id changed and fetch area list");
}

function onProjectChanged_callback_Area(areas) {
	// if (!getCookie("cookiedAreas")) {
	console.log("set cookiedAreas=" + JSON.stringify(areas));
	setCookie("cookiedAreas", JSON.stringify(areas));
	// }

	var pb = "";
	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		pb += "&project.id=" + cookiedselectedProjectId;
	} else {
		alert("cookiedselectedProjectId should not be empty when project changed and set the areas;");
		return;
	}

	$.each(areas.areaMap, function(id, name) {
		$("ul#arealist").append(
				"<li><a href='Charter?charter.id=" + id + pb + "'>"
						+ name + "</a></li>");
	});

	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		console.log("page jumped");
		window.location = "Project?project.id="
				+ cookiedselectedProjectId;
	} else
		alert("Emypt cookiedselectedProjectId when project id changed and set area list");
}

function onBuildChanged(buildId) {
	$('#arealist').empty();
	setCookie("cookiedSelectedBuildId", buildId);
	console.log("Set cookiedSelectedBuildId=" + buildId);
	deleteCookie("cookiedAreas");
	console.log("Remove cookiedAreas");

	if (buildId == "--") {
		var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
		if (cookiedselectedProjectId) {
			console.log("Fetching area list from remote for project");
			jQuery.post('AjaxAreas', {
				'project.id' : cookiedselectedProjectId
			}, onBuildChangedtoEmpty_callback, 'json');
		} else
			alert("empty cookiedselectedProjectId when build id changed to empty!");
		return;
	}

	console.log("Fetching area list from remote for build");
	jQuery.post('AjaxAreas', {
		'build.id' : buildId
	}, onBuildChanged_callback, 'json');
}
function onBuildChanged_callback(areas) {
	console.log("set cookiedAreas=" + JSON.stringify(areas));
	setCookie("cookiedAreas", JSON.stringify(areas));

	var pb = "";
	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		pb += "&project.id=" + cookiedselectedProjectId;
	} else {
		alert("cookiedselectedProjectId should not be empty when build changed and set the area");
		return;
	}
	var cookiedSelectedBuildId = getCookie("cookiedSelectedBuildId");
	if (cookiedSelectedBuildId) {
		pb += "&build.id=" + cookiedSelectedBuildId;
	} else {
		alert("cookiedSelectedBuildId should not be empty when build changed and set the area");
		return;
	}

	$.each(areas.areaMap, function(id, name) {
		$("ul#arealist").append(
				"<li><a href='Charter?charter.id=" + id + pb + "'>"
						+ name + "</a></li>");
		// $("ul#arealist li:last").click(function() {
			// fetchCharter(id, name);
			// });
		});
	var cookiedSelectedBuildId = getCookie("cookiedSelectedBuildId");
	if (cookiedSelectedBuildId) {
		console.log("page jumped");
		window.location = "Build?build.id=" + cookiedSelectedBuildId;
	} else
		alert("Emypt cookiedSelectedBuildId when was changed build to empty")
}
function onBuildChangedtoEmpty_callback(areas) {
	// if (!getCookie("cookiedAreas")) {
	console.log("set cookiedAreas=" + JSON.stringify(areas));
	setCookie("cookiedAreas", JSON.stringify(areas));
	// }

	$.each(areas.areaMap, function(id, name) {
		$("ul#arealist").append(
				"<li><a href='Charter?charter.id=" + id + "'>" + name
						+ "</a></li>");
		// $("ul#arealist li:last").click(function() {
			// fetchCharter(id, name);
			// });
		});

	var cookiedselectedProjectId = getCookie("cookiedselectedProjectId");
	if (cookiedselectedProjectId) {
		console.log("page jumped");
		window.location = "Project?project.id="
				+ cookiedselectedProjectId;
	} else
		alert("Emypt cookiedselectedProjectId when was changed build to empty");
}
function fetchCharter(id, name) {
	alert("charter id=" + id + " " + name);
	$.get("Charter?charter.id=" + id, function(result) {
		$("#main").html(result);
	});
}