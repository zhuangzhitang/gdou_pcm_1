<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String speaker = (String) request.getParameter("speaker") ;
   String speaker1 =  new String(speaker.getBytes("ISO-8859-1"),"utf-8") ;
  
%>

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
	text-align:center;
	
	}
table th{
	text-align:left;
	}
input[type=text]{
	height:25px;
	 width:200px;
	}
</style>
<script>

</script>
</head>
<p><%=speaker1 %></p>

<body>
<form action="../NewServlet?type=htfabuxinwen&speaker=<%=speaker1%>" method="post">
<div class="center_div">
<div class="title">发布新闻</div>
<div class="table_div">
<table width="100%">
<tr><td><font style="font-weight:bold">标题：</font><input type="text"  name="newtitle"/></td></tr>
<tr><td><textarea name="newcontent" rows="10" cols="68"></textarea></td></tr>
<tr><td><input type="submit" value="发布" /></td></tr>
</table></div>
<div class="hidden"></div>
</div>
</form>
</body>
</html>
