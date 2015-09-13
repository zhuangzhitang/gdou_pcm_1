<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="net.itaem.factory.*"%>
<%@page import="net.itaem.po.*"%>
<%@page import="net.itaem.dao.IDAO.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="renderer" content="webkit"/>
<link rel="stylesheet" href="css/index_style.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<script type="text/javascript" src="js/jquery-1.6.1.min.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<title>订票系统--主页</title>

<script>
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
        xmlHttp.open("POST","GetMessageNumberServlet");
        
        xmlHttp.onreadystatechange=checkUseridCallback;
        xmlHttp.send(null);
     }
     function checkUseridCallback(){
        if(xmlHttp.readyState==4){
        if(xmlHttp.status==200){
        var message=xmlHttp.responseText;
       
        if(message=="0"){
           document.getElementById("unEnter").style.display="block";
           document.getElementById("Enter").style.display="none";
           
           
     
        }
        else{
            var m=message.split("|");
            document.getElementById("unEnter").style.display="none";
            document.getElementById("Enter").style.display="block";
            document.getElementById("username").innerHTML=m[0];
            
            if(m[1]!=0){
               
               document.getElementById("num").innerHTML=m[1];
               
            }
             else{
             document.getElementById("num").innerHTML="";
             }
        }
       }
       } 
        
     } 
     
 </script>
  

<style>
body{
      background-image:url(image/bg.jpg);
 }
</style>   

</head>
<body>
   <header>
        	<div class="toolbar">
				<ul>
                
                 <div style="display:block" id="unEnter">
                 <li>您好！</li>
                
                <li><a href="login.jsp?type=enter&tiaozhuang=index" id="login" target="iframe">登录</a></li>
                <li><a href="register.jsp" target="iframe">注册</a></li>
                </div>
             
                <div style="display:none" id="Enter">
                 <li>您好！</li>
                 <li id="username"></li>
                 <li><a href="ExitUserServlet">安全退出</a></li>
                  </div>
                </ul>
            </div>
            <div class="headLogo">
            <img src="image/logo.png" width="100%" height="220px" />
            </div>
            <nav class="head_nav">
            	<ul>
                	<li><a href="main.jsp" target ="iframe" class="nav_selected"  onclick="checkhaveuser()" >首页</a></li>
                    <li><a href="FindTicketServlet?type=show" target="iframe" onclick="checkhaveuser()">网上购票</a></li>
                    <li><a href="ShowNoteServlet?type=fenye&pageNow=1" target="iframe" onclick="checkhaveuser()">拼车论坛</a></li>
                    <li><a href="PersonShowServlet?type=show" target="iframe" onclick="checkhaveuser()">会员中心</a><span class="haha" id="num"></span></li> 
                 
                     
                     
                    <li><a href="NewServlet?type=fenye&pageNow=1" target="iframe" onclick="checkhaveuser()">新闻公告</a></li>
                    <li><a href="helpCenter.jsp" target="iframe" onclick="checkhaveuser()">帮助中心</a></li>
                     
                </ul>
            </nav>
            <div class="attention">
            【公告栏】<a href="#">海大订票系统即将上线</a>
            		<a href="#" style="display:none;">海大订票系统即将上线</a>
            </div>
        </header>
	<div class="page">
    	
      	 <div class="targe">
        	<iframe src="main.jsp" id="iframe" name="iframe" frameborder="0" width="100%"   scrolling="no" ></iframe>
        </div>
       
        <div class="footer">
        <hr/>
        <p>版权所有&copy;2014 广东海洋大学 实验基地 ITAEM 团队</p>
        </div>
    </div>
   
</body>
</html>
