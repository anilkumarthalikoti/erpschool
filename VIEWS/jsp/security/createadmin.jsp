<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${initParam.title}Login</title>
<jsp:include page="/html/default.html" />
<link media="screen" href="css/login.css" rel="styleSheet"/>
<script type="text/javascript" src="js/user/addadmin.js"></script>

</head>
<body>

<table height="100%" width="100%">
<tr><td valign="center" align="center">
<div class="login">
 

<table >
<tr>
  <td colspan="3"  align="center" style="height:50px; "   >
${initParam.title}ADMIN CREATION
  <hr/></td></tr>
<tr class="small"><td width="60" valign="bottom">Login Id</td>
<td width="20">:</td>
<td width="72"><input type="text" class="input" id='userId'/></td>
</tr>
<tr class="small"><td>Password</td><td>:</td><td><input type="password" id="password" class="input"/></td></tr>
<tr class="small"><td colspan="3" align="center"><input type="button"  class="button1" value="Create Admin" onClick="admin.validateDetails()"/>
&nbsp;  <input class="button1"  type="button" value="Reset"/></td>
</tr>
<tr>
<td colspan="3" align="center"  >

<hr/>
<div id="errorMsg" class="hide"><span style="color:#FF0000">*Unable to create admin*</span></div> </td>
</tr>
</table>

 
 
</div>

</td></tr>
</table>
</body>
</html>