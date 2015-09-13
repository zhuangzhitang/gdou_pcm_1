<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="renderer" content="webkit" />
 
<title>会员注册</title>
<script type="text/javascript" src="http://ajax.useso.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<script type="text/javascript" src="js/jquery.poshytip.js" ></script>
<script type="text/javascript" src="js/jq.validate.js" ></script>
<script type="text/javascript" src="js/index.js" ></script>
<link rel="stylesheet" type="text/css" href="css/reset.css" />
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" type="text/css" href="css/tip-yellowsimple.css" />
<style>
.center{
	width:913px;
	margin-top:2em;
	padding-bottom:1em;
	background:white;
	/*border-radius:0.5em;
	padding:1em 1em;*/
	}
h3{
	width:900px;
	font-weight:bold;
	margin:0;
	font-size:1.3em;
	padding:0.5em;
	float:left;
	color:white;
	background:#383FD8;
	}
.labels{
 text-align:left;
 width:25%;
 }
table{
text-align:left;
margin-top:3em;
}
 input[type=submit]{ 
    width:3em;
	height:1.5em;
	background:#383FD8;
	font-size:1.7em;
	border-radius:0.4em;
 }
  input[type=reset]{ 
    width:3em;
	height:1.5em;
	background:#ccc;
	font-size:1.7em;
	border-radius:0.4em;
 }
</style>
<script type="text/javascript">
     var xmlHttp;
     function createxmlHttp(){
        if(window.XMLHttpRequest){
          xmlHttp=new XMLHttpRequest();
        }
        else{
          xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
     
     }
     function checkhaveuser(){
        createxmlHttp();
        var e=document.getElementById("d").elements;
        
        //alert(e[1].value);
        xmlHttp.open("POST","GetRegisterLinkServlet?user_name="+e[0].value+"&truename="+e[1].value+"&email="+
                      e[2].value+"&idcard="+e[3].value+"&password="+e[4].value+"&phone="+e[6].value+"&shortphone="+e[7].value);
        xmlHttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
        xmlHttp.onreadystatechange=checkUseridCallback;
        xmlHttp.send(null);
     }
     function checkUseridCallback(){
        if(xmlHttp.readyState==4){
          if(xmlHttp.status==200){
            var message=xmlHttp.responseText;
            
             alert(message);
           }
       } 
        
     }
        function returnb(){
           return false;
        }
   
    
     function checkuser(username){
        createxmlHttp();
        xmlHttp.open("POST","CheckIsExitServlet?type=name&username="+username);
        
        xmlHttp.onreadystatechange=checkUseridCallback1;
        xmlHttp.send(null);
        document.getElementById("user").innerHTML="正在验证中。。。";
     
     }
     function checkUseridCallback1(){
        if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
        var message=xmlHttp.responseText;
       
        if(message=="0"){
          document.getElementById("user").innerHTML="该用户名已存在，请重置";
     
        }
        else if(message=="1"){
           document.getElementById("user").innerHTML="该用户名可以注册";
     
        }
       }
       } 
        
     }
     function checkEmail(email){
        createxmlHttp();
        xmlHttp.open("POST","CheckIsExitServlet?type=mail&email="+email);
        
        xmlHttp.onreadystatechange=checkUseridCallback2;
        xmlHttp.send(null);
        document.getElementById("email").innerHTML="正在验证中。。。";
     
     }
     function checkUseridCallback2(){
        if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
        var message=xmlHttp.responseText;
       
        if(message=="2"){
          document.getElementById("email").innerHTML="该邮箱已存在，请重置";
     
        }
        else if(message=="3"){
           document.getElementById("email").innerHTML="该邮箱可以注册";
     
        }
       }
       } 
        
     }
        
  
  </script>

</head>

<body>
<div class="center">
<h3>欢迎您注册会员</h3>
<form  type="validate" action="index.jsp" method="post" onsubmit="return returnb()" id="d" >
	<div align="center">
		
		<br />
		<table width="70%" border="0">
		<tr>
			<td class="labels">用户名:</td><td><input type="text" id="user_name" name="username" valType="required" onblur="checkuser(this.value)" msg="<font color=red>*</font>用户名不能为空" /><span id="user"></span></td>
		</tr>
		<tr>
			<td class="labels">真实姓名:</td><td><input type="text" name="truename" id="user_realname"  valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
		<tr>
			<td class="labels">电子邮箱:</td><td><input type="text" name="email" id="user_email" valType="MAIL" onblur="checkEmail(this.value)" msg="<font color=red>*</font>电子邮箱格式不正确" /><span id="email"></span></td>
		</tr>
        <tr>
			<td class="labels">身份证号:</td><td><input type="text" name="idcard" id="user_email" valType="ID" msg="<font color=red>*</font>身份证号格式不正确" /></td>
		</tr>
        <tr>
			<td class="labels">密码:</td><td><input type="password" name="password" id="user_pwd" valType="required" msg="<font color=red>*</font>密码不能为空" /></td>
		</tr>
        <tr>
			<td class="labels">确认密码:</td><td><input type="password" name="user_repwd" id="user_repwd" valType="repwd" msg="<font color=red>*</font>两次输入密码不一致" /></td>
		</tr>
        <tr>
			<td class="labels">手机号码:</td><td><input type="text" name="phone" id="user_phone" valType="MOBILE" msg="<font color=red>*</font>手机格式不正确" /></td>
		</tr>
		<tr>
			<td class="labels">短号:</td><td><input type="text" name="shortphone" id="nember" valType="NUMBER" msg="<font color=red>*</font>验证码只能是数字" /></td>
		</tr>
		
		<tr>
			<td></td>
			<td><input type="submit" value="注册" onclick="checkhaveuser()"/>
			&nbsp;&nbsp;
				<input type="reset" value="清空" />
			</td>
		</tr>
		</table>
	</div>
</form>
</div>
</body>
</html>


