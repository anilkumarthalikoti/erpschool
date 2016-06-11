<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.CourseDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/coursedetails.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Course Details</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="courseDetails">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="courseId"  value="-1" validate="notNull#" columnId='0' /></td> 
</tr>
<tr>
  <td width="155">Course name </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="courseName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Prority</td>
  <td>:</td><td><input type="text" name="prority"  columnId='2'  /></td> </tr>
 
  <td colspan="3"> <input type="button" value="Save" onClick="coursedetails.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; width:500px;">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th width="50">Id</th>
    <th>Course </th>
    <th width="50">Prority</th>
     
  </tr>
  </thead>
  <tbody>
  <%
  List<CourseDetails> courseDetails=(List<CourseDetails>)request.getAttribute("courseDetails");
  
  for(CourseDetails courseDetail:courseDetails){
  %>
  <tr>
  <td><%=courseDetail.getCourseId()%></td>
  <td><%=courseDetail.getCourseName() %></td>
  <td><%=courseDetail.getPrority()%></td>
   
  
  
  </tr>
  <%}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
//$("input").attr("id",$("input").attr("name"));
</script>
</body>
</html>