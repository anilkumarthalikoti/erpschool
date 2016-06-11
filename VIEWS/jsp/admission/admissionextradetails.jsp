<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.AcademicYears" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/admission/admissionauthorize.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Admission/Student Details</div>

<div class="form" style="width:480px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="admissionauthorize">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="courseId"  value="-1" validate="notNull#" columnId='0' /></td> 
</tr>
<tr>
  <td width="155">Academic Year </td>
  <td width="23">:</td>
<td width="320"><input type="text" disabled="disabled"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Status</td>
  <td>:</td><td><select columnId='2'><option value='Y'>Active</option><option value="N">In active</option></select></td> </tr>
 <tr>
  <td width="155">Prifix</td>
  <td width="23">:</td>
<td width="320"><input type="text"    validate="notNull#" columnId='3' maxlength="2"/></td> 
</tr>
<tr>
  <td width="155">Series from </td>
  <td width="23">:</td>
<td width="320"><input type="text"    validate="notNull#" columnId='4' maxlength="4"/></td> 
</tr>
<tr>
  <td width="155">Series ends </td>
  <td width="23">:</td>
<td width="320"><input type="text"     validate="notNull#" columnId='5' maxlength="4"/></td> 
</tr>
<tr>
  <td width="155">Accept from </td>
  <td width="23">:</td>
<td width="320"><input type="text"     validate="notNull#" columnId='6' datepicker  /></td> 
</tr>
<tr>
  <td width="155">Accept to </td>
  <td width="23">:</td>
<td width="320"><input type="text"     validate="notNull#" columnId='7'  datepicker /></td> 
</tr>
  <td colspan="3"> <input type="button" value="Save" onClick="admissionauthorize.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; width:600px; max-height:400px; overflow-y:auto">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th width="50">Id</th>
    <th>Academic year </th>
    
	<th width="50">Status</th>
	<th width="50">Prefix</th>
     <th width="50">Series Starts</th>
	 <th width="50">Series Ends</th>
	  <th width="50">Accept From</th>
	 <th width="50">Accept To</th>
  </tr>
  </thead>
  <tbody>
  <%
  List<AcademicYears> academicYearDetails=(List<AcademicYears>)request.getAttribute("academicYear");
  
  for(AcademicYears academicYear:academicYearDetails){
  %>
  <tr>
  <td><%=academicYear.getId()%></td>
  <td><%=academicYear.getAcademicYear() %></td>
  <td><%=academicYear.getIsActive()%></td>
    <td><%=academicYear.getApplicationPrefix()%></td>
  <td><%=academicYear.getSeriesFrom() %></td>
  <td><%=academicYear.getSeriesTo()%></td>
  <td><%=academicYear.getAcceptFrom() %></td>
  <td><%=academicYear.getAcceptTo()%></td>
  
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