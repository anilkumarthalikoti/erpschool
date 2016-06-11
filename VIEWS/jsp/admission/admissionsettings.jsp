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
	
	$("select[name='course']").multiselect({
	noneSelectedText: "Select Course",
	
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
<td width="320"><select name="acyear" id="acyear" onChange="formapp.update()"> 
<option value="-1">Select Academic Year</option>
</select></td> 
</tr>
<tr>
  <td width="155">Course</td>
  <td width="23">:</td>
<td width="320"><select multiple="multiple" name="course" id="course" onChange="admissionsettings.update()"> 
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
  <td>:</td><td><select name='status' columnId='2'><option value="I">Interview</option><option value="E">Examination</option></select></td> </tr>
  <tr>
  <td colspan="3"> <input type="button" value="Save" onClick="formapp.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; min-width:600px; width:90%; min-height:400px; max-height:500px; overflow-y: auto; overflow-x:hidden">
 <table  border="0" id="datatable" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th  class="hide">Id</th>
    <th width="150">Academic year </th>
    
	<th width="50">Status</th>
	<th width="50">Prefix</th>
     <th width="100">Series Starts</th>
	 <th width="100">Series Ends</th>
	  <th width="150">Accept From</th>
	 <th width="150">Accept To</th>
  </tr>
  </thead>
  <tbody>
  <%
  List<AcademicYears> academicYearDetails=(List<AcademicYears>)request.getAttribute("academicYear");
  
  for(AcademicYears academicYear:academicYearDetails){
  %>
  <tr id="ac#<%=academicYear.getId()%>" style="text-align:center">
  <td class="hide"><%=academicYear.getId()%></td>
  <td><%=academicYear.getAcademicYear() %></td>
  <td><%=academicYear.getIsActive()%></td>
    <td><%=academicYear.getApplicationPrefix()%></td>
  <td><%=academicYear.getSeriesFrom() %></td>
  <td><%=academicYear.getSeriesTo()%></td>
  <td><%=sdf.format(academicYear.getAcceptFrom()) %></td>
  <td><%=sdf.format(academicYear.getAcceptTo())%></td>
  
  </tr>
  <%}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
$("input").attr("id",$("input").attr("name"));
$("table[id='datatable'] tbody tr").each(function(){
var value=$(this).find("td:eq(0)").html();
var value1=$(this).find("td:eq(1)").html();
$("select[id='acyear']").append($('<option/>', { 
        value: value,
        text : value1 
    }));
});
</script>
</body>
</html>