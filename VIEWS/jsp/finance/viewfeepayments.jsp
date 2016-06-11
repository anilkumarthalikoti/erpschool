<%@ page language="java"
	import="java.text.SimpleDateFormat,java.util.List,com.java.erp.webapp.database.setup.AcademicYears,java.util.Date"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript"	src="js/finance/feestructure.js"></script>
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
<jsp:include page="../../jsp/message.jsp" />


	<div class="form" style="border: 0px dotted #999999; float: left">
		<form name="feestructure" id="feestructure" onSubmit="return false" action="">
			<table width="500" border="0"
				style="margin: 0; padding: 0; line-height: 25px;" cellpadding="0"
				cellspacing="0" class="form">
				<tr class="hide">
					<td colspan="3">&nbsp;</td>
				</tr>
				 
			 <TR style="height:1px;"><TD colspan="3" style="height:2px; background:#000000;"> </TD></TR>
				<tr>
				  <td colspan="3" align="center" style="font-weight:bold;">AMOUNT DETAILS </td>
				</tr>
				<TR style="height:1px;"><TD colspan="3" style="height:2px; background:#000000;"> </TD></TR>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">APR:
				    <input type="text" name="apr" value="0.00" ></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">MAY:
				    <input type="text" name="may" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">JUN:
				    <input type="text" name="jun" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">JUL:
				    <input type="text" name="jul" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">AUG:
				    <input type="text" name="aug" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">SEP:
				    <input type="text" name="sep" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">OCT:
				    <input type="text" name="oct" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">NOV:
				    <input type="text" name="nov" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">DEC:
				    <input type="text" name="dec" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">JAN:
				    <input type="text" name="jan" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">FEB:
				    <input type="text" name="feb" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">MAR:
				    <input type="text" name="mar" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">ADMISSION AMOUNT:
				    <input type="text" name="admissionFee" value="0.00"></td>
				</tr>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">REFUND AMOUNT:
				    <input type="text" name="refundAmount" value="0.00"></td>
				</tr>
				<TR class="hide"><TD colspan="3"><HR/></TD></TR>
				<TR style="height:1px;"><TD colspan="3" style="height:2px; background:#000000;"> </TD></TR>
				<tr>
				  <td colspan="3" align="right" style="font-weight:bold;">TOTAL:
				    <input type="text" name="total" value="0.00" disabled="disabled"></td>
				</tr>
				<tr>
					<td colspan="3" align="right"><input type="button"
						value="Save" onClick="feestru.saveFee();"  > <input type="button" class="hide"
						value="Search" showGrid /></td>
				</tr>
			</table>

		</form>

	</div>
	<div class="grid" id='grid' no-form>
		<table border="0" cellspacing="0" cellpadding="0" height="30"
			style="vertical-align: top">
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