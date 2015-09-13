<%@ page language="java" import="java.util.*,net.itaem.vo.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
		List<ShowTitleVO> titles = (List<ShowTitleVO>)request.getAttribute("titles") ;
		String speaker = (String) request.getAttribute("speaker") ; 
		String type = (String) request.getAttribute("type") ;
		if(type !=null){
				String speaker1 =  new String(speaker.getBytes("ISO-8859-1"),"utf-8") ;
				speaker =   speaker1 ;
		}
		pageContext.setAttribute("titles",titles) ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/admin_01.css" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
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
	function sendNews(){
		//alert("fasdfas") ;
		window.open("admin/admin_05.jsp?speaker=<%=speaker%>","_self");
	}

</script>
</head>

<body>


<div class="center_div">
<div class="title">新闻列表&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="btn" value="发布新闻" onclick="sendNews() ;"/>
</div>
<div class="table_div">
<table width="100%">
     <c:forEach items="${titles}" var="title">
         <tr>
         <td>${title.getTitle()}</td>
         <td>${title.getDate()}</td>
         <td><a href="NewServlet?type=deletehtxinwen&newId=${title.getNoteId()}&speaker=<%=speaker%>">删除</a></td> 
        </tr>
     </c:forEach>
</table></div>
<div class="hidden"></div>
</div>
</body>
</html>
