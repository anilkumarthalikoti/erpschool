<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" hrf="css/jqplot.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <% 
 List result=(List)request.getAttribute("result");
 List feePayments=(List)result.get(0);
 Vector branchs=(Vector) feePayments.get(0);
 Vector amounts=(Vector) feePayments.get(1);
 
 %>
<script type="text/javascript" src="js/chart/chart.js"></script>
<script type="text/javascript" src="js/chart/barRenderer.js"></script>
<script type="text/javascript" src="js/chart/pieRenderer.js"></script>
<script type="text/javascript" src="js/chart/categoryAxisRenderer.js"></script>
<script type="text/javascript" src="js/chart/pointLabels.js"></script>
<script type="text/javascript">
$("[class='pageTitle']").addClass("ui-widget-header");
$("[class='view'] div").css("height","200px");
 
 $(document).ready(function(){
 
 
 
 
 
 
        plot6 = $.jqplot('studentCount', [[1,2,3,4]], {seriesDefaults:{renderer:$.jqplot.PieRenderer},title:'Student Count'});
  
        var s1 =new Array();
		<% for(Object data:amounts){ %>
		s1.push(<%=data%>);
		<%}%>
 
        var s2 = [7, 5, 3, 2];
        var ticks = new Array();
         <% for(Object data:branchs){ %>
		ticks.push("<%=data%>");
		<%}%>
	
        plot2 = $.jqplot('feeData', [s1], {
		title:'Fee Payments Branch wise',
		 animate: !$.jqplot.use_excanvas,
            seriesDefaults: {
                renderer:$.jqplot.BarRenderer,
				 rendererOptions: {
				varyBarColor: true
				},
                pointLabels: { show: true }
            },
            axes: {
                xaxis: {
                    renderer: $.jqplot.CategoryAxisRenderer,
					
                    ticks: ticks
                }
            }
        });
     
        $('#feeData').bind('jqplotDataClick', 
            function (ev, seriesIndex, pointIndex, data) {
			alert(data);
                $('#info2').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
            }
        );
             
        $('#chart2').bind('jqplotDataUnhighlight', 
            function (ev) {
                $('#info2').html('Nothing');
            }
        );
    });
</script>
<style>
.view{
height:200px;
}
</style>
</head>
<body>
<table width="100%" border="0">
  <tr>
    <td width="350">  <div class="view"  ><div id="feeData"></div></div></td>
    <td width="350"><div class="view"  ><div id="studentCount"></div></div></td>
    <td width="350"> <div class="view"  ><div id="admissionCount"></div></div></td>
  </tr>
  <tr>
    <td><div class="pageTitle">Reminders</div>
      <div class="view"><jsp:include page="reminderView.jsp" /></div></td>
    <td><div class="pageTitle">Annouancement</div>
      <div class="view"  ></div></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</body>
</html>