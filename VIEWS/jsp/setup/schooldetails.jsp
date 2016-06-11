<%@ page language="java" import="com.java.erp.webapp.database.setup.SchoolDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/schooldetails.js"></script>
<title></title>
</head>
<%
SchoolDetails school=null;
if(null!=request.getAttribute("schoolDetails") && request.getAttribute("schoolDetails") instanceof SchoolDetails ){
school=(SchoolDetails)request.getAttribute("schoolDetails");
}
%>
<body>
<div class="pageTitle">School Details</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:300px; border: 1px dotted #999999; float:left  ">
<form name="schoolDetails" method="post" onSubmit="return false">
<table      cellspacing="0" cellpadding="0"  align="left"  >
 
<tbody>
<tr class="hide"><td colspan="3"></td></tr>
<tr><td width="155">School Reg.No</td>
<td width="23">:</td>
<td width="320"><input type="text" name="regNo" id="regNo" validate="notNull#"/></td> 
</tr>
<tr>
  <td>School Name </td>
  <td>:</td><td><input type="text" name="schoolName" id="schoolName" validate="notNull#"/></td> </tr>
<tr>
  <td>Phone No </td>
  <td>:</td><td><input type="text" name="phoneNo" id="phoneNo" validate="notNull#"/></td> </tr>
<tr>
  <td>Fax No </td>
  <td>:</td><td><input type="text" name="faxNo" id="faxNo" validate="notNull#"/></td> </tr>
<tr>
  <td>Email Id </td>
  <td>:</td><td><input type="text" name="email" id="email" validate="notNull#"/></td> </tr>
<tr>
  <td>Website</td>
  <td>:</td><td><input type="text" name="webUrl" id="webUrl" validate="notNull#"/></td> </tr>
  <tr align="center">
  <td colspan="3"> <input type="button" value="Save" onClick="schooldetails.saveData()"/>&nbsp; <input  style="display:none;"  type="button" onClick="return false;" value="Reset" showGrid="" ></input> </td>
  </tr>
</tbody>
</table>
</form>
</div>
<script type="text/javascript">
updateUi();
<%if(null!=school){%>
$("#regNo").val("<%=school.getRegNo()%>");
$("#schoolName").val("<%=school.getSchoolName()%>");
$("#phoneNo").val("<%=school.getPhoneNo()%>");
$("#faxNo").val("<%=school.getFaxNo()%>");
$("#email").val("<%=school.getEmail()%>");
$("#webUrl").val("<%=school.getWebUrl()%>");


<%}%>
</script>
</body>
</html>