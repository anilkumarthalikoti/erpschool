<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.user.Users" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/admin/usercreation.js"></script>
<title></title>
</head>
<%
String[] userType={"SELECT","ADMIN","TEACHER","STAFF"};
%>
<body>
<div class="pageTitle">Users</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:300px; border: 1px dotted #999999; float:left  ">
<form name="userDetails">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:300px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr>
  <td width="155">User Id </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="userId"  value="" validate="notNull#"   columnId='0'/></td> 
</tr>
<tr>
  <td width="155">Name </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="userName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Password</td>
  <td>:</td><td><input type="password" name="loginPassword"    columnId='2'/></td> </tr>
<tr>
  <td>Phone No </td>
  <td>:</td><td><input type="text" name="mobileNo"   columnId='3' /></td> </tr>
 <tr>
  <td>Email Id </td>
  <td>:</td><td><input type="text" name="mailId"   columnId='4'/></td> </tr>
<tr>
  <td>Dashboard View </td>
  <td>:</td><td><select name="dashBoardView">
  <%
  for(int i=0;i<userType.length;i++){
  %>
  <option value="<%=i%>"><%=userType[i]%></option>
  <%
  }
  
  %>
  </select></td> </tr>
  <tr><td>Status</td><td>/</td><td> <div buttongroup='isActive'>
  
          <input type="radio"    name="isActive" value="true" id="true" checked="checked">
          <label for="true"> ACTIVE</label>
          <input type="radio"    name="isActive" value="false" id="false">
          <label for="false">INACTIVE</label>
   </div></td></tr>
  <tr align="center">
  <td colspan="3"> <input type="button" value="Save" onClick="user.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px;">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th>User Id</th>
    <th>Name </th>
    <th class="hide">Password</th>
    <th>Phone no </th>
    
	<th>Email </th>
	<th class="hide"></th>
	<th>Dashboard View</th>
	<th>Status</th>
  </tr>
  </thead>
  <tbody>
  <%
  List<Users> users=(List<Users>)request.getAttribute("users");
  
  for(Users user:users){
  %>
  <tr>
  <td><%=user.getUserId()%></td>
  
  <td><%=user.getName()%></td>
  <td class="hide"><%=user.getPassword()%></td>
  <td><%=user.getPhoneNo()%></td>
  <td><%=user.getMailId()%></td>
  <td class="hide"><%=user.getDashboardView()%></td>
  <td><%=userType[user.getDashboardView()]%></td>
  
  <td><%=user.getIsActive() %></td>
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