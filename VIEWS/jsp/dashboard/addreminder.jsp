<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/dashboard/reminder.js"></script>
</head>
<body>
<%
Map modes=new HashMap();
modes.put(1,"EVERY DAY");
modes.put(2,"ON DAY");
modes.put(3,"WEEKLY");
modes.put(4,"MONTHLY");
%>
<div class="pageTitle">Reminders</div>
<jsp:include page="../../jsp/message.jsp" />
<div class="form" style="width:514px; height:200px; border: 1px dotted #999999; float:left  ">
<form name="reminders">
<table width="100%"  cellspacing="0" style="margin:0; padding:0 ; height:200px;" cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="200">Id </td>
  <td width="4">:</td>
<td  ><input type="hidden" name="reminderId"  value="-1" validate="notNull#" columnId='0' /> </td> 
</tr>
<tr >
  <td width="200">Title </td>
  <td width="4">:</td>
<td  ><input type="text" name="reminderTitle"   validate="notNull#" columnId='1' /> </td> 
</tr>
<tr>
  <td >Reminder </td>
  <td width="4">:</td>
<td  ><textarea name="reminderText" id="reminderText" rows="5" cols="45" columnId='2'></textarea></td> 
</tr>
 
<tr>
  <td  >Reminder type </td>
  <td width="4">:</td>
<td  ><select  onChange="reminder.setReminderView();"  name="reminderType" id="reminderType" selectMenu > 
 <option value="-1">Select Reminder</option>
<%
Iterator iteratorReminder=modes.keySet().iterator();
while(iteratorReminder.hasNext()){
Object key=iteratorReminder.next();
%>
<option value="<%=key%>"><%=modes.get(key) %></option> 
<%
}
%>
  
</select><span class="hide"><input type="text" size="0" style="width:0px;"/></span></td> 
</tr>
<tr   height="20">
<td id="lableStart">Starts from </td>
<td  >&nbsp;</td><td  ><input type="text"  name="startFrom" id="stratFrom" datePicker/></td>
</tr>
 <tr   reminderType="onDate">
 <td>Ends on  </td>
 <td>:</td><td><input type="text" name="endsOn" id="endsOn" datePicker /></td>
 </tr>
  <tr   reminderType="weekDays" class="hide">
 <td>Select week days </td>
 <td>:</td><td> 
 
 <div buttongroup="weekDays">
 
       <input type="checkbox" name="weekDays" value="6" ID="su">
        <label FOR="su">SU</label>
       <input type="checkbox" name="weekDays" value="0" id="mo">
      <label FOR="mo">MO</label>
       <input type="checkbox" name="weekDays" value="1" id="tu">
      <label FOR="tu">TU</label>
       <input type="checkbox" name="weekDays" value="2" id="we">
      <label FOR="we">WE</label>
       <input type="checkbox" name="weekDays" value="3" id="th">
    <label FOR="th">TH</label>
       <input type="checkbox" name="weekDays" value="4" id="fr">
    <label FOR="fr">FR</label>
       <input type="checkbox" name="weekDays" value="5" id="sa">
    <label FOR="sa">   SA</label>
  
 </div>
 </td>
 </tr>
 
 <tr   reminderType="monthDays" class="hide"  >
 <td>Select day of the month </td>
 <td>:</td><td> 
 
 <div buttongroup="monthDays">
 
    <%for(int k=1;k<32;k++){%>
	<input type="checkbox" name="monthDays" value="<%=k%>" id="monthdays-<%=k%>"/>
	<label for="monthdays-<%=k%>"><%=k%></label>
       <%}%>
 </div>
 </td>
 </tr>
  <tr>
  <td colspan="3"> <input type="button" value="Save" onClick="reminder.saveReminder()"/>&nbsp;<input type="button" value="Cancel" showGrid/></td>
  </tr>
</tbody>
</table>
</form>
</div>

 <div class="grid" id='grid' style="margin-left:500px; min-width:500px; width:500px; min-height:400px; max-height:500px; overflow-y: auto; overflow-x:hidden">
 <table width="500" height="30"  border="0" cellpadding="0" cellspacing="0" id="datatable" style="vertical-align:top" >
 <thead>
  <tr>
   <th class="hide">Reminder Id </th>
   <th width="100">Title </th>
    <th width="100">Reminder </th>
    <th class="hide">Reminder Num</th>
	<th >Reminder Type </th>
	<th>Starts On</th>
	<th>Ends On</th>
	
	<th width="70">Days/Date/Week days </th>
  </tr>
  </thead>
  <tbody>
  <%
  List<Object[]> reminderList=(List<Object[]>)request.getAttribute("reminderList");
  if(!(null==reminderList)){
  for(Object[] reminder:reminderList){
  String mode="";
  mode=modes.get(reminder[2]).toString();
  %>
  <tr   style="text-align:center">
  <td class="hide"><%=reminder[0]%></td>
   <td><%=reminder[1] %></td>
  <td><%=reminder[1] %></td>
  <td class="hide"><%=reminder[2]%></td>
 
    
    <td><%=mode%></td>
	 <td><%=reminder[3]%></td>
	  <td><%=reminder[3]%></td>
	 <td><%=reminder[3]%></td>
  </tr>
  <%}}%>
  </tbody>
</table>

 </div>
<script type="text/javascript">
updateUi();
$("#reminderText").focus();
 
</script>
</body>
</html>