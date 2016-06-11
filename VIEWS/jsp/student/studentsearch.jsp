<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.CourseDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/student/studentsearch.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Student Details List </div>

 
 <div class="grid" id='grid' >
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th width="50">Id</th>
    <th>Application no </th>
    <th  >Student id </th>
     <th  >Student name </th>
	 <th  >Father name </th>
	 <th >Mother name </th>
	 <th  >Contact no</th>
	 <th >Mail id</th>
	 <th >Address</th>
  </tr>
  </thead>
  <tbody>
  <%
  List<Object[]> studentData=(List<Object[]>)request.getAttribute("studentlist");
  if(null!=studentData && !studentData.isEmpty()){
  for(Object[] student:studentData){
  %>
  <tr>
  <td><%=student[0]%></td>
 <td><%=student[1]%></td>
 <td><%=student[2]%></td>
 <td><%=student[3]%></td>
 <td><%=student[4]%></td>
 <td><%=student[5]%></td>
 <td><%=student[6]%></td>
 <td><%=student[7]%></td>
 <td><%=student[8]%></td>
 
   
  
  
  </tr>
  <%}}else{%><tr><td colspan="9"><span class="ui-state-error">*NO DATA FOUND*</span></td></tr><%}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
$("input").attr("id",$("input").attr("name"));
</script>
</body>
</html>