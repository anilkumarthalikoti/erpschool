<%@ page language="java" import="java.text.SimpleDateFormat,java.util.List,java.util.Date,java.util.List,com.java.erp.webapp.database.setup.CourseDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/student/studentsearch.js"></script>
<title></title>
</head>
<%
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
%>
<body>
 

 
 <div class="grid" id='grid' >
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th class="hide">Id</th>
    <th>Application no </th>
   
     <th>Student name </th>
	 <th >Gender</th>
	 <th >Dob</th>
	 <th class="hide">Course Id</th>
	 <th>Father name </th>
	 <th>Mother name </th>
	 <th>Course</th>
	 <th>Contact no</th>
	 <th >Mail id</th>
	 <th >Address</th>
	 <th >Status</th>
  </tr>
  </thead>
  <tbody>
  <%
  List<Object[]> studentData=(List<Object[]>)request.getAttribute("studentlist");
  if(null!=studentData && !studentData.isEmpty()){
  for(Object[] student:studentData){
  %>
  <tr applicationNo="<%=student[1]%>">
  <td class="hide"><%=student[0]%></td>
 <td><%=student[1]%></td>
 
 <td><%=student[3]%></td>
 <td><%=student[10]%></td>
  <td><%=sdf.format(student[11])%></td>
  <td class="hide"><%=student[12]%></td>
 <td><%=student[4]%></td>
 <td><%=student[5]%></td>
 <td><%=student[13]%></td>
 <td><%=student[6]%></td>
 <td><%=student[7]%></td>
 <td><%=student[8]%></td>
 <td><%=student[9]%></td>
   
  
  
  </tr>
  <%}}else{%><tr><td colspan="9"><span class="ui-state-error">*NO DATA FOUND*</span></td></tr><%}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
//updateUi();
//$("input").attr("id",$("input").attr("name"));
</script>
</body>
</html>