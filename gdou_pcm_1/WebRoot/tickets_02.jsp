<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="net.itaem.po.*"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订票</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/tickets_02.css" type="text/css" />
<style>

</style>
<script>
$(document).ready(function(){
	$("#buy_ticket").click(function(){
		
		var name=$("#name").val();
		var ID=$("#ID").val();
		var phone=$("#phone").val();
		var short_phone=$("#short_phone").val();
		var pattern=/^\d{15}$|^\d{18}$|^\d{17}[Xx]$/;
		var pattern2=/^1(3[0-9]|5[0-35-9]|8[0235-9])\d{8}$/;
		var pattern3=/^[0-9]*$/;
		if(name==""||name==null){
			alert("姓名不能为空");
			return false;
			}
			
		else if(!pattern.test(ID)){
			alert("身份证格式有误");
			return false;
			}
		else if(!pattern2.test(phone)){
			alert("手机号格式有误");
			return false;
			}
			else if(!pattern3.test(short_phone)){
			alert("短号格式有误");
			return false;
			}
		document.all.form1.submit();	
		
		return true;
		});
		
	$("#btn").click(function(){
		$(".before_info").addClass('active');
		$(".before_div").addClass('active');
		
		});
	})

</script>
<script>
     var xmlHttp;
     function createxmlHttp(){
        if(window.XMLHttpRequest){
        xmlHttp=new XMLHttpRequest();
        }
        else{
          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
     
     }
     function checkhaveuser(commonName){
        createxmlHttp();
        xmlHttp.open("POST","AjaxCommonNameServlet?commonName="+commonName);
        xmlHttp.onreadystatechange=checkUseridCallback;
        xmlHttp.send(null);
        //document.getElementById("hehe").innerHTML="正在验证中。。。";
     
     }
     function checkUseridCallback(){
        if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
        var message=xmlHttp.responseText;
        //alert(message.split("|")[0]);
        document.getElementById("name").value=message.split("|")[0];
        document.getElementById("ID").value=message.split("|")[1];
       document.getElementById("phone").value=message.split("|")[2];
       document.getElementById("short_phone").value=message.split("|")[3];
       } 
        
     }
     }
</script>

</head>

<body>
<div class="center">
<div class="tickets_div">
<div class="ticket_r_hd">
            <div class="info_list"> 
               车票信息 
            </div>
        </div>
<div class="tickets_table">

<table class="table2">
<th>ID号</th>
<th>车次</th>
<th>起始城市</th>
<th>目的城市</th>
<th>发车日期</th>
<th>发车时间</th>
<th>上车地点</th>
<th>车队名称</th>
<th>票价</th>
<th>余票</th>
<%  
   CarNumber car=(CarNumber)request.getAttribute("CarNumber");
   System.out.println(car+"ahdhdshh?????????????????????????????????");
   SimpleDateFormat mat=new SimpleDateFormat("yyyy-mm-dd");
   Calendar cal=Calendar.getInstance();
   cal.setTime(car.getTicketDate());
   String date=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
   String carloc1=(String)request.getAttribute("carlocation");
   String name=new String(carloc1.getBytes("ISO-8859-1"),"utf-8");
	String	carloc2=URLDecoder.decode(name,"utf-8");
	String gocarloc=null;
	if(request.getParameter("type").equals("enter")){
	   gocarloc=carloc2;
	 }
	 else{
	    gocarloc=carloc1;
	 }
	String carid=(String)request.getAttribute("carid");
 %>
<tr>
<td><%=carid %></td>
<td><%=car.getTicketNo() %></td>
<td><%=car.getTicketFrom().split("\\|")[0] %></td>
<td><%=car.getTicketTo() %></td>
<td><%=date %></td>
<td><%=car.getTicketTime() %></td>
<td><%=gocarloc %></td>
<td><%=car.getTicketName() %></td>
<td><%=car.getTicketPrice() %></td>
<td><%=car.getTicketExcept() %></td>
</tr>
</table></div>
<div class="tickets_info">
<%
    String url="OrderTicketServlet?carid="+carid+"&location="+gocarloc;
 %>
<form name="form1" action=<%=url %> method="post">
<div class="table_div2">
<div class="title">乘客信息</div>
<%CommonName com=(CommonName)request.getAttribute("DefultName");
   %>
<table>
<tr ><td>乘客姓名：<input type="text" name="truename" id="name" value=<%=com.getTrueName() %>></td></tr>
<tr><td>身份证号：<input type="text"  name="idcard" id="ID" value=<%=com.getIdCard() %>></td></tr>
<tr><td>联系电话：<input type="text" name="phone" id="phone" value=<%=com.getPhone() %>></td></tr>
<tr><td>短号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="shortphone" id="short_phone" value=<%=com.getShortPhone() %>></td></tr>
<tr><td>票数：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <select  name="num" style="width:160px">
        <option value="1">1张</option>
        <option value="2">2张</option>
        </td></tr>
</table></div>
<div class="name_selected">
<div class="title">选择常用姓名</div>

<table>
<% 
  List<String> list=(List<String>)request.getAttribute("commonNameList");
  for(int i=0;i<list.size();i++){
 %>
<tr><td><input type="radio" value=<%=list.get(i)%> onclick="checkhaveuser(this.value)"/><%=list.get(i)%></td></tr>
<%
   }
 %>
</table></div>
<div class="button_div">
<input type="submit" id="buy_ticket" value="我已核对订单信息，确认订票"  onclick="return confirm('您确认订票吗？');"/></div></form>
<div style="clear:both;"></div>
</div>



</div>
<div class="before_div"></div>
<div class="before_info">
<div class="title"><h3>购票须知</h3></div>
<div class="before_content">
	1.用户可以为自己购票，也可以为他人购票，但均须准确填写乘车人的真实有效身份证件信息<br/>
	2.用户使用虚假身份证件购买车票或进站乘车的，后果自负。<br/>
	3.本须知中的部分条款，可能因具体情况调整，请关注网站及车队公告。
</div>
<div class="button_div2"><input type="button" id="btn" value="确定"/></div></div> 
</div>
</body>
</html>
