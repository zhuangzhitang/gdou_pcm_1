<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.itaem.po.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/article.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>文章</title>

</head>

<body>

<%
	Article article = (Article)request.getAttribute("article") ;
	pageContext.setAttribute("article", article) ;
%>

<div class="center">
 <div class="info_r">
    	<div class="info_r_hd">
        	<div class="info_list">
            	<span id="name">新闻</span>内容
            </div>
        </div>
        <div class="content">
            <h3>${article.getArticleTitle()}</h3>
            <hr />
            <p class="time">发布时间：<span>${article.getArticleDate()}</span>&nbsp;&nbsp;作者：<span>${article.getSpeaker()}</span></p>
            <br />
            <p class="message"> 
                ${article.getArticleContent()}
            </p>
   </div>
   </div>
   <div class="returnback"><a href="NewServlet?type=fenye&pageNow=1" target="iframe">返回新闻列表</a></div>
   <div style="clear:both;">
   </div>
   </div>
</body>
</html>
