<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Build Content: <s:property value="build.name" />
</title>
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
	<img src="chart/ListAllFruit4Pie2.action">
</body>
</html>