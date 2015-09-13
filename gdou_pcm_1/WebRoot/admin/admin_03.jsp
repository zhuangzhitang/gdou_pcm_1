<%@ page language="java" import="java.util.*,net.itaem.vo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/admin_01.css" />
<title>车次</title>
<style>
*{
	margin:0px;
	padding:0px;
}

.table_div{
	width:100%;
	margin-top:10px;
	}
	
table {
	font-size:0.9em;
	}
table th{
	text-align:left;
	}
</style>
<script type="text/javascript">
	var xmlHttp ;
	function createXMLHttp(){
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest() ;
		}else {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP") ;
		}
	}
	
	function CheckIsSuccess(id){
		createXMLHttp() ;
	    xmlHttp.open("POST","PiaoWuServlet?type=printTicket&carId="+id) ;
		xmlHttp.onreadystatechange = checkMsgback ;
		xmlHttp.send(null) ;
	    
		
	}
	function sendNews(id){
	    var msg = document.all("newMsg");
	    msg.value = window.prompt(msg.value,"消息内容");
	    createXMLHttp() ;
	  //  alert(msg.value);
	    if(msg.value == null || msg.value == ""){
	    	return ;
	    }
	    xmlHttp.open("POST","PiaoWuServlet?type=sendNew&carId="+id+"&msg="+msg.value) ;
		xmlHttp.onreadystatechange = checkSendNewsBack;
		xmlHttp.send(null) ;
		
	    
	}
	
	function CheckLaHei(id){
		createXMLHttp() ;
		xmlHttp.open("POST","PiaoWuServlet?type=lahei&userid="+id) ;
		xmlHttp.onreadystatechange = checkLAHeiMsgBack ;
		xmlHttp.send(null) ;
	}
	
	function checkSendNewsBack(){
	  if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){ 
				var text = xmlHttp.responseText ;
				// alert("回调信息s:"+text ) ;
				if(text == "true"){
					alert("发布信息成功") ;
				}else {
					alert("发布信息失败,请重新发送") ;
				}
			}
		}
	}
	function checkLAHeiMsgBack(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){ 
				var text = xmlHttp.responseText ;
				// alert("回调信息s:"+text ) ;
				if(text == "true"){
					alert("拉黑成功") ;
				}else {
					alert("该用户已经被拉黑") ;
				}
			}
		}
	
	}
	function checkMsgback(){
	  
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){ 
				var text = xmlHttp.responseText ;
				// alert("fdfas:"+text ) ;
				if(text == "true"){
					alert("票务打印成功,文件存放在C盘中的：1.xls") ;
				}else {
					alert("票务打印失败") ;
				}
			}
		}
	}
	
</script>
</head>

<body>
<% 
    String id = (String)request.getAttribute("carId") ;
	List<ShowDingPiaoMsgVO>  showvo =(List<ShowDingPiaoMsgVO>) request.getAttribute("showDPMsg") ; //显示车次订票信息
	pageContext.setAttribute("showvo", showvo) ;
%>
<div class="center_div">
<div class="title">用户订单信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="发布消息" onclick="sendNews(<%=id%>);"/>
<input type="button" value="打印票务" onclick="CheckIsSuccess(<%=id%>);"/>
<input type="hidden" value="消息内容" name="newMsg"/>
</div>
<div class="table_div">
<table width="100%">
<th>真实姓名</th>
<th>身份证号</th>
<th>手机号</th>
<th>短号</th>
<th>订票数</th>

<th>操作</th>
	<c:forEach items="${showvo}" var="vo">
		<tr>
	        <td>${vo.getName()}</td>
	        <td>${vo.getIdcard()}</td>
	        <td>${vo.getPhone()}</td>
	        <td>${vo.getShortphone()}</td>
	        <td>${vo.getTicket_num()}</td>
	        <td><input type="button" value="拉黑" onclick="CheckLaHei(${vo.getUser_id()});"/></td>
      </tr>
	</c:forEach>
</table></div>
<div class="hidden"></div>
</div>
</body>
</html>
