<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Build Content: <s:property value="build.name" />
</title>
<script type="text/javascript">
	$(function() {
		$(".scrollLoading").scrollLoading();
	});
	function showbuggraph() {

		//$("img").attr("height", "400");
		//$("img").attr("width", "700");
		//$("img").attr("data-url", "chart/ListAllFruit4Pie2.action");
		//$("img").attr("style",
		//"background: url(images/loading2.gif) no-repeat center;");
		//$("img").attr("class", "scrollLoading");
		$("img#bugSt").attr("src", "chart/ListAllFruit4Pie2.action");
	}
</script>
</head>
<body>
	<h1>Build Content: ${build.name}</h1>
	<div>Build descriptionBuild descriptionBuild descriptionBuild
		descriptionBuild descriptionBuild descriptionBuild descriptionBuild
		descriptionBuild description</div>
	<center>
		<h2>Build Statistics</h2>
	</center>
	<br>
	<!-- 
	<img class="scrollLoading" data-url="chart/ListAllFruit4Pie2.action"
		src="images/pixel.gif" width="700" height="400"
		style="background: url(images/loading2.gif) no-repeat center;" />
		 -->
	<table>
		<tbody>
			<tr>
				<td>
					<button onclick="alert('Create New Charter')">Create New
						Charter</button>
				</td>
				<td>
					<button onclick="showbuggraph()">Show Bug Statistics</button>
				</td>
			</tr>
		</tbody>
	</table>
	<img id="bugSt" />
</body>
</html>