<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.StudentAdmissionFields" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/studentadmissionfields.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">STUDENT/ADMISSION FIELDS </div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="studentadmissionfields">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="fieldId"  value="-1" validate="notNull#" columnId='0' /></td> 
</tr>
<tr>
  <td width="155">Field name  </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="fieldName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Is Required </td>
  <td>:</td><td><input type="checkbox" name="isRequired"  columnId='3' value="N"  /></td> </tr>
 <tr>
  <td>Is Active </td>
  <td>:</td><td><input type="checkbox" name="isActive"  columnId='4' value="N"  /></td> </tr>
  <td colspan="3"> <input type="button" value="Save" onClick="studentfields.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; width:550px;">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th width="50">Id</th>
    <th>Field Name </th>
    <th width="80">Is Required </th>
	 <th width="80">Is Active </th>
     
  </tr>
  </thead>
  <tbody>
  <%
  List<StudentAdmissionFields> studentAdmissionFields=(List<StudentAdmissionFields>)request.getAttribute("studentadmissionfields");
  
  for(StudentAdmissionFields studentAdmissionField:studentAdmissionFields){
	 
  %>
  <tr>
  <td><%=studentAdmissionField.getFieldId()%></td>
  <td><%=studentAdmissionField.getFieldName()%></td>
  <td><%=studentAdmissionField.getIsRequired()%></td>
    <td><%=studentAdmissionField.getIsActive()%></td>
  
  
  </tr>
  <%}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
$("input").attr("id",$("input").attr("name"));
</script>
</body>
</html>