<%@ page language="java"
	import="java.text.SimpleDateFormat,java.util.List,com.java.erp.webapp.database.setup.AcademicYears,java.util.Date"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"	src="js/finance/feepayments.js"></script>
<style type="text/css">
.lbl{
font-weight:bold;
text-align:right;
text-indent:right;

}
table.form tr td input{
width:80px;
text-align:right;

}
</style>
<title></title>
</head>
<%
%>
<body>
	<div class="pageTitle">Fee Payments </div>
	<jsp:include page="../../jsp/message.jsp" />


	<div class="form1" style="border: 0px dotted #999999;">
		<form name="feestudent" id="feestructure" onSubmit="return false" action="">
			<table width="100%" border="0"
				style="margin: 0; padding: 0; line-height: 25px;" cellpadding="0"
				cellspacing="0" class="form">
		 
				<tr>
					<td width="13%">Student/Application Id</td>
					<td width="1%">:</td>
				  <td width="86%" ><input name="studentId" id="studentId" type="text" onKeyDown="feepay.fetchfeepayments(event)"></td>
				</tr>
				 
			</table>

		</form>
 <div id="feeview"></div>
	</div>
	
	<script type="text/javascript">
		updateUi();
		 
		//$("input").attr("id",$("input").attr("name"));
	</script>
</body>
</html>