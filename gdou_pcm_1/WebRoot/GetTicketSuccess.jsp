<%@page import="net.itaem.po.*"%>
<%@page import="java.text.SimpleDateFormat"%>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>查询订票</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/datepicker.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<link rel="stylesheet" href="css/tickets_01.css" type="text/css" />

<style>
table{
margin-top:1em;
border:1px solid #ccc;
	margin-left: 14em;
}
input[type=button]{
	width:10em;
	height:1.5em;
	background:#383FD8;
	font-size:1em;
	border-radius:0.4em;
	color:white;
}
</style>
</head>

<body>
<div class="center">
<h3>订票成功</h3>
<div class="tickets_div">
<% String s=(String)request.getAttribute("isSuccess"); %>
     <center><%=s %></center>
<%
if(s.equals("订票成功")){
  CarNumber car=(CarNumber)request.getAttribute("carnumber");
  SimpleDateFormat mat=new SimpleDateFormat("yyyy-mm-dd");
   Calendar cal=Calendar.getInstance();
   cal.setTime(car.getTicketDate());
   String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
   %>
     <table align="center">
           <tr>
             <td>起始城市</td>
             <td><%=car.getTicketFrom().split("\\|")[0] %></td>
           </tr>
            <tr>
             <td>到达城市</td>
             <td><%=car.getTicketTo() %></td>
           </tr>
           <tr>
             <td>上车地点</td>
             <td><%=(String)request.getAttribute("location")%></td>
           </tr>
           <tr>
             <td>上车日期</td>
             <td><%=date %></td>
           </tr> 
           <tr>
             <td>上车时间</td>
             <td><%=car.getTicketTime() %></td>
           </tr>
           <tr>
             <td>车队名称</td>
             <td><%=car.getTicketName() %></td>
           </tr>
            <tr>
             <td>乘客姓名</td>
             <td><%=(String)request.getAttribute("truename") %></td>
           </tr>
           <tr>
             <td>手机号码</td>
             <td><%=(String)request.getAttribute("phone") %></td>
           </tr>
           <tr>
             <td>票数</td>
             <td><%=request.getAttribute("num") %></td>
           </tr>   
     </table>

<%
   }
 %>
     <a href="FindTicketServlet?type=show"><input type="button" align="bottom" align="right" value="返回继续查询票务"/></a>
</div></div>
</body>
</html>


