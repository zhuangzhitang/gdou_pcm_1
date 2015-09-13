<%@ page language="java" import="java.util.*,net.itaem.factory.*,net.itaem.po.*" pageEncoding="utf-8"%>
<%       
		String teamId = (String) request.getParameter("teamId") ;
		int id = 1 ;
		if(teamId !=null){
			id = Integer.parseInt(teamId) ;
		}
		Team team  = Factory.getTeamMsgDAOInstance().getTeamMsgById(id);
		String imagepath = team.getTeamImage() ;
		String realpath = imagepath.substring(imagepath.indexOf(".")+3) ;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/carshow.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>车队展示</title>
</head>

<body>
<div class="center">
		<div class="top">
        	<div class="pic"><img src="<%=realpath %>" width="300" height="199" /></div>
            <div class="detail">
            	<h3>车队名称：<span><%=team.getTeamName() %></span></h3>
                <h3>简介:</h3>
                <p><%=team.getTeamIntroduce() %></p>
                
            </div>
            <div style="clear:both"></div>
            <div class="preferential">
            	<h3>优惠信息：</h3>
                <p><%=team.getTeamMessage() %></p>
            </div>
        </div>


<div style="clear:both"></div>
</div>
</body>
</html>
