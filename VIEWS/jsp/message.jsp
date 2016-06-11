
<% 
String status=null;
if("1".equals(request.getAttribute("status_code"))){
	%>
	<div class="successMessage"><%=request.getAttribute("message_code") %></div>
	<%
}
if("-1".equals(request.getAttribute("status_code"))){
	%>
	<div class="errorMessage"><%=request.getAttribute("message_code") %></div>
	
	<%
}
%>