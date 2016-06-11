<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
   <%
   if(session.getAttribute("ERROR_MSG")!=null){
	   
   
   %>
   <span style="color:red">*<%=session.getAttribute("ERROR_MSG") %>*</span>
   <%
   session.removeAttribute("ERROR_MSG");
   } %>
 
</body>
</html>