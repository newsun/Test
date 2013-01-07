<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project: <s:property value="project.name" /></title>
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
	$("img").attr("src", "chart/ListAllFruit4Bar2.action");
	}
</script>
</head>
<body>
			<h1>
				Project Content:
				<s:property value="project.name" />
			</h1>
			<div>Project description,Project description,Project
				description,Project description,Project description,Project
				description,Project description,Project description,Project
				description,Project description,</div>
			<center>
				<h2>Project Statistics</h2>
			</center>
			<table>
				<tbody>
					<tr>
						<td>
							<button onclick="alert('Create New Charter')">Create New
								Area</button>
						</td>
						<td>
							<button onclick="showbuggraph()">Show Bug Statistics</button>
						</td>
					</tr>
				</tbody>
			</table>
			<img alt="" src="" />
			<!-- 
	<img class="scrollLoading" data-url="chart/ListAllFruit4Bar2.action"
		src="images/pixel.gif"
		style="background: url(images/loading2.gif) no-repeat center;"
		height="400" width="700" />
		 -->
</body>
</html>