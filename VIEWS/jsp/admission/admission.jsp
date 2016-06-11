<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.CourseDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/admission/admission.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Admission Form</div>


<div class="form" style="  border: 0px dotted #999999; float:left  ">
<form name="admissiondetails">
<div tabholder>
<ul>
		<li><a href="#primary">Primary Details</a></li>
		<li><a href="#other">Other Details</a></li>
		 
	</ul>
<div id="primary" style="height:auto;">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; line-height:25px; " cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="courseId"  value="-1" validate="notNull#" columnId='0' /></td> 
</tr>
<tr>
  <td width="155">Application no  </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="courseName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Student name </td>
  <td>:</td><td><input type="text" name="studetnName" validate="notNull#"  columnId='2'  /></td> </tr>
  <tr>
 
  <td>Gender </td>
  <td>:</td><td><select name="gender"><option value="-1">Select</option><option value="MALE">MALE</option><option value="FEMALE">FEMALE</option>
  </select></td> </tr>
  <tr>
  <td>Date of birth</td>
  <td>:</td><td><input type="text" name="dob" validate="notNull#"  columnId='2'  /></td> </tr>
  <tr>
  <td>Father name </td>
  <td>:</td><td><input type="text" name="fatherName" validate="notNull#" columnId='2'  /></td> </tr>
  <tr>
  <td>Mother name </td>
  <td>:</td><td><input type="text" name="motherName" validate="notNull#" columnId='2'  /></td> </tr>
  <tr>
  <td>Course name </td>
  <td>:</td><td><select></select></td> </tr>
  <tr>
  <td>Contact no  </td>
  <td>:</td><td><input type="text" name="prority"  columnId='2'  /></td> </tr>
  <tr>
  <td>Address </td>
  <td>:</td><td><input type="text" name="prority"  columnId='2'  /></td> </tr>
  
 
  <td colspan="3"> <input type="button" value="Save" onClick="coursedetails.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</div>

<div id="other" >
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; line-height:25px; " cellpadding="0" class="form" align="left"  >
 </table>
</div>
</div>
</form>
</div>

 
 <jsp:include page="/jsp/admission/admissionsearch.jsp"/>
 
<script type="text/javascript">
updateUi();
$("input").attr("id",$("input").attr("name"));
</script>
 
</body>
</html>