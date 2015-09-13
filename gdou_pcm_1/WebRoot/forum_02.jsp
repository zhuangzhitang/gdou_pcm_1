<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>
<title>发帖子</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<link rel="stylesheet" href="css/forum_01.css" type="text/css" />
<link rel="stylesheet" href="css/forum_02.css" type="text/css" />
<link rel="stylesheet" href="css/datepicker.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/datepicker.js"></script>
<script>
$(document).ready(function(e) {
   $("#iframe",window.parent.document).height($("body").height()+20); 

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

</style>
</head>

<body>
<div class="center">
<div class="left_div">
<div class="nav_div">
<div class="info_ico">拼车论坛</div>
<ul>
  <li ><a href="ShowNoteServlet?type=fenye&pageNow=1">论坛首页</a></li>
  <li><a href=" ShowNoteServlet?type=showmynote">我的帖子</a></li>
  <li class="selected"><a href="ShowNoteServlet?type=getFatiePower" >发布帖子</a></li>
</ul></div></div>

<div class="center_div">
<div class="forum_r_hd">
            <div class="info_list">
                发布帖子
            </div>
        </div>
        
<div class="post">
 <form action="ShowNoteServlet?type=createnote" method="post">
<table>
<tr class="tr1" ><span class="span1">标题:</span><input type="text" name="notetitle" id="title"/></tr>
<tr>
<td >出发地：<input type="text" name="actionfrom" /></td>
<td>目的地：<input type="text" name="actionto" /></td>
<td>出发时间：<input class="inputDate" id="inputDate" name="actiondate" value="2014-04-25" /></td>
</tr>
</table>
<div class="content_div">
<span>内容：</span><br />
<textarea rows="10" cols="76" style="width:550px;height:180px" name="notecontent" id="content"></textarea><br /><br />
<input type="submit" value="发布" style="width:50px"/>
</div>
</form>
</div></div>

 <div style="clear:both"></div>
</div>
</body>
</html>

