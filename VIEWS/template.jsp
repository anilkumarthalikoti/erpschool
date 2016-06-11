<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.java.erp.webapp.database.user.Users,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function studentSearch(e){
 if (e.keyCode == 13) {
$("div[id='content']").html("<center>SEARCHING STUDENT DATA....</center>");
  


 var keyWord=$("input[name='searchKey']").val().trim();
 if(keyWord.length==0){
	 return false;
 }
 
 var request=$.ajax({
	  method: "POST",
	  url: "studentsearch.action",
	  data: $("form[name='studentSearchGlobal']").serialize()
	 		});

 
request.done(function( msg ) {

$("div[id='content']").html(msg);
});

}
 return false;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${initParam.title}DASHBOARD</title>
<%
	Users user = (Users) session.getAttribute("LOGIN_DETAILS");
	String reloadActionName="#";
	String reloadVarible="#";
	if(null!=session.getAttribute("preaction")){
	reloadActionName=session.getAttribute("preaction").toString();
	reloadVarible=session.getAttribute("reload").toString();
	}
%>
<jsp:include page="/html/default.html" />
</head>
<body>
	<!--Header title-->
	
	<div class="header ui-state-default">
		<div style="height: 20px; border-bottom: 1px #333333 dotted;">
			<table align="right" cellpadding="0" cellspacing="0">
				<tr>
					<%
						if ("Y".equals(user.getIsAdmin())) {
					%>
					<td style="padding-right: 10px;"><a href="#"  ><span
							class="ui-state-default ui-corner-all ui-icon ui-icon-person" onClick="loadAddUser()"></span></a>
					</td>
					<td style="padding-right: 10px;"><a href="#"><span
							class="ui-state-default ui-corner-all ui-icon ui-icon-gear"></span></a>
					</td>
					<%
						}
					%>
					<td style="padding-right: 10px;"><a href="logout.action"><span
							class="ui-state-default ui-corner-all ui-icon ui-icon-power"></span></a>
					</td>
				</tr>
			</table>
<input class="hide" value="<%=reloadActionName%>" name="preaction" id="preaction" reload="<%=reloadVarible%>"/>
		</div>
		<div style="height: 35px; margin-top: 5px;">
			<table align="right" height="35" cellpadding="0" cellspacing="0"
				style="vertical-align: middle">
				<tr>
					<td valign="top">
						<div class="search-box-custom">
							<form method="post" name='studentSearchGlobal' onSubmit=" return false; ">
								<input type="text" placeholder="Student search..." name="searchKey" onKeyDown="studentSearch(event);"></input> <a
									href="studentsearch.action"><span
									class="ui-state-default ui-corner-all ui-icon ui-icon-search"></span></a>
							</form>
						</div>

					</td>
				</tr>
			</table>

		</div>

	</div>





	<div class="left">
		<div class="linkHeader ui-state-default ui-corner-all">
			<div style="width: 70px; float: left;">
				<img src="profile/<%=user.getUserId()%>.jpg"
					onError="this.onerror=null;this.src='images/no_profile_image.jpg';"
					width="48" height="48"></img>
			</div>
			<div>
				<span>Login Id &nbsp; &nbsp;:<%=user.getUserId()%></span>
				<hr />
				<span>Name &nbsp; &nbsp; &nbsp; &nbsp;:<%=user.getName()%></span>
				<hr />

			</div>
		</div>
		<div class="linkBody">
		<%
		String header="A";
		String endTag="</ul></div>";
		String startTag="<div><ul>";
		List<Object[]> links=(List<Object[]>)request.getAttribute("links");
		for(Object[] link:links){
		String current=link[0].toString();
		if(!current.equals(header)){
		if(!header.equals("A")){
		%>
		<%=endTag%>
		<%
		}
		header=current;
		%>
		<h3><%=link[1]%></h3>
		<%=startTag%>
		<%
		}
		%>
		<li url="<%=link[4]%>.action"><%=link[3]%> </li>
		<%
		}
		%> 
		</div>
		<div class="schoolLogo ui-state-default">
			<img src="images/ERP.png" width="250" height="120" />
		</div>
		<div class="linkFooter ui-state-default ui-corner-all">&nbsp;</div>
	</div>
	<div class="content" id='content' style="overflow:auto;"></div>
	<div class="fotter ui-state-default"></div>
	<%
						if ("Y".equals(user.getIsAdmin())) {
					%>
					
					
					 					<%}%>
</body>
</html>