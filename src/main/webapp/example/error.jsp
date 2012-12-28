<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Error</title>
</head>

<body>
	<h4>The application has malfunctioned.</h4>
	<p>Please contact technical support with the following information:</p>

	<!-- the exception and exceptionStack bean properties
		were created by Struts2's Exception Intercepter  -->
	<h4>Exception Name:</h4>
	<p>
		<s:property value="exception" />
	</p>
	<h4>Exception Details:</h4>
	<p>
		<s:property value="exceptionStack" />
	</p>
	<p>
		<a href="hello.action">Return to the home page.</a>
	</p>
</body>

</html>
