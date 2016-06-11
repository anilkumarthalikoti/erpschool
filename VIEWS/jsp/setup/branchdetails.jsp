<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.BranchDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/branchdetails.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Branch Details</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:300px; border: 1px dotted #999999; float:left  ">
<form name="branchDetails">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:300px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="branchId"  value="-1" validate="notNull#"   columnId='0'/></td> 
</tr>
<tr>
  <td width="155">Branch name </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="branchName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Location</td>
  <td>:</td><td><input type="text" name="location"    columnId='2'/></td> </tr>
<tr>
  <td>Phone No </td>
  <td>:</td><td><input type="text" name="phoneNo"   columnId='3' /></td> </tr>
<tr>
  <td>Fax No </td>
  <td>:</td><td><input type="text" name="faxNo"   columnId='4'/></td> </tr>
<tr>
  <td>Email Id </td>
  <td>:</td><td><input type="text" name="email"   columnId='5'/></td> </tr>
<tr>
  <td>Address</td>
  <td>:</td><td><input type="text" name="address"  columnId='6' /></td> </tr>
  <tr align="center">
  <td colspan="3"> <input type="button" value="Save" onClick="branchdetails.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px;">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th>Id</th>
    <th>Branch name </th>
    <th>Location</th>
    <th>Phone number </th>
    <th>Fax Number </th>
	<th>Email </th>
	<th>Address </th>
  </tr>
  </thead>
  <tbody>
  <%
  List<BranchDetails> branchDetails=(List<BranchDetails>)request.getAttribute("branchDetails");
  
  for(BranchDetails branchDetail:branchDetails){
  %>
  <tr>
  <td><%=branchDetail.getBranchId()%></td>
  <td><%=branchDetail.getBranchName() %></td>
  <td><%=branchDetail.getLocation()%></td>
  <td><%=branchDetail.getPhoneNo()%></td>
  <td><%=branchDetail.getFaxNo()%></td>
  <td><%=branchDetail.getEmail()%></td>
  <td><%=branchDetail.getBranchAddress()%></td>
  
  
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