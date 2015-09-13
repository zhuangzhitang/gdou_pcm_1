<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="net.itaem.vo.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/new.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>新闻公告</title>
<script type="text/javascript">
$(document).ready(function(e) {
	$("#iframe",window.parent.document).height($("body").height()+10);
	var list = $(".type_list ul li")
    	
	list.click(function(e) {
		
        list.removeClass("selected");
		$(this).addClass("selected");
		$("#name").html($(this).html());
    });
	

});
		
	
	

</script>
</head>

<body>
<%
	
	    int pageCount = (Integer)request.getAttribute("pageCount") ;
	    int pageSize = (Integer)request.getAttribute("pageSize") ;
	    int pageNow = (Integer)request.getAttribute("pageNow") ;
	    List<ShowTitleVO> titles = (List<ShowTitleVO>)request.getAttribute("titles") ;
		pageContext.setAttribute("titles", titles) ;
%>
<div class="center">
	<div class="info_l">
        <div class="type_title">
        	<div class="info_ico">
            新闻公告
            </div>
         </div>
          <div class="type_list">
           	<ul>
                	<li class="selected">新闻</li>
                   <!-- <li>公告</li>  -->
              </ul>
            </div>
        
    </div>
    
    <div class="info_r">
    	<div class="info_r_hd">
        	<div class="info_list">
            	<span id="name">新闻</span>列表
            </div>
        </div>
        <div class="info_r_m">
        	<ul>
         
  	              <c:forEach items="${titles}" var="title">  
  	                     <li><span>[${title.getDate()}]</span>
                           <a href="NewServlet?type=shownotecontent&noteid=${title.getNoteId()}">${title.getTitle()}</a>
                        </li>
                  </c:forEach> 
           
               <%
              	for(int i = titles.size() ; i < pageSize ; i++ ){    //如果条目不够10条，将补充空的
              	%>
              		<li></li>
              	<%
              	}
               %>
            </ul>
        </div>
    </div>
    <div class="paging_box">
        <a href="NewServlet?type=fenye&pageNow=<%=(pageNow - 1)>0?(pageNow-1):1 %>">
    	   <span class="back"></span>
    	</a>
        <%
	        for(int i = 1 ; i <= pageCount ; i ++){
	    %>
	      
	       <a href="NewServlet?type=fenye&pageNow=<%=i %>">
                 <span class="current"><%=i %></span>
           </a>
        
        <% } %>
         
          <a href="NewServlet?type=fenye&pageNow=<%=((pageNow + 1)<=pageCount)?(pageNow+1):pageNow %>">
             <span class="next"></span>
          </a>
    </div>
    <div style="clear:both"></div>
</div>
</body>
</html>
