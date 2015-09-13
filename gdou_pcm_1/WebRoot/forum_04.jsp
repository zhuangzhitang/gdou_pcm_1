<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="net.itaem.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>
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

	 function deletenote(id){
		window.open("ShowNoteServlet?type=delmynote&noteId="+id,"_self");
	}
 </script>

<style>

  </style>
 
</head>

<body>

<%
List<ShowTitleVO> shownotevos  = (List<ShowTitleVO>)request.getAttribute("showmynotes") ;
pageContext.setAttribute("shownotevos",shownotevos) ;
%>

<div class="center">
<div class="left_div">
<div class="nav_div">
<div class="info_ico">拼车论坛</div>
<ul>
  <li ><a href="ShowNoteServlet?type=fenye&pageNow=1">论坛首页</a></li>
 <li class="selected" ><a href=" ShowNoteServlet?type=showmynote">我的帖子</a></li>
  <li><a href="ShowNoteServlet?type=getFatiePower" >发布帖子</a></li>
</ul></div>

</div>

<div class="center_div">
<div class="forum_r_hd">
            <div class="info_list">
                我的帖子
            </div>
        </div>
<div class="table_div">
<div class="subframe">
        	<table width="100%">
            <tr><th>标题</th><th>时间</th><th>操作</th></tr>
              <c:forEach items="${shownotevos}" var="shownotevo">
                    <tr>
	                     <td><a href="ShowNoteServlet?type=shownotecontent&noteid=${shownotevo.getNoteId()}">${shownotevo.getTitle()}</a></td>
	                     <td>[${shownotevo.getDate()}]</td>
	                       <td><input type="button" value="删除" onclick="deletenote(${shownotevo.getNoteId()});"/></td>
	                </tr>
              </c:forEach>
            </table>
             <div style="clear:both"></div>
        </div>

 </div>
 
</div>

<div style="clear:both;"></div>
</div>
</body>
</html>


