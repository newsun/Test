<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Symbio - SBTM</title>
<s:head />
</head>
<body>
	<div>
		<h1>Symbio - Session Based Testing Management</h1>
	</div>
	<div>
		<s:form action="Login">
			<s:textfield name="user.name" label="Username" />
			<s:textfield name="user.password]" label="Password" />
			<s:submit value="Submit" />
		</s:form>
	</div>
</body>
</html>