<%--
<jsp:forward page="example/test.jsp"></jsp:forward>
 --%>
  
<%
   	response.sendRedirect("hello.action");
    //response.setHeader("Location", "example/test.jsp");
    //response.setHeader("REFRESH", "1;example/test.jsp");
%>
