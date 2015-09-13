<%@ page language="java" import="java.util.*,net.itaem.po.*,net.itaem.factory.*" pageEncoding="utf-8"%>
<%
    int teamid = (Integer)request.getSession().getAttribute("teamid") ;   //车队的id号
	List<CarNumber> numbers = null ;
	numbers = Factory.getCarNumberDAOInstance().showCarNumList(teamid) ;
	Iterator<CarNumber> iter = numbers.iterator() ;
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/admin_01.css" />
<link type="text/css" rel="stylesheet" href="../css/admin_02.css" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<title>票务查询</title>
<style>

</style>

<script>
$(document).ready(function(){
		
	$("#btn").click(function(){
		$(".info").addClass('active');
		$(".info_div").addClass('active');
		
		});
	
	$("#btn2").click(function(){
		$(".info").removeClass('active');
		$(".info_div").removeClass('active');
		var checi = document.mainform.checi.value ;
		var from = document.mainform.from.value ;
		var to = document.mainform.to.value ;
		var date = document.mainform.date.value ;
		var time = document.mainform.time.value ;
		var price = document.mainform.price.value ;
		var count = document.mainform.count.value ;
		var address = document.mainform.address.value ;
		//from = java.net.URLDecoder.encodes(from.value,"utf-8");
		//alert("内容"+checi+from + to + date + time + price + count + address) ;
	//	window.open("../PiaoWuServlet?type=sendCar","_self");
	     fabucheci("checi="+checi+"&from="+from+"&to="+to+"&date="+date+"&time="+time+"&price="+price+"&count="+count+"&address="+address)
	    
		});
		
	$("#btn3").click(function(){
		$(".info").removeClass('active');
		$(".info_div").removeClass('active');
		
		})
	})
</script>

<script type="text/javascript">
	var xmlHttp ;
	function createXMLHttp(){
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest() ;
		}else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
		}
	}
	function  fabucheci(id){
		createXMLHttp() ;
		if(xmlHttp == "[object]"){
		xmlHttp.open("POST","../PiaoWuServlet?type=sendCar&"+id+"&xmlHttp="+"1") ;
			//	alert(xmlHttp) ;
		}
	
		xmlHttp.open("POST","../PiaoWuServlet?type=sendCar&"+id) ;
	//	alert("../PiaoWuServlet?type=sendCar&"+id+"&xmlHttp="+"1");
		xmlHttp.onreadystatechange = checkFabuCheciBack ;
		xmlHttp.send(null) ;
	}
	function deletecheci(id){
		createXMLHttp() ;
	    xmlHttp.open("POST","../PiaoWuServlet?type=deletecheci&carId="+id) ;
		xmlHttp.onreadystatechange = checkdeleteCheciBack ;
		xmlHttp.send(null) ;
	    
		
	}
    function checkFabuCheciBack(){
    	  if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){ 
				var text = xmlHttp.responseText ;
				//alert("回调信息s:"+text ) ;
				if(text == "true"){
					alert("发布成功") ;
				    window.open("admin_02.jsp","_self");
				}else {
					alert("发布失败") ;
				}
			}
		}
    }
	function checkdeleteCheciBack(){
	  if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){ 
				var text = xmlHttp.responseText ;
				//alert("回调信息s:"+text ) ;
				if(text == "true"){
				    window.open("admin_02.jsp","_self");
					alert("删除成功") ;
				}else {
					alert("删除失败") ;
				}
			}
		}
	}
	
	function seek(id){
		window.open("../PiaoWuServlet?type=lookcheciqpMsg&carId="+id,"_self");
	}
	
</script>

</head>

<body>

<div class="center_div">
<div class="title">车次列表</div>
<div class="table_div">
<table width="100%">
<th>车次</th>
<th>起始城市</th>
<th>下车城市</th>
<th>发车日期</th>
<th>发车时间</th>
<th>票价</th>
<th>票数</th>
<th>上车地点</th>
<th>操作</th>

  <%
          	   while(iter.hasNext()){
          	   	CarNumber num = (CarNumber)iter.next() ;
          	    if(num.getTicketType() == 1){
          %>
          
          <tr>
               <td><%=num.getCarId()%></td>
               <td><%=num.getTicketFrom().split("\\|")[0] %></td>
               <td><%=num.getTicketTo() %></td>
               <td><%=num.getTicketDate() %></td>
               <td><%=num.getTicketTime() %></td>
               <td>80</td>
               <td>40</td>
               <td>海大</td>
               <td><input type="button" value="查询" onclick="seek(<%=num.getCarId() %>)"/>&nbsp;
            <%
    	        Date date = num.getTicketDate() ;
				long cardate = date.getTime() ;
				long nowdate = new Date().getTime() ;
				if(cardate<nowdate){
				%>
				<input type="button" value="删除" onclick="deletecheci(<%=num.getCarId() %>)"/>
				<% 
				}
                 %>     
            </td>
             </tr>
           <% 
          	   }}
           %>
           

</table>
<div class="car_div">
<input type="button" id="btn" value="发布车次" /></div>
</div>
<div class="hidden"></div>

<div class="info_div"></div>
<form action="" name="mainform">
<div  class="info">
<input type="text" name="checi"/>
<input type="text" name="from"/>
<input type="text" name="to"/>
<input type="text" name="date"/>
<input type="text" name="time"/>
<input type="text" name="price"/>
<input type="text" name="count"/>
<input type="text" name="address"/>
<input type="button" id="btn2" value="保存" />
<input type="button" id="btn3" value="取消" />
</div>
</form>
</div>
</body>
</html>
