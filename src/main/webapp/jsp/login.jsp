<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<sx:head />
<title>Welcome to SBTM</title>
<s:head />

</head>
<body>
<div align="center" style="margin-top: 300px;"><s:form
	action="checkuser">
	<s:textfield label="Username" name="name" />
	<s:password label="Password " name="password" />
	<s:fielderror fieldName="msg"></s:fielderror>
	<s:submit value="Login" />
</s:form></div>
<%--<s:textfield label="What is the date?" name="dateNow" />
<s:url id="testUrlId" namespace="/subscriber" action="customField"
	method="delete">
	<s:param name="customFieldDefinition.id" value="dss" />
</s:url>
--%>
<%--
	<s:a errorText="Sorry your request had an error."
		preInvokeJS="confirm('Are you sure you want to delete this item?')"
		href="%{testUrlId}">
		<img src="<s:url value="/images/delete.gif"/>" border="none" />
	</s:a>
 --%>

</body>
</html>
