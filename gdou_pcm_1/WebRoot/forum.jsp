<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'forum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!---->
	<link rel="stylesheet" type="text/css" href="css/forum_index.css">
	<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<style type="text/css">
	body{height:312px;}
.paging_box{
	margin-bottom:0.5em;
	float:right;
	margin-top:0.5em;
	}
</style>
<script type="text/javascript">
$(document).ready(function(e) {
	var refresh= $("#iframe",window.parent.document).height($("body").height()+10);
	
	var list = $(".type_list ul li")
  
        list.click(function(e) {
		
        list.removeClass("selected");
		$(this).addClass("selected");
		
   	 });
     /*list.each(function(index) {
		 $(this).click(function() {
			 
            $("div.contentin").removeClass("contentin");
			$("div.forum_right").eq(index).addClass("contentin");
			$("#iframe",window.parent.document).height($("body").height()+10);
        });
		 
		  });	*/
});
	
	
	

</script>

  </head>
  
  <body>
    <div class="center">
	<!--左边导航-->
	<div class="forum_list">
        <div class="forum_title">
          <div class="info_ico">拼车论坛</div>
        </div>
        <div class="type_list">
            <ul>
                <li  class="selected"><a href="forum_1.jsp" target="iframe1">论坛首页</a></li>
                <li><a href="forum_2.jsp" target="iframe1">我的帖子</a></li>
                <li><a href="forum_3.jsp" target="iframe1">发布帖子</a></li>
            </ul>
        </div>
        
    </div>
   <div class="forum_right">
   
 	  <iframe name="iframe1" id="iframe1" src="forum_1.jsp" frameborder="0" width="690px" height="280px" scrolling="no"></iframe>
   </div>
   <div style="clear:both"></div>
</div>
  </body>
  </html>
