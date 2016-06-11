<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.java.erp.webapp.database.user.Users"%>
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
	<input class="hide" value="<%=reloadActionName%>" name="preaction" id="preaction" reload="<%=reloadVarible%>"/>
	<div class="header ui-state-default">
		<div style="height: 20px; border-bottom: 1px #333333 dotted;">
			<table align="right" cellpadding="0" cellspacing="0">
				<tr>
					<%
						if ("Y".equals(user.getIsAdmin())) {
					%>
					<td style="padding-right: 10px;"><a href="#"><span
							class="ui-state-default ui-corner-all ui-icon ui-icon-person"></span></a>
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
			<h3>DASHBOARD</h3>
			<div>
				<ul>
					<li url="#.action">INBOX</li>
					<li url="#.action">SENT</li>
					<li url="#.action">REMINDARS</li>
				</ul>
			</div>
			<h3>ADMISSION</h3>
			<div>
				<ul>
					<li url="admissionauthorization.action">ADMISSION AUTHORIZATION</li>
					<li url="admissionsettings.action">ADMISSION SETTINGS</li>
					<li url="interviewschedule.action">INTERVIEW SCHEDULE</li>
					<li url="interviewerschedule.action">INTERVIEWER SCHEDULE</li>
					<li url="admissionexamsubjects.action">EXAM SUBJECTS</li>
					<li url="admissionexamsubjects.action">EXAM SUBJECTS MARKS</li>
					<li url="admission.action">APPLICATION FROM</li>
					<li url="admission.action">ACCEPT/REJECT APPLICATION</li>

				</ul>
			</div>
			<h3>FINANCE</h3>
			<div>
				<ul>
					<li url="feestructure.action">Fee structure</li>
					<li url="applyconcession.action">Apply concession</li>
					<li url="feepayments.action">Fee pay</li>
					<li url="cancelpayments.action">Cancel payment</li>
					<li url="duplicatereceipt.action">Duplicate receipt</li>
				</ul>
			</div>
			<h3>ACCOUNTS</h3>
			<div>
				<ul>
				<li url="accountgroups.action">Account Groups</li>
				<li url="accountheads.action">Account Heads</li>
					
				</ul>
			</div>
			<h3>STUDENT</h3>
			<div>
				<ul>
					<li url="studentdetails.action">Student details</li>
					
				</ul>
			</div>
			<h3>ACADEMICS</h3>
			<div>
				<ul>
					<li url="#.action">SUBJECTS</li>
					<li url="#.action">EXAMINATION</li>
					<li url="#.action">ADD ADMISSION DETAILS</li>



				</ul>
			</div>
			<h3>LIBRARY</h3>
			<div>
				<ul>
					<li url="#.action">APPLICATION SERIES</li>
					<li url="#.action">ADMISSION FORM</li>
					<li url="#.action">ADD ADMISSION DETAILS</li>



				</ul>
			</div>
			<h3>TRANSPORT</h3>
			<div>
				<ul>
					<li url="#.action">APPLICATION SERIES</li>
					<li url="#.action">ADMISSION FORM</li>
					<li url="#.action">ADD ADMISSION DETAILS</li>



				</ul>
			</div>
			<h3>SET-UP</h3>
			<div>
				<ul>
					<li url="schooldetails.action">SCHOOL DETAILS</li>
					<li url="branchdetails.action">BRANCH DETAILS</li>
					<li url="coursedetails.action">COURSE DETAILS</li>
					<li url="subjectdetails.action">LANGUAGES</li>
					<li url="batchdetails.action"> MAPPINGS(Branch,Course,Language)</li>
					<li url="studentadmissionfields.action">STUDENT/ADMISSION DETAILS</li>


				</ul>

			</div>
		</div>
		<div class="schoolLogo ui-state-default">
			<img src="images/ERP.png" width="250" height="120" />
		</div>
		<div class="linkFooter ui-state-default ui-corner-all">&nbsp;</div>
	</div>
	<div class="content" id='content' style="overflow:auto;"></div>
	<div class="fotter ui-state-default"></div>
</body>
</html>