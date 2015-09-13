<%@ page language="java" import="java.util.*,net.itaem.po.*,net.itaem.factory.*" pageEncoding="utf-8"%>
<%
   
   int teamId =(Integer)request.getSession().getAttribute("teamid") ;
   Team team  = Factory.getTeamMsgDAOInstance().getTeamMsgById(teamId);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台首页</title>
<link type="text/css" rel="stylesheet" href="css/admin.css" />
<script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$(".left_div ul li a").click(function(){
		$(".left_div ul li a").removeClass('active');
		$(this).addClass('active');
		});
		
	})
</script>

<style>

</style>

</head>

<body>
<div class="container">
<div class="header"><img src="image/admin.jpg" width="950" height="158" /></div>
<div class="center">
<div class="left_div">
<ul>
<li ><a href="admin/admin_01.jsp" target="iframe" class="active">首页</a></li>
<li><a href="admin/admin_02.jsp" target="iframe">票务管理</a></li>
<li><a href="NewServlet?type=houtaixinwen&speaker=<%=team.getTeamName()%>" target="iframe">新闻公告</a></li></ul></div>
<div class="center_div">
<iframe name="iframe" id="iframe" scrolling="auto" frameborder="0" src="admin/admin_01.jsp" width="100%" height="455"></iframe></div>
<div class="hidden"></div>
</div>
<div class="footer">
        <hr />
        <p>版权所有&copy;2014 广东海洋大学 实验基地 ITAEM 团队</p>
        </div>

</body>
</html>
