<%@ page language="java" import="java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title></title>
</head>
<%
%>
<body>
 <div class="grid" no-form>
 <table>
 <tbody>
 <%
 List<Object[]> reminders=null;
 reminders=(List<Object[]>)((List)request.getAttribute("result")).get(2);
 if(!(null==reminders)){
 for(Object[] data:reminders){
 %>
 <tr><td><%=data[6]%></td><td><%=data[5]%></td></tr>
 <%}}%>
 </tbody>
 </table></div>
</body>
</html>