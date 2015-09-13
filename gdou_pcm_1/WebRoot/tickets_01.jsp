 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
<script>
$(document).ready(function(e) {
    

 $('.inputDate').DatePicker({
		format:'Y-m-d',
		date: $('#inputDate').val(),
		current: $('#inputDate').val(),
		starts: 1,
		position: 'right',
		onBeforeShow: function(){
			$('#inputDate').DatePickerSetDate($('#inputDate').val(), true);
		},
		onChange: function(formated, dates){
			$('#inputDate').val(formated);
			$('#inputDate').DatePickerHide();
		}
	});
});
   
 </script>
<style>
.center{
	width:913px;
	margin-top:0.8em;
	/*border-radius:0.5em;*/
	padding:1em 1em;
	  
	}
</style>
</head>

<body>
<div class="center">
<h3>网上购票</h3>
<div class="tickets_div">
<div class="tickets_table">
<form action="FindTicketServlet?type=FirstPage" method="post">
<table>

<tr >
<td >始发地：&nbsp;&nbsp;&nbsp;&nbsp;<select id="start" name="fromcity" style="width:160px">
   <option value="${fromcity}" selected>${fromcity}</option>
  
     <c:forEach items="${cityVO.fromCity}" var="fromcity">
        <option value="${fromcity}">${fromcity}</option>
     </c:forEach>
 
  </select></td>
<td>目的地：&nbsp;&nbsp;&nbsp;&nbsp;<select id="end" name="tocity" style="width:160px">
 <option value="${tocity}" selected>${tocity}</option>
     <c:forEach items="${cityVO.toCity}" var="toCity">
             <option value="${toCity}">${toCity}</option>
         </c:forEach>
    </select></td>
</tr>
<tr>
  <c:if test="${param.xianshi=='find'}">
    <td>发车日期：<input class="inputDate" id="inputDate" value="${date}"  name="date"/></td>
</c:if>
 <c:if test="${param.xianshi=='show'}">
     <td>发车日期：<input class="inputDate" id="inputDate" value="${date}"  name="date"/></td>
 </c:if>
 
<td>车队名称：<select id="car_name" name="name" style="width:160px">
<option value="${name}" selected>${name}</option>
   
       <c:forEach items="${cityVO.team_name}" var="team_name">
          <option  value="${team_name}">${team_name}</option>
        </c:forEach>
   </select></td>
   </tr>
</table>

</div>
<div class="query_div"><input type="submit" id="query" value="查询" /></div>
</form>
<c:if test="${param.xianshi=='find'}">
<div class="tickets_table2">
<table class="table2">

   <c:if test="${fn:length(list_Page)==0}">
         <center>对不起，暂时没有符合您要求的车次</center>
   </c:if>
  
     <c:if test="${fn:length(list_Page)>0}">
    <tr>
       <td width="41px" align="left">ID号</td>
       <td width="49px" align="left">车次</td>
       <td width="83px" align="left">起始城市</td>
       <td width="84px" align="left">目的城市</td>
       <td width="98px" align="left">发车日期</td>
       <td width="83px" align="left">发车时间</td>
       <td width="180px" >上车地点</td>
       <td width="100px" align="left">车队名称</td>
       <td width="55px" align="left">票价</td>
       <td width="43px" align="left">余票</td>
        <td width="65px" align="left">操作</td>
</tr>

  
  
<c:forEach items="${list_Page}" var="tic">
<tr><form action="GetTicketServlet" method="post"><table><tr>
<td width="41px">${tic.car_id}<input type="hidden" name="carid" value=${tic.car_id}></td>
<td width="49px">${tic.ticket_no}</td>
<c:forTokens items="${tic.ticket_from}" delims="|" var="con" end="0">
    <td width="83px">${con}</td>
 </c:forTokens>
<td width="84px">${tic.ticket_to}</td>
<td width="98px">${tic.ticket_Date}</td>
<td width="83px">${tic.ticket_time}</td>
<td width="180px">
<c:forTokens items="${tic.ticket_from}" delims="|" var="con" begin="1" end="1">
   <input name="carlocation" type="radio" value=${con} checked="checked"/>${con}
 </c:forTokens>


 <c:forTokens items="${tic.ticket_from}" delims="|" var="con" begin="2">
   <input name="carlocation" type="radio" value=${con}>${con}</input>
</c:forTokens>
 </td>
<td width="100px">${tic.ticket_name}</td>
<td width="55px">${tic.ticket_price}</td>
<td width="43px">${tic.ticket_yupiao}</td>
<td width="65px"><input type="submit" value="购票" onclick=""/></td></tr></table></form></tr>

</c:forEach>
</table></div>
<div class="paging_box">
                <span class="back"></span>
                <% 
                  int num=(Integer)request.getAttribute("pagenumber");
                  List<Integer> list=new ArrayList<Integer>();
                  for(int i=1;i<=num;i++){
                    list.add(i);
                   }
                     pageContext.setAttribute("a",list);
                 %>
                 <c:forEach items="${a}" var="page">
                 <a href="FindTicketServlet?type=otherPage&number=${page}&fromcity=${fromcity}&tocity=${tocity}&date=${date}&name=${name}"><span class="current">${page}</span></a>
                 </c:forEach>
                <span class="next"></span>
          
            </div>
        </c:if>
   </c:if>

</div></div>
</body>
</html>


