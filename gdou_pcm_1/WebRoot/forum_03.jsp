<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.itaem.po.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/forum_01.css" />
<link rel="stylesheet" type="text/css" href="css/forum_03.css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<title>帖子内容</title>
<style>
	
</style>
<script>
$(document).ready(function(e) {
	 $("#iframe",window.parent.document).height($("body").height()+20);

})

/* function getliuyanid(id){
 	   document.location.hash= "liuyan" ;
 	   window.location.reload(true);
 	   parentkey = id ;
 	
 		} */
</script>
</head>

<body>
<%
	Note note = (Note) request.getAttribute("showNoteContent") ;
	List<LiuYan> liuyans  =(List<LiuYan>) request.getAttribute("liuyans") ;  //拿到所有的留言
    pageContext.setAttribute("note",note);
    pageContext.setAttribute("liuyans",liuyans) ;
    int i = 1 ;    //留言回复的条数
    int parentkey  = 0  ;   //父亲
%>
<div class="center">
<div class="left_div">
<div class="nav_div">
<div class="info_ico">拼车论坛</div>
<ul>
  <li class="selected" ><a href="ShowNoteServlet?type=fenye&pageNow=1">论坛首页</a></li>
  <li><a href=" ShowNoteServlet?type=showmynote">我的帖子</a></li>
  <li ><a href="ShowNoteServlet?type=getFatiePower" >发布帖子</a></li>
</ul></div></div>

<div class="center_div">
<div class="forum_r_hd">
            <div class="info_list">
                帖子内容
            </div>
        </div>

<div class="postcontent">

<div class="top_div">
<div class="title"><span>${note.getNoteTitle()}</span><span class="time">${note.getInsertTime()}&nbsp;&nbsp;&nbsp;</span></div>
<div class="place">
<table>
<tr><td>出发地：<span>${note.getActionFrom()}</span></td>
     <td>目的地：<span>${note.getActionTo()}</span></td>
     <td>活动时间:<span>${note.getTime()}</span></td></tr></table>
</div>
<div class="post_content"><p> <%=note.getNoteContent() %></p></div>
 
</div>

<div class="center_div2">
  
  <c:forEach items="${liuyans}" var="liuyan">
     <div class="title2">
         <p>&nbsp;&nbsp;&nbsp;<%=i++%>楼 ${liuyan.getCreater()} ${liuyan.getInsertTime()}发表<input type="button" name="button" style="width:50px" id="button" value="回复" onclick="getliuyanid(${liuyan.getLiuYanId()});" /></p> 
      </div>
    <div class="img">
		 <table>
			 <tr>
		        <td>
		           ${liuyan.getLiuYanContent()}
		        </td>
		     </tr> 
		 </table>
    </div>   
  </c:forEach>
 </div>
 
<div class="bottom_div">
 <form action="ShowNoteServlet?type=createliuyan" method="post">
<div class="opition">
<div class="title2"><p><font style="font-weight:bold">&nbsp;&nbsp;&nbsp;<a name="liuyan">发评论</a></font></p> </div>
<div class="opition_content">
&nbsp;&nbsp;&nbsp;用户名：<input type="text" name="username" /><span></span><br />
&nbsp;&nbsp;&nbsp;评论内容：<br />
&nbsp;&nbsp;&nbsp;<textarea rows="5" cols="70" name="liuyancontent"></textarea><br /><br />
&nbsp;&nbsp;&nbsp;
<input type= "hidden" name="liuyanid" value=<%=parentkey%>>
<input type= "hidden" name="noteid" value=${note.getNoteId()}>
<input type="submit" value="发表" />
</div>
</div>
</form>
</div>

</div>
</div>
<div style="clear:both"></div>
</div>

</body>
</html>




