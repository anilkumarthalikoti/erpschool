<%@ page language="java" import="java.util.List,com.java.erp.webapp.database.setup.CourseDetails" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<script type="text/javascript" src="js/admission/admission.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.js"></script>
<script type="text/javascript" src="js/jquery/jquery.multiselect.filter.js"></script>
 
<title></title>
</head>
<%
boolean accRej=false;
String title="Application Form";
if( null!=request.getAttribute("accRej") && request.getAttribute("accRej").toString().equals("true")){
accRej=true;
title="Application Accept/Reject";
}
%>
<body>
<div class="pageTitle">
 
<%=title%>

</div>


<div class="form" style="  border: 0px dotted #999999; float:left  ">
<form name="admissiondetails" id="admissiondetailsForm" method="post" enctype="multipart/form-data">
 
<table width="700"  cellspacing="0" style="margin:0; padding:0 ; line-height:25px; " cellpadding="0" class="form" align="left"  >
 
<tbody>
<tr class="hide">
  <td width="155">Id </td>
  <td width="23">:</td>
<td width="430"><input type="hidden" name="id"  value="-1" validate="notNull#" columnId='0' /></td> 
<td width="90"></td>
</tr>
 <tr>
  <td>Application Status </td>
  <td>:</td><td colspan="2">
  <div buttongroup='applicationStatus'>

          <input type="radio"    name="applicationStatus" value="PENDING" id="pending" checked="checked">
          <label for="pending"> PENDING</label>
          <input type="radio"    name="applicationStatus" value="ACCEPT" id="accept">
          <label for="accept">ACCEPT</label>
          <input type="radio"   name="applicationStatus" value="REJECT" id="reject">
          <label for="reject">REJECT</label>
  </div>
   </td>
  </tr>
  
<tr>
  <td width="155">Application no  </td>
  <td width="23">:</td>
  <td width="430"><input type="text" id="appNo"  name="applicationNo" maxlength="8" placeholder="APPLICATION NO" onKeyUp="admission.fetchApplication();"     columnid='1'/></td>
  <td rowspan="4" align="center" bgcolor="#FFFFFF" valign="top" >  <div style="background:#FFFFFF; border:1px solid #000000; width:80px; height:100px;" onClick="uploadFile(event);">
<img style="width:80px; height:100px; vertical-align:middle;" id="myImage" name="uimg" alt="Upload Image" src="images/uploadimg.png"  />
<input type="hidden" name="fileName"/>
</div>  </td>
</tr>
<tr>
  <td>Student name </td>
  <td>:</td><td><input type="text" id="stdName" name="studentName"   validate="notNull#"  columnId='2'  /></td>
   </tr>
  <tr>
 
  <td>Gender </td>
  <td>:</td><td>
  <div buttongroup="gender" columnId='3' >
      
      
        <input type="radio" name="gender" value="MALE" id="male">
       <label for="male"> MALE</label>
      
     
        <input type="radio" name="gender" value="FEMALE" id="female">
         <label for="female">FEMALE</label>
 
    
  </div>
  
  </td>
   </tr>
  <tr>
  <td>Date of birth</td>
  <td>:</td><td><input id="dob" type="text" name="dob" validate="notNull#" placeholder="DD/MM/YYYY"  columnId='4' datepicker  /></td> </tr>
 
  <tr>
  <td>Joining Batch </td>
  <td>:</td><td colspan="2"><select id="joiningCourse" name="batchId" multiple="multiple"  validate="notNull#"   columnId='5' selectMenu  >
   
  <%
  List<Object[]> courses=(List<Object[]>)request.getAttribute("courseDetails");
  if(null!=courses && !courses.isEmpty()){
  for(Object[] course:courses){
  %>
  
  <option  value="<%=course[6]%>" type="radio" title="<%=course[3]%>-<%=course[4]%>-<%=course[5]%>" ><%=course[3]%>-<%=course[4]%>-<%=course[5]%></option>
  <%}}%>
 
  </select></td>
   </tr>
 
  <tr>
  <td>Father name </td>
  <td>:</td><td colspan="2"><input id="fatherName" type="text" name="fatherName"  validate="notNull#" columnId='6'  /></td> 
  </tr>
  <tr>
  <td>Mother name </td>
  <td>:</td><td colspan="2"><input id="motherName" type="text" name="motherName" validate="notNull#" columnId='7'  /></td> 
  </tr>
 
  <tr>
  <td>Address </td>
  <td>:</td><td colspan="2">
  <textarea id="address" name="address" columnId='11' ></textarea>
 </td> 
  </tr>
  
  <tr>



  <td>Contact no  </td>
  <td>:</td><td colspan="2"><input id="contanctNo" type="text" name="contactNo" validate="notNull#" columnId='9'  /></td> 
  </tr>
  
  <tr>
  <td>Email-Id  </td>
  <td>:</td><td colspan="2"><input id="emailId" type="text" name="emailId"  validate="notNull#" columnId='10'  /></td> 
  </tr>
  <%
  String readonly="readonly";
  if(accRej){
  readonly="";
  }
  %>
 
  <tr>
  
 
  <td colspan="4"> 
  <%if(!accRej){%>
  <input type="button" value="Save" onClick="admission.saveApplication()"/>
  <%}else{%>
  <input type="button" value="Update Application" onClick="admission.acceptRejectApplication()"/>
  <%}%>
  &nbsp;<input type="button" value="Search" showGrid/>
    <input type="file"  style="width:0; height:0"  onChange="updateImage(this)"   name="studentImg"/></td>
  </tr>
</tbody>
</table>
 
 

</form>
</div>

 
 <jsp:include page="/jsp/admission/admissionsearch.jsp"/>
 
<script type="text/javascript">
updateUi();
//$("input").attr("id",$("input").attr("name"));
function uploadFile(){
var id=$("input[name='studentImg']");
 
 
 id.click();
}
function readUrl(input){
if(input.files && input.files[0]){
var reader=new FileReader();
reader.onload=function(e){
 
$("#myImage").attr("src",e.target.result);
 
}
reader.readAsDataURL(input.files[0]);
}

}
function updateImage(obj){
 
 readUrl(obj);
}
$("div[id='grid'] table tbody tr").click(function(){
var id=$(this).attr("applicationNo");
$("#myImage").attr("src","docs/"+id+"/"+id+".jpg");



});

<%if(accRej){%>

$("input[type='text'], select, textarea").attr("disabled","disabled");
$("input[name='applicationNo']").removeAttr("disabled");

<%}%>
 
$("div[class='grid'] table tbody tr").click(function(){
var gender="div[buttongroup='gender'] input[value='"+$(this).find("td:eq(3)").html()+"']";
var course="select#joiningCourse option[value='"+$(this).find("td:eq(5)").html()+"']";
var status="div[buttongroup='applicationStatus'] input[value='"+$(this).find("td:eq(12)").html()+"']";
$(gender).attr("checked","checked");
$(status).attr("checked","checked");
$(course).attr("selected","selected");
 $("div[buttongroup='gender']").buttonset("refresh");
  $("div[buttongroup='applicationStatus']").buttonset("refresh");
  $("select#joiningCourse").multiselect("refresh")
});
</script>
 
</body>
</html>