<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project: <s:property value="project.name" /></title>
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
	<img src="chart/ListAllFruit4Bar2.action">
	<!-- <img class="scrollLoading" data-url=”chart/ListAllFruit4Bar2.action”
		src="http://www.wutongxia.com/web/example/images/pixel.gif"
		width="180" height="180"
		style="background: url(http://www.wutongxia.com/web/example/images/loading.gif)
		no-repeat center;" /> -->
</body>
</html>