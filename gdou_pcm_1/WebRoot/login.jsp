<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="image/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="renderer" content="webkit" />

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<!-- <link type="text/css" rel="stylesheet" href="css/style.css" /> -->
<link type="text/css" rel="stylesheet" href="css/login.css" />
<title>会员登录</title>

 <script>
$(document).ready(function(){
	$("#login").click(function(){
		$(".login_div").addClass('active');
		$(".login").addClass('active');
		
		});
	$("#close").click(function(){
		$(".login_div").removeClass('active');
		$(".login").removeClass('active');
		});
		
	$("#login_button").click(function(){
		var user_name=$("#user_name").val();
		var user_password=$("#user_pwd").val();
		var user_identify=$("#user_identify").val();
		if(user_name==""||user_name==null){
			alert("用户名不能为空！");
			return false;
			}
		else if(user_password==""||user_password==null){
			alert("密码不能为空！");
			return false;
			}
		else if(user_identify==""||user_identify==null){
			alert("验证码不能为空！");
			return false;
			}
			
			else{
		$(".login_div").removeClass('active');
		$(".login").removeClass('active');
		document.all.form1.submit();
		}
		});
	})
	function refresh(obj) {
		obj.src = "VerificationCodeServlet";
	}
   
  
  
 
   
</script> 

<style>
h3 {
	width:913px;
	margin:0;
	font-size:1em;
	padding:0.5em;
	float:left;
	color:white;
	background:#383FD8;
}
 input[type=submit]{ 
    width:3em;
	height:1.5em;
	background:#383FD8;
	font-size:1.3em;
	border-radius:0.4em;
 }
input[type=reset]{ 
    width:3em;
	height:1.5em;
	background:#ccc;
	font-size:1.3em;
	border-radius:0.4em;
 }
</style>  
</head>

<body>
<div class="center">
<h3>欢迎您登录会员</h3>
<div class="login_div">
<div class="login">
<c:choose>
<c:when test="${param.tiaozhuang=='goumai'}">
  <form name="form1" type="validate" action="EnterServlet?tiao=${param.tiaozhuang}&carid=${param.carid}&carlocation=${param.carlocation}" id="d"  method="post">
 </c:when>
 <c:otherwise>
 <form name="form1" type="validate" action="EnterServlet?tiao=${param.tiaozhuang}" id="d"  method="post">
 </c:otherwise>
 </c:choose>
		
       
		<br /><br/><br />
		<table width="85%" border="0">
		 
         <c:if test="${param.type=='register'}" var="res1" scope="page">
		       <tr><td><span>${isSuccess}</span></td></tr>
		    
		
		<tr>
			<td class="labels">用户名:</td><td><input type="text" id="user_name" name="username" valType="required" msg="<font color=red>*</font>用户名不能为空" /></td>
		</tr>
		
        <tr>
			<td class="labels">密码:</td><td><input type="password" name="Password" id="user_pwd" valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
        <tr>
			<td class="labels" >验证码:</td><td><input type="text" name="VerificationCode" id="user_identify" valType="required" msg="<font color=red>*</font>密码不能为空" />
			<span><img src="VerificationCodeServlet"
						    onclick="javascript:refresh(this);" alt="" width="75" height="24" /></span>
			
			</td>
		</tr>
		</c:if>
		
		     
		    <c:if test="${param.type=='enter'}" var="res2" scope="page">
		
		<tr>
			<td class="labels">用户名:</td><td><input type="text" id="user_name" name="username" valType="required" msg="<font color=red>*</font>用户名不能为空" /></td>
		</tr>
		
        <tr>
			<td class="labels">密码:</td><td><input type="password" name="Password" id="user_pwd" valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
        <tr>
			<td class="labels">验证码:</td><td><input type="text" name="VerificationCode" id="user_identify" valType="required" msg="<font color=red>*</font>密码不能为空" />
			<span><img src="VerificationCodeServlet"
						    onclick="javascript:refresh(this);" alt="" width="120" height="30" /></span>
			
			</td>
		</tr>
		</c:if>
		
		
		 <c:if test="${param.type=='return'}" var="res3" scope="page">
		 <tr>
			<td class="labels">用户名:</td><td><input type="text" id="user_name" name="username" value=${username} valType="required" msg="<font color=red>*</font>用户名不能为空" /></td>
		</tr>
		
        <tr>
			<td class="labels">密码:</td><td><input type="password" name="Password" id="user_pwd" value=${Password}  valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
        <tr>
			<td class="labels">验证码:</td><td><input type="text" name="VerificationCode" id="user_identify" value=${VerificationCode} valType="required" msg="<font color=red>*</font>密码不能为空" />
			<span><img src="VerificationCodeServlet"
						    onclick="javascript:refresh(this);" alt="" width="75" height="24" /></span>
			
			</td>
		</tr>
		</c:if>
		
		<tr>
			<td></td>
			<td><input type="submit" id="login_button" value="登录"/>&nbsp;&nbsp;
				<input type="reset" value="清空" /></td>
			<td></td>
			<td><a href="">忘记密码？</a></td>
		</tr>
		</table>
         
           <c:if test="${param.type=='return'}" var="res4" scope="page">
              <span>${error}</span>
            </c:if>
              
</form></div>
</div>
</div>

</body>
</html>
