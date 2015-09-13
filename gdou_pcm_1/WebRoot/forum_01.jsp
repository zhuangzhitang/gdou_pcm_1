<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.itaem.vo.*" %>
<%@ page import="net.itaem.factory.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>拼车论坛</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<link rel="stylesheet" href="css/forum_01.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/datepicker.js"></script>
<script>
$(document).ready(function(e) {
  $("#iframe",window.parent.document).height($("body").height()+10);  

 $('.inputDate').DatePicker({
		format:'Y-m-d',
		date: $('#inputDate').val(),
		current: $('#inputDate').val(),
		starts: 1,
		position: 'right',
		onBeforeShow: function(){
			$('#inputDate').DatePickerSetDate($('#inputDate').val(), true);
		},
		onChange: function(formated, dates){
			$('#inputDate').val(formated);
			$('#inputDate').DatePickerHide();
		}
	});
});
 </script>
<style>
.table_div{
	
	overflow:hidden;
	}
.info_ico{

	background:#383FD8;
	padding-left:1em;
	text-align: left;
	color:white;
	font-weight:bold;
	padding:0.5em;
	}
input[type=submit]{ 
    width:3em;
	height:1.5em;
	background:#383FD8;
	font-size:1em;
	border-radius:0.4em;
 }
 input[type=reset]{ 
    width:3em;
	height:1.5em;
	background:#ccc;
	font-size:1em;
	border-radius:0.4em;
 }
  </style>
 
</head>

<body>

<%
String type = (String)request.getAttribute("seek") ;
int pageNow = 1 ;     //当前的页数
int pageCount = 0 ;   //总页数
int pageSize = 9 ;    //每页展示的条目
List<ShowTitleVO> shownotevos = null ;
if(type != null){
	 shownotevos = (List<ShowTitleVO>)request.getAttribute("showvo");
}else{
    String s_pageNow = (String)request.getAttribute("pageNow") ;  //获得页
	if(s_pageNow !=null){
	pageNow = Integer.parseInt(s_pageNow);
	}
	pageCount = Factory.getNoteDAOInstatnce().getPageCount(pageSize);
    shownotevos = Factory.getNoteDAOInstatnce().getNoteByPage(pageSize,pageNow,0);
}
pageContext.setAttribute("shownotevos", shownotevos ) ;
%>
<div class="center">
<div class="left_div">
<div class="nav_div">
<div class="info_ico">拼车论坛</div>
<ul>
  <li class="selected"><a href="forum_01.jsp">论坛首页</a></li>
  <li><a href=" ShowNoteServlet?type=showmynote">我的帖子</a></li>
  <li><a href="ShowNoteServlet?type=getFatiePower" >发布帖子</a></li>
</ul></div>

<div class="right_div">
 <form name="query" id="query" action="ShowNoteServlet?type=seek" method="post">  
  出发地：&nbsp;&nbsp;&nbsp;<input type="text" name="action_from"/><br /><br />
  目的地：&nbsp;&nbsp;&nbsp;<input type="text" name="action_to" /><br /><br />
    
    出发时间：<input class="inputDate" id="inputDate" name="action_date" value="2014-04-25" /><br /><br />
    <input type="submit" value="查询" />&nbsp;<input type="reset" value="清空"/>
</form>
</div>
</div>

<div class="center_div">
<div class="forum_r_hd">
            <div class="info_list">
                论坛首页
            </div>
        </div>
<div class="table_div">
<div class="subframe_l">
            
        	<ul>
            	<c:forEach items="${shownotevos}" var="shownotevo">
        	          <li>
	        	          <span>[${shownotevo.getDate()}]</span>
					      <a href="ShowNoteServlet?type=shownotecontent&noteid=${shownotevo.getNoteId()}">${shownotevo.getTitle()}</a>
				     </li>
        	    </c:forEach>
           
			      <%
              	for(int i = shownotevos.size() ; i < pageSize ; i++ ){    //如果条目不够9条，将补充空的
              	%>
              		<li></li>
              	<%
              	}
               %> 
            </ul>
       
             <div class="paging_box">
                   <%
             		
      				 if(type == null){      
            	  %>
             	   <a href="ShowNoteServlet?type=fenye&pageNow=<%=(pageNow - 1)>0?(pageNow-1):1 %>">
    			     <span class="back"></span>
    		    	</a>
		              <%
		                 for(int i = 1 ; i <= pageCount ; i ++){
	                  %>
							 <span class="current"> <a href="ShowNoteServlet?type=fenye&pageNow=<%=i %>"><%=i %></a></span>
			
			   	        <% } %>
		                 <a href="ShowNoteServlet?type=fenye&pageNow=<%=((pageNow + 1)<=pageCount)?(pageNow+1):pageNow %>">
		            			 <span class="next"></span>
		                 </a>
		            <%} %>
            
            
            </div>
        </div>

 </div>
 
</div>


<div style="clear:both;"></div>
</div>
</body>
</html>



