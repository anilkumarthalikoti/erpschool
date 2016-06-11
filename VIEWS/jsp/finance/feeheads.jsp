<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.SubjectDetails,com.java.erp.webapp.database.setup.CourseDetails,com.java.erp.webapp.database.setup.BranchDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/batchdetails.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.filter.js"></script>
 
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Fee Heads</div>
<jsp:include page="../../jsp/message.jsp" />
<%
 List<BranchDetails> branchDetails=(List<BranchDetails>)request.getAttribute("branchDetails");
  List<CourseDetails> courseDetails=(List<CourseDetails>)request.getAttribute("courseDetails");
  List<SubjectDetails> subjectDetails=(List<SubjectDetails>)request.getAttribute("subjectDetails");
%>

 <div class="form" nohide>
<form name="batchDetails">
<table width="600" border="0" cellspacing="5" cellpadding="0" > 
  <tr valign="top" style="background:#FFFFFF">
    <td width="200"> 
	 
<select multiple="multiple" style=" width:200px;" name="branch" header="Select branch">
 
<% for(BranchDetails branchDetail:branchDetails){%>
  <option value="<%=branchDetail.getBranchId() %>"><%=branchDetail.getBranchName() %></option>
   <%}%>
</select> </td>
    <td width="200"><select name="course" multiple="multiple" style="  width:200px;" header="Select course">
      <% 
  for(CourseDetails courseDetail:courseDetails){
  %>
      <option value="<%=courseDetail.getCourseId() %>"><%=courseDetail.getCourseName() %></option>
      <%}%>
    </select></td>
    <td width="200"> 
	 
<select multiple="multiple" name="language" style="  width:200px;" header="Select Language">
<%
if(null!=subjectDetails)
 for(SubjectDetails subjectDetail:subjectDetails){
  %>
 <option value="<%=subjectDetail.getSubjectId()%>"><%=subjectDetail.getSubjectName() %></option>
   <%}%>
</select>
  </td>
  </tr>
  <tr><td colspan="3" align="right"><input type="button" value="Save" onClick="batchdetails.saveBatchdetails()"/></td></tr>
  <tr><td colspan="3">
  
  </td></tr>
</table>
</form>

</div>
 <div class="grid" id='grid' no-form>
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th class="hide">Branch Id </th>
    <th class="hide">Course Id  </th>
    <th class="hide">Subject Id </th>
    <th>Branch Name </th>
    <th>Course Name </th>
	<th>Subject Name </th>
	<th class="hide">Batch Id </th>
	<th> Is active </th>
  </tr>
  </thead>
  <tbody>
  <%
  List<Object[]> batchDetails=(List<Object[]>)request.getAttribute("batchDetails");
  
  for(Object[] batchDetail:batchDetails){
  
  %>
  <tr>
  <td class="hide"><%=batchDetail[0]%></td>
  <td class="hide"><%=batchDetail[1]%></td>
  <td class="hide"><%=batchDetail[2]%></td>
  <td><%=batchDetail[3]%></td>
  <td><%=batchDetail[4]%></td>
  <td><%=batchDetail[5]%></td>
  <td class="hide"><%=batchDetail[6]%></td>
  <td><%=batchDetail[7]%></td>
  
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