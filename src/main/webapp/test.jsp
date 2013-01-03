<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<html lang="en">
<head>
<sx:head />
<title>Welcome to SBTM</title>
<s:head />

</head>
<body>
<p>1 url tag<br>
<a href="<s:url action='hello' var="tests"/>">Hello World</a> <%-- <sx:textarea></sx:textarea>--%>
</p>
2 url tag with parameter
<br>
<s:url action="hello" var="registerInputLink">
	<s:param name="user.name">Bruce Phillips</s:param>
</s:url>
<a href="${registerInputLink}">Please register</a>
for our prize drawing.
<p></p>
3 form and field validation
<br>
<s:form action="hello">
	<s:textfield name="user.name" label="Your name" />
	<s:submit value="Submit" />
</s:form>
<p></p>
4 resource property
<br>
<s:textfield key="user.description" />
<p></p>
5 package level property
<p></p>
6 global level property in text tag
<h1><s:text name="struts.i18n.encoding" /></h1>
<p></p>
5 select tag
<br>
<s:select key="user.name" list="listExample" />
<p></p>
6 radio tag
<br>
<s:radio key="user.name" list="listExample" />
<p></p>
7 checkbox tag
<br>
<s:checkbox key="user.name" />
<p></p>
8 checkboxlist tag
<br>
<s:checkboxlist key="user.name" list="listExample" />
<p></p>
9 xml validation
<br>
<s:form action="hello" method="post" theme="xhtml">>
			<s:textfield name="user.password"></s:textfield>
	<sx:submit value="check" validate="true" />
</s:form>
<hr />
<p></p>
<a
	href="http://www.cnblogs.com/firstdream/archive/2012/03/14/2395690.html">Select</a>
<br>
example 1
<s:select list="{'aa','bb','cc'}" theme="simple" headerKey="00"
	headerValue="00"></s:select>
<br>
Exammple 2.
<s:select list="#{1:'aa',2:'bb',3:'cc'}" label="abc" listKey="key"
	listValue="value" headerKey="0" headerValue="aabb" />
<br>
Example 3
<%@page import="java.util.HashMap" import="java.util.LinkedHashMap"%>
<%
	HashMap map = new LinkedHashMap();
	map.put(1, "aaa");
	map.put(2, "bbb");
	map.put(3, "ccc");
	request.setAttribute("map", map);
	request.setAttribute("aa", "2");
%>
<s:select list="#request.map" label="abc" listKey="key"
	listValue="value" value="#request.aa" headerKey="0" headerValue="aabb"></s:select>
<p></p>
sx:autocompleter
<br>
<sx:autocompleter name="test" list="{'SH','HN','GD'}"
	autoComplete="true" />
<sx:datetimepicker name="order.date" label="Order Date"
	displayFormat="yyyy-MM-dd" value="%{'2006-01-01'}" />
<p></p>
<p>Iterator</p>
<s:iterator value="listExample" id="user" status="st">
	<s:textfield name="name" onchange="modify('%{#st.index}')"
		id="nmUser_%{#st.index}" />
</s:iterator>

<p>tree</p>
<sx:tree id="struts" label="struts" showRootGrid="true" showGrid="true">
	<sx:treenode label="struts" id="1">
		<sx:treenode label="c1" id="11" />
		<sx:treenode label="c2" id="12" />
		<sx:treenode label="c3" id="13" />
	</sx:treenode>
	<sx:treenode label="spring" id="2">
		<sx:treenode label="c1" id="11" />
		<sx:treenode label="c2" id="12" />
		<sx:treenode label="c3" id="13" />
	</sx:treenode>
	<sx:treenode label="hibernate" id="3">
		<sx:treenode label="c1" id="11" />
		<sx:treenode label="c2" id="12" />
		<sx:treenode label="c3" id="13" />
	</sx:treenode>
</sx:tree>
<p></p>
<a href="http://yueguc.iteye.com/blog/314303">Tab</a>
<br>
<sx:tabbedpanel id="tabContainer">
	<sx:div label="Tab 1" id="tab1">   
       			Local Tab 1  
  			</sx:div>
	<sx:div label="Tab 2" id="tab2">   
       			Local Tab 2  
   			</sx:div>
</sx:tabbedpanel>
<p></p>
Build
<br>
<s:div id="targetDiv">
	<input type="button" value="test" id="bin" />
	<s:text name="dfsdfsdfs"></s:text>
	<sx:bind events="onClick" targets="targetDiv" showLoadingText="true"
		indicator="%{getText('loadingImage')}" formId="bin"
		loadingText="Loading...." href="hello.action" />
</s:div>
</body>
</html>