<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>

<html lang="en">
<head>
<s:head />
<sx:head />
<title>Welcome to SBTM</title>
</head>
<body>

	<h1>1 url tag</h1>
	<a href="<s:url action='hello' var="tests"/>">Hello World</a>
	<%-- <sx:textarea></sx:textarea>--%>

	<h1>2 url tag with parameter</h1>
	<s:url action="hello" var="registerInputLink">
		<s:param name="user.name">Bruce Phillips</s:param>
	</s:url>
	<a href="${registerInputLink}">Please register</a> for our prize
	drawing.

	<h1>3 form and field validation</h1>
	<s:form action="hello">
		<!--  validate="true"> -->
		<s:textfield name="user.name" label="Your name" />
		<s:submit value="Submit" />
	</s:form>

	<h1>4 resource property</h1>
	<s:textfield key="user.description" />

	<h1>5 package level property/global level property in text tag</h1>
	<s:text name="struts.i18n.encoding" />

	<h1>6 select tag</h1>
	<s:select key="user.name" list="listExample" />

	<h1>7 radio tag</h1>
	<s:radio key="user.name" list="listExample" />

	<h1>8 checkbox tag</h1>
	<s:checkbox key="user.name" />

	<h1>9 checkboxlist tag</h1>
	<s:checkboxlist key="user.name" list="listExample" />

	<h1>10 xml validation</h1>
	<s:form action="hello" method="post" theme="xhtml"
		namespace="/validation" validate="true">
		<s:textfield label="User name" name="user.name"></s:textfield>
		<sx:submit value="check" validate="true" />
	</s:form>

	<h1>
		11 <a
			href="http://www.cnblogs.com/firstdream/archive/2012/03/14/2395690.html">
			Select</a>
	</h1>
	<h2>Example 1</h2>
	<s:select list="{'aa','bb','cc'}" theme="simple" headerKey="00"
		headerValue="00"></s:select>
	<h2>Exammple 2</h2>
	<s:select list="#{1:'aa',2:'bb',3:'cc'}" label="abc" listKey="key"
		listValue="value" headerKey="0" headerValue="aabb" />
	<h2>Example 3</h2>
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

	<h1>12 sx:autocompleter</h1>
	<sx:autocompleter name="test" list="{'SH','HN','GD'}"
		autoComplete="true" />

	<h1>13 date selector</h1>
	<sx:datetimepicker name="order.date" label="Order Date"
		displayFormat="yyyy-MM-dd" value="%{'2006-01-01'}" />

	<h1>14 Iterator</h1>
	<s:iterator value="listExample" id="user" status="st">
		<s:textfield name="name" onchange="modify('%{#st.index}')"
			id="nmUser_%{#st.index}" />
	</s:iterator>

	<h1>15 tree</h1>
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

	<h1>
		16 <a href="http://yueguc.iteye.com/blog/314303">Tab</a>
	</h1>
	<sx:tabbedpanel id="tabContainer">
		<sx:div label="Tab 1" id="tab1">   
       			Local Tab 1  
  			</sx:div>
		<sx:div label="Tab 2" id="tab2">   
       			Local Tab 2  
   			</sx:div>
	</sx:tabbedpanel>

	<h1>17 Build</h1>
	<s:div id="targetDiv">
		<input type="button" value="test" id="bin" />
		<s:text name="dfsdfsdfs"></s:text>
		<sx:bind events="onClick" targets="targetDiv" showLoadingText="true"
			indicator="%{getText('loadingImage')}" formId="bin"
			loadingText="Loading...." href="hello.action" />
	</s:div>

	<h1>18 Exception</h1>
	<h3>
		<a href="<s:url action="causesecurityexception" />">causesecurityexception</a>
	</h3>
	<h3>
		<a href="<s:url action="causeexception" />">causeexception</a>
	</h3>
	<h3>
		<a href="<s:url action="causenullpointerexception" />">causenullpointerexception</a>
	</h3>
	<h3>
		<a href='<s:url action="actionspecificexception" />'>Cause
			ActionSpecific Security Exception</a>
		<h3>
</body>
</html>