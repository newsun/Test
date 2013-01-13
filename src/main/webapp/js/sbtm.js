$(function() {
	$("#submit")
			.click(
					function() {
						data = {
							"charter.id" : $("charter_id").val(),
							"charter.description" : $("#charter_description")
									.val(),
							"charter.duration.name" : $(
									"#charter_duration_name").val(),
							"charter.designAndExectution" : $(
									"#charter_designAndExectution").val(),
							"charter.bugIvestigationAndReporting" : $(
									"#charter_bugIvestigationAndReporting")
									.val(),
							"charter.sesstionSetup" : $(
									"#charter_sesstionSetup").val(),
							"charter.chartervsopp" : $("#charter_chartervsopp")
									.val(),
							"charter.note" : $("#charter_note").val()
						};
						$.post("updateCharter", data,callback_updatecharter);
					});
});
function callback_updatecharter(resp){
	console.log(resp);
	location="/project/project.jsp";
}