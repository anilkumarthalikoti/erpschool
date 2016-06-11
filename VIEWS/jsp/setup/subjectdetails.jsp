<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.SubjectDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/setup/subjectdetails.js"></script>
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle">Subject Details</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:480px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="subjectDetails">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="320"><input type="hidden" name="subjectId"  value="-1" validate="notNull#" columnId='0' /></td> 
</tr>
<tr>
  <td width="155">Subject name </td>
  <td width="23">:</td>
<td width="320"><input type="text" name="subjectName"   validate="notNull#" columnId='1'/></td> 
</tr>
<tr>
  <td>Prority</td>
  <td>:</td><td><input type="text" name="prority"   columnId='2' /></td> </tr>
 
  <td colspan="3"> <input type="button" value="Save" onClick="subjectdetails.saveData()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; width:450px;">
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
  <tr>
    <th>Id</th>
    <th>subject </th>
    <th>Prority</th>
     
  </tr>
  </thead>
  <tbody>
  <%
  List<SubjectDetails> subjectDetails=(List<SubjectDetails>)request.getAttribute("subjectDetails");
  
  for(SubjectDetails subjectDetail:subjectDetails){
  %>
  <tr>
  <td><%=subjectDetail.getSubjectId()%></td>
  <td><%=subjectDetail.getSubjectName() %></td>
  <td><%=subjectDetail.getPrority()%></td>
   
  
  
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