<%@ page language="java" import="java.text.SimpleDateFormat,java.util.List,java.util.Date,com.java.erp.webapp.database.setup.AcademicYears" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/admission/admissionsettings.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.filter.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$("select[name='mappingId']").multiselect({
	noneSelectedText: "Select Course",
	
	}).multiselectfilter();
	
	$("select[name='acyear']").multiselect({
	noneSelectedText: "Select Academic Year",
	
	}).multiselectfilter();
	
	 
	 
});
</script>
<title></title>
</head>
<%
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
List<Object[]> batchDetails=null;
if(null!=request.getAttribute("batchDetails")){
batchDetails=(List<Object[]>)request.getAttribute("batchDetails");
}
%>
<body>

<div class="pageTitle">Admission Settings</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="admissionauthorize">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="authorizationId"  value="-1" validate="notNull#" columnId='0' /> </td> 
</tr>
<tr>
  <td width="155">Academic Year </td>
  <td width="23">:</td>
<td width="320"><select multiple="multiple" name="acyear" id="acyear" onChange="formapp.update()"> 
 <%
 List<AcademicYears> academicYears=(List<AcademicYears>)request.getAttribute("academicYear");
 for(AcademicYears acyear:academicYears){ %>
 <option value="<%=acyear.getId() %>"><%=acyear.getAcademicYear() %></option>
 <%} %>
</select></td> 
</tr>
<tr>
  <td width="155">Course</td>
  <td width="23">:</td>
<td width="320"><select multiple="multiple" name="mappingId" id="course" onChange="admissionsettings.update()"> 
 <%
 if(null!=batchDetails){
 for(Object[] batchDetail:batchDetails){
 %>
 <option value="<%=batchDetail[6]%>"><%=batchDetail[3]%>-<%=batchDetail[4]%>-<%=batchDetail[5]%></option>
 <%
 
 }
 
 }
 %>
</select></td> 
</tr>
<tr>
  <td>Admission Mode </td>
  <td>:</td><td><select multiple="multiple" name='mode' columnId='2' selectMenu><option value="-1" selected="selected" >--Select--</option><option value="I">Interview</option><option value="E">Examination</option></select></td> </tr>
  <tr>
  <td colspan="3"> <input type="button" value="Save" onClick="admissionsettings.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; min-width:400px; width:500px; min-height:400px; max-height:500px; overflow-y: auto; overflow-x:hidden">
 <table  border="0" id="datatable" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
   <th class="hide">MappingId</th>
    <th width="100">Academic year </th>
    
	<th >Courses</th>
	<th width="70">Mode</th>
      
  </tr>
  </thead>
  <tbody>
  <%
  List<Object[]> admissionSettings=(List<Object[]>)request.getAttribute("admissionSettings");
  
  for(Object[] admissionSetting:admissionSettings){
  String mode="Interview";
  if("E".equals( admissionSetting[10].toString())){
	  mode="Examination";
  }
  %>
  <tr   style="text-align:center">
  <td class="hide"><%=admissionSetting[6]%></td>
  <td><%=admissionSetting[9] %></td>
  <td><%=admissionSetting[3]%>-<%=admissionSetting[4]%>-<%=admissionSetting[5]%></td>
    
    <td><%=mode%></td>
   
  
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