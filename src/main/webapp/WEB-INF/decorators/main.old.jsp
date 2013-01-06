<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<html lang="en">
<head>
<title><decorator:title default="Struts Starter" /></title>
<link href="styles/main.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src='<s:url value="js/jquery-1.7.2.js"/>'></script>
<script type="text/javascript" src='<s:url value="js/cookie.js"/>'></script>
<script type="text/javascript" src='<s:url value="js/json2.js"/>'></script>
<script type="text/javascript" src='<s:url value="js/navigator.js"/>'></script>
<script type="text/javascript" src='<s:url value="js/images.js"/>'></script>
<script type="text/javascript"
	src='<s:url value="js/jquery.scrollLoading.js"/>'></script>
<script type="text/javascript">
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			onload();
		}
	}
</script>
<decorator:head />
</head>

<body id="page-home">
<div id="page">
<div id="header" class="clearfix">
<h1 style="color: white">Symbio - SBTM</h1>
<hr />
</div>
<div id="sub">
<h3>Sub Content</h3>

</div>

<div id="content" class="clearfix">
<div id="main"><decorator:body />
<hr />
</div>

<div id="local">
<div id="extra2">&nbsp;</div>
<div id="extra2">&nbsp;</div>
<s:url action="index" var="createProjectLink">
	<s:param name="selectedProject">${selectedProject.id}</s:param>
</s:url> <a href="${createProjectLink}">Create New Project</a>
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
	<li class="last"><a href="jsp/Logout.jsp">Logout</a></li>
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