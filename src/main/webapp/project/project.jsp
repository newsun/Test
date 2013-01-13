<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <link href="/style/main.css" rel="stylesheet" type="text/css" />--%>
<title>Project: <s:property value="project.name" />
</title>
<script type="text/javascript">
	$(function() {
		$(".scrollLoading").scrollLoading();
	});
	function showbuggraph() {
<%--$("img").attr("height", "400");
		$("img").attr("width", "700");
		$("img").attr("data-url", "chart/ListAllFruit4Pie2.action");
		$("img").attr("style",
				"background: url(images/loading2.gif) no-repeat center;");
				--%>
	$("img#projectSt").attr("src", "chart/ListAllFruit4Bar2.action");
	}
</script>
</head>
<body>
	<div class="mainbar">
		<div class="entrybar">
			<ul class="vertical tabs">
				<li class="active  first"><a hidefocus="" href="#"
					id="summary-panel-panel" class="browse-tab"><strong>Summary</strong>
				</a></li>
				<li class=" "><a hidefocus="" href="#" id="issues-panel-panel"
					class="browse-tab"><strong>Issues</strong> </a></li>

				<li class=" "><a hidefocus="" href="#"
					id="greenhopper-project-panel-tab-panel" class="browse-tab"><strong>Agile</strong>
				</a></li>

				<li class=" "><a hidefocus="" href="#"
					id="tempo-project-people-panel-panel" class="browse-tab"><strong>People</strong>
				</a></li>

				<li class=" "><a hidefocus="" href="#"
					id="popularissues-panel-panel" class="browse-tab"><strong>Bugs</strong>
				</a></li>

				<li class=" "><a hidefocus="" href="#"
					id="labels-heatmap-panel-panel" class="browse-tab"><strong>Statistics</strong>
				</a></li>
			</ul>
		</div>
		<div class="maincontent">
			<div data-project-key="BAIDU" id="project-tab" class="active-area">
				<h2>Summary</h2>
				<div id="quicklinks">
					<ul class="operations">
						<li class="aui-dd-parent"><a id="reports"
							class="lnk aui-dd-link standard icon-reports"
							title="View available reports" href="#"><span>Reports</span>
						</a>
							<div class="aui-list hidden">
								<ul class="aui-list-section aui-last" id="reports-dropdown">
									<li class="aui-list-item"><a
										title="This report shows the details of a user's current workload, showing the number of unresolved issues assigned and workload remaining on a per project basis."
										href="#" class="aui-list-item-link">User Workload Report</a>
									</li>
									<li class="aui-list-item"><a
										title="This report shows the details of the current workload for the specified version - showing the number of unresolved issues assigned to each user and workload remaining."
										href="#" class="aui-list-item-link">Version Workload
											Report</a>
									</li>
									<li class="aui-list-item"><a
										title="This report shows the time tracking details for a specific project."
										href="#" class="aui-list-item-link">Time Tracking Report</a>
									</li>
									<li class="aui-list-item"><a
										title="This report allows you to display issues grouped by a certain field"
										href="#" class="aui-list-item-link">Single Level Group By
											Report</a>
									</li>
									<li class="aui-list-item"><a
										title="A report showing issues created vs. issues resolved."
										href="#" class="aui-list-item-link">Created vs. Resolved
											Issues Report</a>
									</li>
									<li class="aui-list-item"><a
										title="A report showing the length of time taken to resolve issues for a project or filter."
										href="#" class="aui-list-item-link">Resolution Time Report</a>
									</li>
									<li class="aui-list-item"><a
										title="A report showing the issues for a project or filter as a pie chart."
										href="#" class="aui-list-item-link">Pie Chart Report</a>
									</li>
									<li class="aui-list-item"><a
										title="A report showing the average age of unresolved issues for a project or filter."
										href="#" class="aui-list-item-link">Average Age Report</a>
									</li>
									<li class="aui-list-item"><a
										title="A report showing the number of issues recently created."
										href="#" class="aui-list-item-link">Recently Created
											Issues Report</a></li>
									<li class="aui-list-item"><a
										title="A report showing time since a chosen field for each issue for a project or saved filter."
										href="#" class="aui-list-item-link">Time Since Issues
											Report</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="aui-dd-parent"><a id="filters"
							class="lnk aui-dd-link standard icon-filters"
							title="View preset filters" href="#"><span>Filters</span> </a>
							<div class="aui-list hidden">
								<ul class="aui-list-section aui-last" id="filters-dropdown">
									<li class="aui-list-item"><a href="#" id="filter_all"
										class="aui-list-item-link">All</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_resolvedrecently" class="aui-list-item-link">Resolved
											recently</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_outstanding" class="aui-list-item-link">Outstanding</a>
									</li>
									<li class="aui-list-item"><a href="#"
										id="filter_addedrecently" class="aui-list-item-link">Added
											recently</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_unscheduled" class="aui-list-item-link">Unscheduled</a>
									</li>
									<li class="aui-list-item"><a href="#"
										id="filter_updatedrecently" class="aui-list-item-link">Updated
											recently</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_assignedtome" class="aui-list-item-link">Assigned
											to me</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_mostimportant" class="aui-list-item-link">Most
											important</a></li>
									<li class="aui-list-item"><a href="#"
										id="filter_reportedbyme" class="aui-list-item-link">Reported
											by me</a></li>
								</ul>
							</div></li>
					</ul>
				</div>
				<div class="column" id="primary">
					<div class="content">
						<div id="fragprojectdescription" class="module">
							<div class="mod-header">
								<h3>Description</h3>
							</div>
							<div class="mod-content">
								<ul class="item-details">
									<li>

										<dl>
											<dt>Lead:</dt>
											<dd>
												<a href="#" id="project_summary_junling.liu"
													rel="junling.liu" class="user-hover">Junling Liu</a>
											</dd>
										</dl>
										<dl>
											<dt>Key:</dt>
											<dd id="pd-key">BAIDU</dd>
										</dl></li>
								</ul>
							</div>
						</div>
						<div id="fragdueissues" class="module">
							<div class="mod-header">
								<ul class="ops">
									<li><a title="" href="#" class="icon icon-view"
										id="fragdueissues_more"><span>More</span> </a>
									</li>
								</ul>
								<h3>Issues: Due</h3>
							</div>
							<div class="mod-content">
								<ul class="issues">
									<li class="vevent"><img height="16" width="16"
										title="Task - A task that needs to be done."
										src="/images/task.gif" alt="Task"> <a href="#">BAIDU-1</a>
										<span class="dtstart hidden">2012-10-08T07-30</span> <span
										class="dtend hidden">2012-10-08T19-30</span> <span
										class="description">requirement analysis</span></li>
									<li class="vevent"><img height="16" width="16"
										title="Task - A task that needs to be done."
										src="/images/task.gif" alt="Task"> <a href="#">BAIDU-2</a>
										<span class="dtstart hidden">2012-10-12T07-06</span> <span
										class="dtend hidden">2012-11-01T12-07</span> <span
										class="description">bug fixing</span></li>
									<li class="vevent"><img height="16" width="16"
										title="Task - A task that needs to be done."
										src="/images/task.gif" alt="Task"> <a href="#">BAIDU-3</a>
										<span class="dtstart hidden">2012-10-12T09-00</span> <span
										class="dtend hidden">2012-12-26T04-32</span> <span
										class="description">Frontend work</span></li>
								</ul>
							</div>
						</div>
						<div id="fragcreatedvsresolved" class="module">
							<div class="mod-header">
								<h3>Issues: 30 Day Summary</h3>
							</div>
							<div class="mod-content">
								<img height="250" width="380" border="0" usemap="\#chart-SLm67"
									src="chart/ListAllFruit4Bar2.action"><br> Issues: <b><span
									style="color: #c00;">1</span> </b> created and <b><span
									style="color: #3c3;">0</span> </b> resolved <br>
							</div>
						</div>
					</div>
				</div>
				<div id="fragrecentissues" class="module">
					<div class="mod-header">
						<ul class="ops">
							<li><a title="" href="#" class="icon icon-view"
								id="fragrecentissues_more"><span>More</span> </a>
							</li>
						</ul>
						<h3>Issues: Updated recently</h3>
					</div>
					<div class="mod-content">
						<ul class="issues">
							<li class="vevent"><img height="16" width="16"
								title="Task - A task that needs to be done."
								src="/images/task.gif" alt="Task"> <a
								class="url issue summary" href="#">BAIDU-6</a> <span
								class="dtstart hidden">2012-10-30T04-11</span> <span
								class="date"><abbr title="2013-01-11T05-25" class="dtend">Yesterday
										05:25:54</abbr> </span> <span class="description">Test</span></li>
							<li class="vevent"><img height="16" width="16"
								title="Task - A task that needs to be done."
								src="/images/task.gif" alt="Task"> <a
								class="url issue summary" href="#">BAIDU-10</a> <span
								class="dtstart hidden">2012-12-26T03-32</span> <span
								class="date"><abbr title="2012-12-28T09-22" class="dtend">2012-12-28</abbr>
							</span> <span class="description">Project Management</span></li>
							<li class="vevent"><img height="16" width="16"
								title="Task - A task that needs to be done."
								src="/images/task.gif" alt="Task"> <a
								class="url issue summary" href="#">BAIDU-9</a> <span
								class="dtstart hidden">2012-12-11T10-03</span> <span
								class="date"><abbr title="2012-12-26T05-11" class="dtend">2012-12-26</abbr>
							</span> <span class="description">Virtual machine cloning</span></li>
						</ul>
					</div>
				</div>

				<div class="column" id="secondary">
					<div class="content">
						<div id="fragactivitystream" class="module">
							<div class="mod-header">
								<h3>Activity Stream</h3>
							</div>
							<div class="mod-content">
								<div class="activitystream-container"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>