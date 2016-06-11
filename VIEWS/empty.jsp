<%@ page language="java" import="java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/jquery/jquery.multiselect.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.filter.js"></script>
 
<title></title>
</head>
<%
%>
<body>
<div class="pageTitle"></div>
<jsp:include page="../../jsp/message.jsp" />
 

 <div class="form" nohide>
<form name="formName">
<table width="600" border="0" cellspacing="5" cellpadding="0" > 
  
  <tr><td colspan="3" align="right"><input type="button" value="Save" onClick=""/></td></tr>
  <tr><td colspan="3">
  
  </td></tr>
</table>
</form>

</div>
 <div class="grid" id='grid' no-form>
 <table  border="0" cellspacing="0" cellpadding="0" height="30" style="vertical-align:top" >
 <thead>
   
  </thead>
  <tbody>
  
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
//$("input").attr("id",$("input").attr("name"));
</script>
</body>
</html>