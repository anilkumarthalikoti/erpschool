<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${initParam.title}Login</title>
<jsp:include page="/html/default.html" />
<link media="screen" href="css/login.css" rel="stylesheet"/>
<script type="text/javascript" src="js/user/login.js"></script>
<script type="text/javascript">
$(document).ready(function(){
$('[id="userId"]').focus();
$('[id="password"]').keydown(function(event){
if ( event.which == 13 ) {
event.preventDefault();
login.validateDetails();
}
});
});
</script>
</head>
<body>

<table height="100%" width="100%">
<tr><td valign="center" align="center">
<div class="login">
 

<table align="center" >
<tr><td colspan="3"  align="center" valign="bottom" style="height:50px; "   >
${initParam.title}LOGIN
<hr/>
</td></tr>
<tr class="small"><td>Login Id</td>
<td >:</td>
<td width="72"><input type="text"  id='userId'  size="40"/></td>
</tr>
<tr class="small"><td>Password</td><td>:</td><td><input type="password" id="password" size="40"  /></td></tr>
<tr class="small" >
<td colspan="3"  align="right"><input type="button"  class="button1" value="Login" onClick="login.validateDetails()"/>&nbsp;<input class="button1"  type="button" value="Reset"/></td></tr>
<tr>
<td colspan="3" align="center" valign="top" height="30px"  >

<hr/>
<div id="errorMsg" style="font-size:12px;"></div>
 </td>
</tr>
</table>

 
 
</div>

</td></tr>
</table>
</body>
</html>